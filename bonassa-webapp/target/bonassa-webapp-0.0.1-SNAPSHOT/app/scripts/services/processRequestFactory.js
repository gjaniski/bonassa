'use strict';

/**
 * @ngdoc service
 * @name webappApp.processRequestFactory
 * @description
 * # processRequestFactory
 * Factory in the webappApp.
 */
angular.module('webappApp')
  .factory('processRequestFactory',
			[
				'$http',
				'SessionService',
				'$rootScope',
				'$cookies',
				'$cookieStore',
				function($http, SessionService, $rootScope, $cookies,
						$cookieStore) {

					$rootScope.request = {};

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
						ProcessRequestList : function(process) {
							var params = {
									processDto : {
										id : process.id,
									},
									userDto : SessionService.getUser(),
							};

							delete params.userDto.pictureId;

							return doRequest('../rest/process/listRequest',
									params, 'POST');
						},
						ProcessRequestNew : function(processRequest) {
							var params = {};
							
							params = processRequest;

							console.log(params);

							return doRequest('../rest/process/insertRequest',
									params, 'POST');
						},
						ProcessRequestUpdate : function(processRequest) {
							var params = {};
							
							params = processRequest;	

							delete params.distinct;
							
							delete params.criterions;

							console.log(params);

							return doRequest('../rest/process/updateRequest', params,
									'POST');
						},
					}
				} ]);