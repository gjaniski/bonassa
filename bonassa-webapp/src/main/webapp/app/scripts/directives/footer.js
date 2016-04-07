'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:footer
 * @description
 * # footer
 */
angular.module('webappApp')
  .directive('footer', function () {
    return {
      templateUrl: 'views/footer/footer.html',
      restrict: 'E'
    };
  });
