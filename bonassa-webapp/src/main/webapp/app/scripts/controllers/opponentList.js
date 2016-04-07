'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:OpponentlistCtrl
 * @description
 * # OpponentlistCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('OpponentListCtrl',['$scope', 'opponentFactory', '$location', function ($scope, opponentFactory, $location) {
	  
	$scope.opponent = {};
	$scope.list = [];
	$scope.selectedRow = null;
	  
	opponentFactory.OpponentList().success(function(params) {
		$scope.list = params;
	});
	
	$scope.setClickedRow = function(index) {
		$scope.selectedRow = index;
	};	

	$scope.setOpponent = function(opponent) {
		$scope.opponent = opponent;
		console.log(opponent);
	};

	$scope.newOpponent = function() {
		$location.path("/opponent/new").search({});
	};
	
	$scope.editOpponent = function() { 
		$location.path("/opponent/edit").search({
			opponent : $scope.opponent
		});
	};
	
	$scope.viewOpponent = function() {
		$location.path("/opponent/view").search({
			opponent : $scope.opponent
		});		
	};
		
  }]);
