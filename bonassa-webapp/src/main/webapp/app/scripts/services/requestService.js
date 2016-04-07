'use strict';

/**
 * @ngdoc service
 * @name webappApp.requestService
 * @description
 * # requestService
 * Service in the webappApp.
 */
angular.module('webappApp')
  .factory('requestService', function ($http) {
//	  return{
//		  doRequest : function(url, params, method) {
//				if (params != null) {
//					if (method == 'GET') {
//						return $http({
//							method : method,
//							url : url,
//							params : params
//						});
//					} else {
//						return $http({
//							method : method,
//							url : url,
//							data : params
//						});
//					}
//				} else {
//					return $http({
//						method : method,
//						url : url
//					});
//				}
//			}
//	  }
	  
	  return {
			doRequest : function(url, params, method) {

//		        progressbar.start();
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
	  
  });
