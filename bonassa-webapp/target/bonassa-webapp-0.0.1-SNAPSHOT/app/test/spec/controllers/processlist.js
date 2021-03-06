'use strict';

describe('Controller: ProcesslistCtrl', function () {

  // load the controller's module
  beforeEach(module('appApp'));

  var ProcesslistCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProcesslistCtrl = $controller('ProcesslistCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
