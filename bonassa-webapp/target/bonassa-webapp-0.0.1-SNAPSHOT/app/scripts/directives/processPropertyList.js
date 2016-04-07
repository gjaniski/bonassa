'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processPropertyList
 * @description
 * # processPropertyList
 */
angular.module('webappApp')
  .directive('processPropertyList', function () {
    return {
        templateUrl: 'views/processProperty/propertyList.html',
        restrict: 'E'
    };
  });
