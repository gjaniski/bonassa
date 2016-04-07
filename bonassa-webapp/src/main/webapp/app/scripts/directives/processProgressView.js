'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processprogressview
 * @description
 * # processprogressview
 */
angular.module('webappApp')
  .directive('processProgressView', function () {
    return {
        templateUrl: 'views/processProgress/progressView.html',
        restrict: 'E'
    };
  });
