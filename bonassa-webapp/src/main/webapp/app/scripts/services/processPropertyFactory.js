'use strict';

/**
 * @ngdoc service
 * @name webappApp.processPropertyFactory
 * @description
 * # processPropertyFactory
 * Factory in the webappApp.
 */
angular.module('webappApp')
  .factory('processPropertyFactory',
			[
				'$http',
				'SessionService',
				'$rootScope',
				'$cookies',
				'$cookieStore',
				function($http, SessionService, $rootScope, $cookies,
						$cookieStore) {

					$rootScope.property = {};

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
						ProcessPropertyList : function(process) {
							var params = {
									processDto : {
										id : process.id,
									},
									userDto : SessionService.getUser(),
							};

							delete params.userDto.pictureId;

							return doRequest('../rest/process/listProperty',
									params, 'POST');
						},
						ProcessPropertyNew : function(processProperty) {
							var params = {};
							
							params = processProperty;

							console.log(params);

							return doRequest('../rest/process/insertProperty',
									params, 'POST');
						},
						ProcessPropertyUpdate : function(processProperty) {
							var params = {};
							
							params = processProperty;	

							delete params.distinct;
							
							delete params.criterions;

							console.log(params);

							return doRequest('../rest/process/updateProperty', params,
									'POST');
						},
					}
				} ]);
