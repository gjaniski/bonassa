'use strict';

describe('Controller: ProcessongoinglistCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ProcessongoinglistCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProcessongoinglistCtrl = $controller('ProcessongoinglistCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
