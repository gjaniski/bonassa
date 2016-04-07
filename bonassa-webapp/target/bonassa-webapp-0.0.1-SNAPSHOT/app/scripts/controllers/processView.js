'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:ProcessviewCtrl
 * @description
 * # ProcessviewCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('ProcessViewCtrl',['$scope', '$routeParams', '$location', function ($scope, $routeParams, $location) {
	  
	$scope.hideInputs = true;
	$scope.tag = 'Visualização do Processo nº ';
	$scope.process = $routeParams.process;
	console.log($scope.process);
	
	/** *********TABS********* */

	$scope.tabs = [ {
		title : 'Principal',
		url : 'one'
	}, {
		title : 'Dados Extras',
		url : 'two'
	} ];

	$scope.currentTab = 'one';

	$scope.showTab = true;

	$scope.onClickTab = function(tab) {

		if ($scope.currentTab != tab.url) {
			$scope.showTab = !$scope.showTab;
		}
		$scope.currentTab = tab.url;
	}

	$scope.isActiveTab = function(tabUrl) {
		return tabUrl == $scope.currentTab;
	}

	/** *********************** */
	
	$scope.setRadiosToString = function() {
		$scope.process.instance = $scope.process.instance.toString();
		$scope.process.activePassiveProcess = $scope.process.activePassiveProcess.toString();
		$scope.process.lossProb = $scope.process.lossProb.toString();
		$scope.process.endResult = $scope.process.endResult.toString();
	};

	$scope.setRadiosToString();
	
	$scope.edit = function(){ 
		$location.path("/process/edit").search({
			process : $scope.process
		});		
	};
	
	$scope.exit = function() {
		$location.path("/process/list").search({});
	};	
	  
  }]);
