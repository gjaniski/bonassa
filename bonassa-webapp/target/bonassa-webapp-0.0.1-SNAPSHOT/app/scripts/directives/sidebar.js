'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:sidebar
 * @description
 * # sidebar
 */
angular.module('webappApp')
  .directive('sidebar', function () {
    return {
      templateUrl: 'views/sideBar-left/sidebar.html',
      restrict: 'E'
    };
  });
