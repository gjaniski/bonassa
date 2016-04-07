'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:OpponentviewCtrl
 * @description
 * # OpponentviewCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('OpponentViewCtrl',['$scope', '$routeParams', '$location', function ($scope, $routeParams, $location) {
		  
	$scope.hideInputs = true;
	$scope.tag = 'Visualização da Parte Adversa';
	$scope.opponent = $routeParams.opponent;
	console.log($scope.opponent);
	
	$scope.edit = function(){ 
		$location.path("/opponent/edit").search({
			opponent : $scope.opponent
		});		
	};
	
	$scope.exit = function() {
		$location.path("/opponent/list").search({});
	};	
	  
  }]);
