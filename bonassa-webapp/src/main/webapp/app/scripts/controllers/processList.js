'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:ProcesslistCtrl
 * @description
 * # ProcesslistCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('ProcessListCtrl',['$scope', '$rootScope', '$location', '$modal', 'ProcessFactory', 'ProcessService' ,function ($scope, $rootScope, $location, $modal, ProcessFactory, ProcessService) {
	  
	$scope.processList = [];
	  
	$scope.showRightSidebar = 'withoutRightSpace';
	$scope.selectedRow = null;
	
	init();
	
	function init(){
//		ProcessFactory.ProcessList().then(function(params) {
//			$scope.list = params.data;
//		});
		
		ProcessService.list().then(function(data) {
			$scope.list = data.data;
			console.log(data);
			console.log($scope.list);			
		});
	};
	
	$scope.setClickedRow = function(index) {
//		$scope.showRightSidebar = 'withRightSpace';
		$scope.selectedRow = index;
	};
	
	$scope.loadValues = function(process) {
		$scope.process = process;
		
		$rootScope.$broadcast('rightSidebar:updated', $scope.process, $scope.list);
	};
	
	$scope.newProcess = function() {
		$location.path("/process/new").search({});
	};
	
	$scope.editProcess = function() { 
		$location.path("/process/edit").search({
			process : $scope.process
		});
	};
	
	$scope.viewProcess = function() {
		$location.path("/process/view").search({
			process : $scope.process
		});		
	};

  }]);
