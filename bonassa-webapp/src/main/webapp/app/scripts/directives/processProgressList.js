'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processprogresslist
 * @description
 * # processprogresslist
 */
angular.module('webappApp')
  .directive('processProgressList', function () {
    return {
        templateUrl: 'views/processProgress/progressList.html',
        restrict: 'E'
    };
  });
