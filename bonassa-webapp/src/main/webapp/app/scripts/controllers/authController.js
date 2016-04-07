'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:BensprocessoCtrl
 * @description # BensprocessoCtrl Controller of the webappApp
 */
angular.module('webappApp').controller('AuthCtrl',
	function(SessionService, $scope, authService) {

		var user = SessionService.getUser();

		$scope.isAuthenticated = authService.isAuthoraized();

		if (user != null)
			$scope.isAuthenticated = true;

	});
