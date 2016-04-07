'use strict';

/**
 * @ngdoc service
 * @name webappApp.userFactory
 * @description # userFactory Factory in the webappApp.
 */
angular.module('webappApp').factory(
		'userFactory',
		[
				'$http',
				'SessionService',
				'$rootScope',
				'$cookies',
				'$cookieStore',
				function($http, SessionService, $rootScope, $cookies,
						$cookieStore) {

					$rootScope.user = {};

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
						UserList : function() {
							var params = {};
							params = SessionService.getUser();
							
							delete params.pictureId;

							return doRequest('../rest/user/list', params,
									'POST');
						},
						NewUser : function(user) {
							var params = {};

							params = user;
							params.userDto = SessionService.getUser();

							delete params.userDto.pictureId;
							
							return doRequest('../rest/user/insert', params,
									'POST');
						},
						UpdateUser : function(user) {
							var params = {};

							params = user;
							params.userDto = SessionService.getUser();
							
							delete params.distinct;
							delete params.userDto.pictureId;
							delete params.userDto.distinct;
							for(var i = 0; i < params.groups.length; i++){
								delete params.groups[i].distinct;
								delete params.groups[i].criterions;
								params.groups[i].userId = params.id;
							}	
							
							console.log(params);

							return doRequest('../rest/user/update', params,
									'POST');
						},
					}
				} ]);