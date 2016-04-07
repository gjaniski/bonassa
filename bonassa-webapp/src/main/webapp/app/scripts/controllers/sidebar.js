'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:SidebarCtrl
 * @description # SidebarCtrl Controller of the webappApp
 */
angular.module('webappApp').controller('SidebarCtrl', function($scope, $location, $route) {
	
		$scope.activePath = null;
		$scope.$on('$routeChangeSuccess', function(){
			$scope.activePath = $location.path();
//					console.log( $location.path());
		});
			
	});
