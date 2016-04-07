'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processRelatedList
 * @description
 * # processRelatedList
 */
angular.module('webappApp')
  .directive('processRelatedList', function () {
    return {
        templateUrl: 'views/processRelated/relatedList.html',
        restrict: 'E'
    };
  });
