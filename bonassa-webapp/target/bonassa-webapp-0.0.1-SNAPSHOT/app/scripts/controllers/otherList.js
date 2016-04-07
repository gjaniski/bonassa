'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:OtherlistCtrl
 * @description
 * # OtherlistCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('OtherListCtrl',['$scope', 'otherFactory', '$location', function ($scope, otherFactory, $location) {
		
		$scope.other = {};
		$scope.list = [];
		$scope.selectedRow = null;
		  
		otherFactory.OtherList().success(function(params) {
			$scope.list = params;
			console.log($scope.list);
		});	
		
		$scope.setClickedRow = function(index) {
			$scope.selectedRow = index;
		};	

		$scope.setOther = function(other) {
			$scope.other = other;
			console.log(other);
		};

		$scope.newOther = function() {
			$location.path("/other/new").search({});
		};
		
		$scope.editOther = function() { 
			$location.path("/other/edit").search({
				other : $scope.other
			});
		};
		
		$scope.viewOther = function() {
			$location.path("/other/view").search({
				other : $scope.other
			});		
		};
		
	  }]);
