'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:CustomerlistCtrl
 * @description
 * # CustomerlistCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('CustomerListCtrl',['$scope', 'customerFactory', '$location', function ($scope, customerFactory, $location) {
	
	$scope.customer = {};
	$scope.list = [];
	$scope.selectedRow = null;
	  
	customerFactory.CustomerList().success(function(params) {
		$scope.list = params;
		console.log($scope.list);
	});	
	
	$scope.setClickedRow = function(index) {
		$scope.selectedRow = index;
	};	

	$scope.setCustomer = function(customer) {
		$scope.customer = customer;
		console.log(customer);
	};

	$scope.newCustomer = function() {
		$location.path("/customer/new").search({});
	};
	
	$scope.editCustomer = function() { 
		$location.path("/customer/edit").search({
			customer : $scope.customer
		});
	};
	
	$scope.viewCustomer = function() {
		$location.path("/customer/view").search({
			customer : $scope.customer
		});		
	};
	
  }]);
