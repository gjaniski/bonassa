'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processAppointment
 * @description
 * # processAppointment
 */
angular.module('webappApp')
  .directive('processAppointment', function () {
    return {
        templateUrl: 'views/processAgenda/appointment.html',
        restrict: 'E'
    };
  });
