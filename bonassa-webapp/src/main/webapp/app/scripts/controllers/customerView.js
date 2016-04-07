'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:CustomerviewCtrl
 * @description
 * # CustomerviewCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('CustomerViewCtrl', ['$scope','$routeParams', '$location', function ($scope, $routeParams, $location) {
	  
	$scope.hideInputs = true;
	$scope.tag = 'Visualização do Cliente';
	$scope.customer = $routeParams.customer;
	console.log($scope.customer);
	
	$scope.edit = function(){ 
		$location.path("/customer/edit").search({
			customer : $scope.customer
		});		
	};
	
	$scope.exit = function() {
		$location.path("/customer/list").search({});
	};	
		  
}]);
