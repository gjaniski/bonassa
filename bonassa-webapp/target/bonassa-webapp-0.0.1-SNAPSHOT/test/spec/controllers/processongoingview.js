'use strict';

describe('Controller: ProcessongoingviewCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ProcessongoingviewCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProcessongoingviewCtrl = $controller('ProcessongoingviewCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
