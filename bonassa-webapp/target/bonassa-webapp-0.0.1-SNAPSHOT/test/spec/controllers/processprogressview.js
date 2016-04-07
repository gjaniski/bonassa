'use strict';

describe('Controller: ProcessprogressviewCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ProcessprogressviewCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProcessprogressviewCtrl = $controller('ProcessprogressviewCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
