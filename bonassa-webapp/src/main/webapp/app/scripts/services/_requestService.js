'use strict';

/**
 * @ngdoc service
 * @name requestAppApp.requesteService
 * @description # authService Service in the requestAppApp.
 */
angular.module('webappApp').service('requestService', function($http) {

			this.doRequest = function(url, params, method) {
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
});
