'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processPropertyView
 * @description
 * # processPropertyView
 */
angular.module('webappApp')
  .directive('processPropertyView', function () {
    return {
        templateUrl: 'views/processProperty/propertyView.html',
        restrict: 'E'
    };
  });
