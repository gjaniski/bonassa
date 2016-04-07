'use strict';

describe('Directive: processAgendaView', function () {

  // load the directive's module
  beforeEach(module('webappApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<process-agenda-view></process-agenda-view>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the processAgendaView directive');
  }));
});
