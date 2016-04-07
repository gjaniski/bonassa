'use strict';

/**
 * @ngdoc directive
 * @name webappApp.directive:processAppointmentList
 * @description
 * # processAppointmentList
 */
angular.module('webappApp')
  .directive('processAppointmentList', function () {
    return {
        templateUrl: 'views/processAgenda/appointmentList.html',
        restrict: 'E'
    };
  });
