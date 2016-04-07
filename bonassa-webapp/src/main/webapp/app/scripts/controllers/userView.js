'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:UserviewCtrl
 * @description
 * # UserviewCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('UserViewCtrl', ['$scope','$routeParams', '$location', function ($scope, $routeParams, $location) {
	  
		$scope.hideInputs = true;
		$scope.tag = 'Visualização do Usuário';
		$scope.user = $routeParams.user;
		
		for(var i = 0; i < $scope.user.groups.length; i++){
			if($scope.user.groups[i].id == 5)
				$scope.user.groups[i].name = 'Administrador(a)';
			else{
				if($scope.user.groups[i].id == 6)
					$scope.user.groups[i].name = 'Secretário(a)';
			}
		}
		console.log($scope.user);
		
		$scope.edit = function(){ 
			$location.path("/user/edit").search({
				user : $scope.user
			});		
		};
		
		$scope.exit = function() {
			$location.path("/user/list").search({});
		};	
			  
	}]);