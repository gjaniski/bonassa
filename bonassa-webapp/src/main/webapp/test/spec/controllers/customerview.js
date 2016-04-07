'use strict';

describe('Controller: CustomerviewCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var CustomerviewCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CustomerviewCtrl = $controller('CustomerviewCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
