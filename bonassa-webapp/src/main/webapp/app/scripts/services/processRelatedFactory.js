'use strict';

/**
 * @ngdoc service
 * @name webappApp.processRelatedFactory
 * @description # processRelatedFactory Factory in the webappApp.
 */
angular.module('webappApp').factory(
		'processRelatedFactory',
		[
				'$http',
				'SessionService',
				'$rootScope',
				'$cookies',
				'$cookieStore',
				function($http, SessionService, $rootScope, $cookies,
						$cookieStore) {

					$rootScope.related = {};

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
						ProcessRelatedList : function(process) {
							var params = {
								processDto : {
									id : process.id,
								},
								userDto : SessionService.getUser(),
							};

							delete params.userDto.pictureId;

							return doRequest('../rest/process/listAttached',
									params, 'POST');
						},
						ProcessRelatedNew : function(process, attached) {
							var params = {
								parentProcess : {
									id : process.id,
								},
								childProcess : {
									id : attached.id,
								},
							};

							return doRequest('../rest/process/insertAttached',
									params, 'POST');
						},
						ProcessRelatedDelete : function(related) {
														
							var params = {
								parentProcess : {
									id : related.parentProcess.id,
								},
								childProcess : {
									id : related.childProcess.id,
								},
								id : related.id,
							};

							return doRequest('../rest/process/deleteAttached',
									params, 'POST');
						},
					}
				} ]);
