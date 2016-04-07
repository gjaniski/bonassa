'use strict';

/**
 * @ngdoc service
 * @name webappApp.processAgendaFactory
 * @description # processAgendaFactory Factory in the webappApp.
 */
angular.module('webappApp').factory(
		'processAgendaFactory',
		[
				'$http',
				'SessionService',
				'$rootScope',
				'$cookies',
				'$cookieStore',
				function($http, SessionService, $rootScope, $cookies,
						$cookieStore) {

					$rootScope.agenda = {};

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
						ProcessAgendaList : function(process) {
							var params = {
									processDto : {
										id : process.id,
									},
									userDto : SessionService.getUser(),
							};	

							delete params.userDto.pictureId;
							
							return doRequest('../rest/process/listAppointment',
									params, 'POST');
						},
						ProcessAgendaNew : function(agenda) {
							var params = {};	
							
							params = agenda;

							params.creator = SessionService.getUser();
							
							console.log(params);

							return doRequest('../rest/process/insertAppointment',
									params, 'POST');
						},
						ProcessAgendaUpdate : function(processAppointment) {
							var params = {};
							
							params = processAppointment;	

							delete params.distinct;
							
							delete params.criterions;

							console.log(params);

							return doRequest('../rest/process/updateAppointment', params,
									'POST');
						},
					}
				} ]);