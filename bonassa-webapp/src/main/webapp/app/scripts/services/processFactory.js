'use strict';

/**
 * @ngdoc service
 * @name webappApp.processfactory
 * @description # processfactory Factory in the webappApp.
 */
angular.module('webappApp').factory(
		'ProcessFactory',
		[
				'$http',
				'SessionService',
				'$rootScope',
				'$cookies',
				'$cookieStore',
				'$modal',
				'requestService',
				function($http, SessionService, $rootScope, $cookies,
						$cookieStore, $modal, requestService, $scope) {

					var doRequest = function(url, params, method) {
						if (params != null) {
							if (method == 'GET') {
								return $http({
									method : method,
									url : url,
									params : params
								});
							} else {
								return $http({
									method : method,
									url : url,
									data : params
								});
							}
						} else {
							return $http({
								method : method,
								url : url
							});
						}
					}

					return {

						ProcessList : function() {
							return requestService.doRequest(
									'../rest/process/list', null, 'GET');
						},
						NewProcess : function(process) {
							var params = {};

							params = process;
							
							params.creator = SessionService.getUser();

							delete params.creator.pictureId;
							
							for(var i = 0; i < params.processCustomer.length; i++){
								if(params.processCustomer[i].partner != undefined){
									delete params.processCustomer[i].partner.ticket;
									delete params.processCustomer[i].partner.userDto;
									params.processCustomer[i].partnerType = 'processCustomer';
								}
							}

							for(var i = 0; i < params.processOpponent.length; i++){
								if(params.processOpponent[i].partner != undefined){
									delete params.processOpponent[i].partner.ticket;
									delete params.processOpponent[i].partner.userDto;
									params.processOpponent[i].partnerType = 'processOpponent';
								}
							}

							for(var i = 0; i < params.processOther.length; i++){
								if(params.processOther[i].partner != undefined){
									delete params.processOther[i].partner.ticket;
									delete params.processOther[i].partner.userDto;
									params.processOther[i].partnerType = 'processOther';
								}
							}
							
							for(var i = 0; i < params.owners.length; i++){
								if(params.owners[i] != undefined){
									delete params.owners[i].distinct;
								}
							}

							console.log(params);

							return doRequest('../rest/process/insert', params, 'POST');							
						},
						UpdateProcess : function(process) {
							var params = {};

							params = process;
							
							params.creator = SessionService.getUser();

							delete params.creator.pictureId;
							
							for(var i = 0; i < params.processCustomer.length; i++){
								delete params.processCustomer[i].partner.ticket;
								delete params.processCustomer[i].partner.userDto;
								delete params.processCustomer[i].partner.distinct;
								delete params.processCustomer[i].partner.criterions;
								params.processCustomer[i].partnerType = 'processCustomer';
							}

							for(var i = 0; i < params.processOpponent.length; i++){
								delete params.processOpponent[i].partner.ticket;
								delete params.processOpponent[i].partner.userDto;
								delete params.processOpponent[i].partner.distinct;
								delete params.processOpponent[i].partner.criterions;
								params.processOpponent[i].partnerType = 'processOpponent';
							}

							for(var i = 0; i < params.processOther.length; i++){
								delete params.processOther[i].partner.ticket;
								delete params.processOther[i].partner.userDto;
								delete params.processOther[i].partner.distinct;
								delete params.processOther[i].partner.criterions;
								params.processOther[i].partnerType = 'processOther';
							}

							console.log(params);

							return doRequest('../rest/process/update', params,
									'POST');
						},
					}

				} ]);
