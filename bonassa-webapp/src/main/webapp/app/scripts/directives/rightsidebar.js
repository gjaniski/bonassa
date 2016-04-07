'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:rightsidebar
 * @description
 * # rightsidebar
 */
angular.module('webappApp')
  .directive('rightsidebar', function () {
    return {
      templateUrl: 'views/sideBar-right/rightsidebar.html',
      restrict: 'E'
    };
  });
