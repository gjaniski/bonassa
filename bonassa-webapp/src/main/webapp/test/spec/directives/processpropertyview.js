'use strict';

describe('Directive: processPropertyView', function () {

  // load the directive's module
  beforeEach(module('webappApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<process-property-view></process-property-view>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the processPropertyView directive');
  }));
});
