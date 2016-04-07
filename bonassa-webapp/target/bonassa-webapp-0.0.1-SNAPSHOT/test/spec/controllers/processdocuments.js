'use strict';

describe('Controller: ProcessdocumentsCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ProcessdocumentsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProcessdocumentsCtrl = $controller('ProcessdocumentsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
