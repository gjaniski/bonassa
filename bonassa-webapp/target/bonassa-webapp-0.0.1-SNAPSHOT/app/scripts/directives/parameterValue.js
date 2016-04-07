'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:parameterValue
 * @description
 * # parameterValue
 */
angular.module('webappApp')
  .directive('parameterValue', function () {
    return {
        templateUrl: 'views/parameter/parameterValue.html',
        restrict: 'E'
    };
  });
