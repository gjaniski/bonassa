'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:navbar
 * @description
 * # navbar
 */
angular.module('webappApp')
  .directive('navbar', function () {
    return {
        templateUrl: 'views/navbar/navbar.html',
        restrict: 'E'
    };
  });
