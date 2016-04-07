'use strict';

/**
 * @ngdoc service
 * @name webappApp.parameterService
 * @description # parameterService Service in the webappApp.
 */
angular.module('webappApp').service('parameterService',
		[ '$http', function($http) {
			var doRequest = function(url, params, method) {
				if (params != null) {
					if (method == 'GET') {
						return  $http({
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
				getParams : function() {
					return doRequest('../rest/parameter/list', null, 'GET');
				},
				insertValue : function(param, value) {
					var params = {};
					params.paramId = param.id;
					if (value.parent != null)
						params.parentId = value.parent.id;
					params.value = value.value;
					console.log(params);
					
					return doRequest('../rest/parameter/insertValue', params, 'GET');
				},
				updateValue : function(param, value) {
					var params = {};
					params.paramId = value.id;
					if (value.parent != null)
						params.parentId = value.parent.id;
					params.value = value.value;
					console.log(params);
					return doRequest('../rest/parameter/updateValue', params, 'GET');
				}
			}
		} ]);