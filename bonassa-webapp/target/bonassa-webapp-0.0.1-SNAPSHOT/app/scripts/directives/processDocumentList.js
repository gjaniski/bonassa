'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processDocumentList
 * @description
 * # processDocumentList
 */
angular.module('webappApp')
  .directive('processDocumentList', function () {
    return {
        templateUrl: 'views/processDocument/documentList.html',
        restrict: 'E'
    };
  });
