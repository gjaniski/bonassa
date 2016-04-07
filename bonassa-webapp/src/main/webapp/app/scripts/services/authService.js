'use strict';

/**
 * @ngdoc service
 * @name loginAppApp.authService
 * @description # authService Service in the loginAppApp.
 */
angular.module('webappApp').service(
		'authService',
		function($rootScope, $http, SessionService, $cookies, $cookieStore) {

			$rootScope.user = {};
			
			$rootScope.isAuthenticated = false;

			var doRequest = function(url, params, method) {
				// console.log(params);
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

			this.login = function() {
				var params = {};
				params.login = $rootScope.user.login;
				params.password = $rootScope.user.password;
				doRequest('../rest/authorization/login', params, 'GET')
						.success(function(data) {
							console.log(data);
							SessionService.create(data);
							$rootScope.isAuthenticated = true;
							window.location.reload();
						}).error(function(data) {
							console.log('WebService Desconectado ou Login Errado');
							$rootScope.isAuthenticated = false;
							
						});
			}

			this.logout = function() {
				SessionService.destroy();
				$rootScope.isAuthenticated = false;
				window.location.reload();
			}

			this.isAuthoraized = function() {

				if ($rootScope.isAuthenticated)
					return true;
				return false;
			}

		});
