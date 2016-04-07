'use strict';

/**
 * @ngdoc service
 * @name webappApp.RequestService
 * @description
 * # RequestService
 * Factory in the webappApp.
 */
angular.module('webappApp').factory('RequestService', [ '$log', '$http', function($log, $http) {
	var service = this;
					
	return {
		doRequest : function(url, params, method) {

			if (method == 'GET') {
				if (params != null)
					return $http({
						url : url,
						method : method,
						params : params,
					});
				else
					return $http({
						url : url,
						method : method
					});
			} else {
				if (params != null)
					return $http({
						url : url,
						method : method,
						data : params
					});
				else
					return $http({
						url : url,
						method : method
					});
			}
		}
	};
	
} ]);