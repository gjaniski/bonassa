'use strict';

describe('Controller: ProcesscontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ProcesscontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProcesscontrollerCtrl = $controller('ProcesscontrollerCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
