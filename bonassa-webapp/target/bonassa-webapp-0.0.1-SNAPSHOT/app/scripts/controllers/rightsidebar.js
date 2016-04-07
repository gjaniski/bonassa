'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:RightsidebarCtrl
 * @description
 * # RightsidebarCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('RightsidebarCtrl', function ($scope) {
    $scope.rightSidebar = false;
    $scope.process = {};
    
    $scope.$on('rightSidebar:updated', function(event, process) {
	    $scope.rightSidebar = true;
	    $scope.process = process;
    });
    
  });
