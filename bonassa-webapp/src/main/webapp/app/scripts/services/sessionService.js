'use strict';

/**
 * @ngdoc service
 * @name webappApp.auth
 * @description # auth Service in the webappApp.
 */
angular.module('webappApp').service('SessionService', ['$cookies', '$cookieStore', function($cookies, $cookieStore) {
	
	this.create = function(user) {
//		$cookies['user'] = user;
//		$cookies.user = user;
		$cookieStore.put('user', user);
	};

	this.destroy = function() {
//		delete $cookies['user'];
//		delete $cookies.user;
		$cookieStore.remove('user');
	};

	this.getUser = function() {
//		return $cookies['user'];
		return $cookieStore.get('user');
	}

}]);
