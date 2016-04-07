'use strict';

/**
 * @ngdoc service
 * @name webappApp.parameterfactory
 * @description # parameterfactory Factory in the webappApp.
 */
angular.module('webappApp').factory('parameterFactory',
		function(requestService) {
			return {
				getParameterByName : function(name) {
					var url = "../rest/parameter/list";
					var data = {};
					// data.name = name;
					return requestService.doRequest(url, data, 'GET');
				},
				getParameterById : function(id) {
					var url = "../rest/parameter/selectById";
					var data = {};
					data.id = id;
					return requestService.doRequest(url, data, 'POST');
				}
			}
		});