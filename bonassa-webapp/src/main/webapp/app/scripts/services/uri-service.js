'use strict';

/**
 * @ngdoc service
 * @name webappApp.UriService
 * @description
 * # UriService
 * Service in the webappApp.
 */
angular.module('webappApp').service('UriService', [ '$log', function($log) {
	var service = this;

	service.getUri = function(str) {
		var parameters = str.split(':');
		var url = "../rest" + parameters[1] + parameters[2];
		$log.debug(url);
		return url;
	};
	
	return service;
} ]);
