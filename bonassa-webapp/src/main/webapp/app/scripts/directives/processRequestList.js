'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processRequestList
 * @description
 * # processRequestList
 */
angular.module('webappApp')
  .directive('processRequestList', function () {
    return {
        templateUrl: 'views/processRequest/requestList.html',
        restrict: 'E'
    };
  });
