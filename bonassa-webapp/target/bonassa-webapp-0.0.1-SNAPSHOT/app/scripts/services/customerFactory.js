'use strict';

/**
 * @ngdoc service
 * @name webappApp.customerfactory
 * @description # customerfactory Factory in the webappApp.
 */
angular
		.module('webappApp')
		.factory(
				'customerFactory',
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
								CustomerList : function() {
									var params = {};
									params = SessionService.getUser();
									
									delete params.pictureId;

									return doRequest(
											'../rest/partner/listCustomer',
											params, 'POST');
								},
								NewCustomer : function(customer) {
									var params = {};
									
									params = customer;
									params.userDto = SessionService.getUser();

									delete params.userDto.pictureId;

									return doRequest('../rest/partner/insert',
											params, 'POST');
								},
								UpdateCustomer : function(customer) {
									var params = {};
									
									params = customer;
									params.userDto = SessionService.getUser();

									delete params.userDto.pictureId;

									return doRequest('../rest/partner/update',
											params, 'POST');
								},
							}
						} ]);