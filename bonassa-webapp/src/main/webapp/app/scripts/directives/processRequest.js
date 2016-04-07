'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processRequest
 * @description
 * # processRequest
 */
angular.module('webappApp')
  .directive('processRequest', function () {
    return {
        templateUrl: 'views/processRequest/request.html',
        restrict: 'E'
    };
  });
