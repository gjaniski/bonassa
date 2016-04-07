'use strict';

/**
 * @ngdoc service
 * @name webappApp.opponentFactory
 * @description # opponentFactory Factory in the webappApp.
 */
angular.module('webappApp').factory(
		'opponentFactory',
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
						OpponentList : function() {
							var params = {};
							params = SessionService.getUser();

							delete params.pictureId;

							return doRequest('../rest/partner/listOpponent',
									params, 'POST');
						},
						NewOpponent : function(opponent) {
							var params = {};

							params = opponent;
							params.userDto = SessionService.getUser();

							delete params.userDto.pictureId;

							return doRequest('../rest/partner/insert', params,
									'POST');
						},
						UpdateOpponent : function(opponent) {
							var params = {};

							params = opponent;
							params.userDto = SessionService.getUser();

							delete params.userDto.pictureId;

							return doRequest('../rest/partner/update', params,
									'POST');
						},
					}
				} ]);