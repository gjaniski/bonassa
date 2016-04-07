'use strict';

describe('Controller: ClienteNovoCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ClienteNovoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ClienteNovoCtrl = $controller('ClienteNovoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
