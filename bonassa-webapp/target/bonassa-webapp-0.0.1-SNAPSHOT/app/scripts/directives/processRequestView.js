'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processRequestView
 * @description
 * # processRequestView
 */
angular.module('webappApp')
  .directive('processRequestView', function () {
    return {
        templateUrl: 'views/processRequest/requestView.html',
        restrict: 'E'
    };
  });
