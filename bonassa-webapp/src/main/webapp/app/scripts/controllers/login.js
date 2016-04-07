'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('LoginCtrl', ['$scope', 'authService', '$rootScope', function ($scope, authService, $rootScope) {    
		  
    $scope.login = function(){
    	authService.login('11','11');
    }
    
  }]);
