'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processProperty
 * @description
 * # processProperty
 */
angular.module('webappApp')
  .directive('processProperty', function () {
    return {
        templateUrl: 'views/processProperty/property.html',
        restrict: 'E'
    };
  });
