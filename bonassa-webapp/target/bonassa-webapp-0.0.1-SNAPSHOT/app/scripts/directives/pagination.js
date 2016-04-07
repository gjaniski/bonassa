'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:pagination
 * @description
 * # pagination
 */
angular.module('webappApp')
  .directive('pagination', function () {
    return {
      restrict: 'E',
      controller: ['$scope', function($scope) {
    	$scope.currentPage = 0;
  		$scope.pageSize = 15;
  		$scope.previousButton = true;
  		$scope.nextButton = false;
  		$scope.showPageSize = true;

  		$scope.resetPageValues = function() {
  			$scope.pageSize = 15;
  			$scope.currentPage = 0;
  			$scope.previousButton = true;
  			$scope.setShowPageSize();
  			if ($scope.totalPages < 2)
  				$scope.nextButton = false;
  			else
  				$scope.nextButton = false;
  		};

  		$scope.changePageSize = function(param) {
  			$scope.pageSize = param;
  		};

  		$scope.setShowPageSize = function() {
  			if ($scope.currentPage == 0)
  				$scope.showPageSize = true;
  			else
  				$scope.showPageSize = false;
  		};

  		$scope.numberOfPages = function() {
  			if($scope.list != undefined){
  				$scope.totalPages = Math
  						.ceil($scope.list.length
  								/ $scope.pageSize);
  				if ($scope.totalPages < 2)
  					$scope.nextButton = true;
  				else
  					$scope.nextButton = false;
  				if (($scope.currentPage + 1) == $scope.totalPages)
  					$scope.nextButton = true;
  				return $scope.totalPages;
  			}
  		};

  		$scope.previous = function() {
  			$scope.selectedRow = null;
  			$scope.buttons = true;
  			$scope.nextButton = false;
  			$scope.currentPage = $scope.currentPage - 1;
  			if ($scope.currentPage == 0)
  				$scope.previousButton = true;
  			else {
  				$scope.previousButton = false;
  			}
  			$scope.setShowPageSize();
  		};
  		$scope.next = function() {
  			$scope.selectedRow = null;
  			$scope.buttons = true;
  			$scope.previousButton = false;
  			$scope.currentPage = $scope.currentPage + 1;
  			if ($scope.currentPage == $scope
  					.numberOfPages() - 1)
  				$scope.nextButton = true;
  			else {
  				$scope.nextButton = false;
  			}
  			$scope.setShowPageSize();
  		};    	  
      }],
      templateUrl: 'views/pagination/pagination.html'
    };
  });
