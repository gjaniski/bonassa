'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:pagination2
 * @description
 * # pagination2
 */
angular.module('webappApp')
  .directive('pagination2', function () {
	    return {
	        restrict: 'E',
	        controller: ['$scope', function($scope) {
	      	$scope.currentPage2 = 0;
	    		$scope.pageSize2 = 15;
	    		$scope.previousButton2 = true;
	    		$scope.nextButton2 = false;
	    		$scope.showPageSize2 = true;

	    		$scope.resetPageValues2 = function() {
	    			$scope.pageSize2 = 15;
	    			$scope.currentPage2 = 0;
	    			$scope.previousButton2 = true;
	    			$scope.setShowPageSize2();
	    			if ($scope.totalPages2 < 2)
	    				$scope.nextButton2 = false;
	    			else
	    				$scope.nextButton2 = false;
	    		};

	    		$scope.changePageSize2 = function(param) {
	    			$scope.pageSize2 = param;
	    		};

	    		$scope.setShowPageSize2 = function() {
	    			if ($scope.currentPage2 == 0)
	    				$scope.showPageSize2 = true;
	    			else
	    				$scope.showPageSize2 = false;
	    		};

	    		$scope.numberOfPages2 = function() {
	    			if($scope.list2 != undefined){
	    				$scope.totalPages2 = Math
	    						.ceil($scope.list2.length
	    								/ $scope.pageSize2);
	    				if ($scope.totalPages2 < 2)
	    					$scope.nextButton2 = true;
	    				else
	    					$scope.nextButton2 = false;
	    				if (($scope.currentPage2 + 1) == $scope.totalPages2)
	    					$scope.nextButton2 = true;
	    				return $scope.totalPages2;
	    			}
	    		};

	    		$scope.previous2 = function() {
	    			$scope.selectedRow2 = null;
	    			$scope.buttons2 = true;
	    			$scope.nextButton2 = false;
	    			$scope.currentPage2 = $scope.currentPage2 - 1;
	    			if ($scope.currentPage2 == 0)
	    				$scope.previousButton2 = true;
	    			else {
	    				$scope.previousButton2 = false;
	    			}
	    			$scope.setShowPageSize2();
	    		};
	    		$scope.next2 = function() {
	    			$scope.selectedRow2 = null;
	    			$scope.buttons2 = true;
	    			$scope.previousButton2 = false;
	    			$scope.currentPage2 = $scope.currentPage2 + 1;
	    			if ($scope.currentPage2 == $scope
	    					.numberOfPages2() - 1)
	    				$scope.nextButton2 = true;
	    			else {
	    				$scope.nextButton2 = false;
	    			}
	    			$scope.setShowPageSize2();
	    		};    	  
	        }],
	        templateUrl: 'views/pagination/pagination2.html'
	      };
	    });
