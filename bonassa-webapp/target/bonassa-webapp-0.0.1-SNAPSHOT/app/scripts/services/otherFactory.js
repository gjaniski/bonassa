'use strict';

/**
 * @ngdoc service
 * @name webappApp.otherFactory
 * @description # otherFactory Factory in the webappApp.
 */
angular.module('webappApp').factory(
		'otherFactory',
		[
				'$http',
				'SessionService',
				'$rootScope',
				'$cookies',
				'$cookieStore',
				function($http, SessionService, $rootScope, $cookies,
						$cookieStore) {

					$rootScope.customer = {};

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
						OtherList : function() {
							var params = {};
							params = SessionService.getUser();

							delete params.pictureId;

							return doRequest('../rest/partner/listOther',
									params, 'POST');
						},
						NewOther : function(other) {
							var params = {};

							params = other;
							params.userDto = SessionService.getUser();

							delete params.userDto.pictureId;

							return doRequest('../rest/partner/insert', params,
									'POST');
						},
						UpdateOther : function(other) {
							var params = {};

							params = other;
							params.userDto = SessionService.getUser();

							delete params.userDto.pictureId;

							return doRequest('../rest/partner/update', params,
									'POST');
						},
					}
				} ]);