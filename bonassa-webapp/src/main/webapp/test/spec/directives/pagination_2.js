'use strict';

describe('Directive: pagination2', function () {

  // load the directive's module
  beforeEach(module('webappApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<pagination-2></pagination-2>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the pagination2 directive');
  }));
});
