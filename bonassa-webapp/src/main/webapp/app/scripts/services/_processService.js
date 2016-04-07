/**
 * @author Douglas Cardoso
 * @name Bonassa Webapp
 */
(function() {
	angular.module('webappApp', []).factory(
			'processService',
			[
					'$http',
					'requestService',
					function($http, requestService) {
						return {
							listProcess : function() {
								return requestService.doRequest(
										'../rest/process/list', null, 'GET');
							}
						}
					} ])
})();