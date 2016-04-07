'use strict';

describe('Controller: ParametersCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ParametersCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ParametersCtrl = $controller('ParametersCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
