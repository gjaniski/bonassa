'use strict';

describe('Directive: processAgenda', function () {

  // load the directive's module
  beforeEach(module('webappApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<process-agenda></process-agenda>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the processAgenda directive');
  }));
});
