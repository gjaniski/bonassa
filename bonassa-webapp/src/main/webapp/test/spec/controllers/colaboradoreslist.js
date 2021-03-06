'use strict';

describe('Controller: ColaboradoreslistCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ColaboradoreslistCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ColaboradoreslistCtrl = $controller('ColaboradoreslistCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
