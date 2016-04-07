'use strict';

describe('Controller: OtherlistCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var OtherlistCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    OtherlistCtrl = $controller('OtherlistCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
