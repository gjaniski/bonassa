'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:login
 * @description
 * # login
 */
angular.module('webappApp')
  .directive('login', function () {
    return {
        templateUrl: 'views/login/login.html',
        restrict: 'E'
    };
  });
