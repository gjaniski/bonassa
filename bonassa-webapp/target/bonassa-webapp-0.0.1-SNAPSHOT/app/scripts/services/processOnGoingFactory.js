'use strict';

/**
 * @ngdoc service
 * @name webappApp.processongoingfactory
 * @description # processongoingfactory Factory in the webappApp.
 */
angular.module('webappApp').factory(
		'processOnGoingFactory',
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
						ProcessOnGoingList : function(process) {
							var params = {
									processDto : {
										id : process.id,
									},
									userDto : SessionService.getUser(),
							};
							
							delete params.userDto.pictureId;

							return doRequest('../rest/process/listProgress',
									params, 'POST');
						},
						ProcessOnGoingNew : function(processProgress) {
							var params = {};
							
							processProgress.creator = SessionService.getUser();
							console.log(SessionService.getUser());
//							processProgress.owners = [{id:3}, {id:5}];
							
							
							params = processProgress;
							
							console.log(params);

							return doRequest('../rest/process/insertProgress',
									params, 'POST');
						},
						ProcessOnGoingUpdate : function(processProgress) {
							var params = {};
							
							processProgress.creator = SessionService.getUser();
							
							params = processProgress;	

							delete params.distinct;
							
							delete params.criterions;

							console.log(params);

							return doRequest('../rest/process/updateProgress', params,
									'POST');
						},
					}

				} ]);
