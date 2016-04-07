'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processAppointmentView
 * @description
 * # processAppointmentView
 */
angular.module('webappApp')
  .directive('processAppointmentView', function () {
    return {
        templateUrl: 'views/processAgenda/appointmentView.html',
        restrict: 'E'
    };
  });
