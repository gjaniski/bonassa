'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:OtherviewCtrl
 * @description
 * # OtherviewCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('OtherViewCtrl',['$scope', '$routeParams', '$location', function ($scope, $routeParams, $location) {
	  
		$scope.hideInputs = true;
		$scope.tag = 'Visualização do Terceiro';
		$scope.other = $routeParams.other;
		console.log($scope.other);
		
		$scope.edit = function(){ 
			$location.path("/other/edit").search({
				other : $scope.other
			});		
		};
		
		$scope.exit = function() {
			$location.path("/other/list").search({});
		};	
		  
	  }]);