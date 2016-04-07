'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processRelated
 * @description
 * # processRelated
 */
angular.module('webappApp')
  .directive('processRelated', function () {
    return {
        templateUrl: 'views/processRelated/processList.html',
        restrict: 'E'
    };
  });
