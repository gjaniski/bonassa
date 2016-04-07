'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processprogress
 * @description
 * # processprogress
 */
angular.module('webappApp')
  .directive('processProgress', function () {
    return {
      templateUrl: 'views/processProgress/progress.html',
      restrict: 'E'
    };
  });
