'use strict';

describe('Controller: ParametercontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ParametercontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ParametercontrollerCtrl = $controller('ParametercontrollerCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
