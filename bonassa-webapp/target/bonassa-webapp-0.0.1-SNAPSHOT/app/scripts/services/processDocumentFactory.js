'use strict';

/**
 * @ngdoc service
 * @name webappApp.processDocumentFactory
 * @description
 * # processDocumentFactory
 * Factory in the webappApp.
 */
angular.module('webappApp')
  .factory('processDocumentFactory',
			[
				'$http',
				'SessionService',
				'$rootScope',
				'$cookies',
				'$cookieStore',
				'$modal',
				'requestService',
				function($http, SessionService, $rootScope, $cookies,
						$cookieStore, $modal, requestService, $scope) {

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
						ProcessDocumentList : function() {
							var params = {};
							params = SessionService.getUser();

							delete params.pictureId;

							return doRequest('../rest/partner/listCustomer',
									params, 'POST');
						},
					}

				} ]);
