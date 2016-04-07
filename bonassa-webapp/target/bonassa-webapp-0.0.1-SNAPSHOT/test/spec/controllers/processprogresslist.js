'use strict';

describe('Controller: ProcessprogresslistCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ProcessprogresslistCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProcessprogresslistCtrl = $controller('ProcessprogresslistCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
