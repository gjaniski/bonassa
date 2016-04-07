'use strict';

describe('Controller: ReportsadvancedCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var ReportsadvancedCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ReportsadvancedCtrl = $controller('ReportsadvancedCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
