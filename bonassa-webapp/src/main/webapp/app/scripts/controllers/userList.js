'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:UserlistCtrl
 * @description
 * # UserlistCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('UserListCtrl',['$scope', 'userFactory', '$location', '$routeParams', function ($scope, userFactory, $location, $routeParams) {
		
		$scope.user = {};
		$scope.list = [];
		$scope.selectedRow = null;
		  
		userFactory.UserList().success(function(params) {
			$scope.list = params;
//			console.log($scope.list);
		});	
		
		$scope.setClickedRow = function(index) {
			$scope.selectedRow = index;
		};	

		$scope.setUser = function(user) {
			$scope.user = user;
			console.log(user);
		};

		$scope.newUser = function() {
			$location.path("/user/new").search({});
		};
		
		$scope.editUser = function() { 
			$location.path("/user/edit").search({
				user : $scope.user
			});
		};
		
		$scope.viewUser = function() {
			$location.path("/user/view").search({
				user : $scope.user
			});		
		};
		
	  }]);