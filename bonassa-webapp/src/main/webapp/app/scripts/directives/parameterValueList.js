'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:parameterValueList
 * @description
 * # parameterValueList
 */
angular.module('webappApp')
  .directive('parameterValueList', function () {
    return {
        templateUrl: 'views/parameter/parameterValueList.html',
        restrict: 'E'
    };
  });
