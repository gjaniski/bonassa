'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:LogoutCtrl
 * @description
 * # LogoutCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('LogoutCtrl', ['$scope', 'authService', '$rootScope', function ($scope, authService, $rootScope) {    
	  
    $scope.logout = function(){
    	authService.logout();
    }
    
  }]);
