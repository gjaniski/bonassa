'use strict';

describe('Service: processAgendaFactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var processAgendaFactory;
  beforeEach(inject(function (_processAgendaFactory_) {
    processAgendaFactory = _processAgendaFactory_;
  }));

  it('should do something', function () {
    expect(!!processAgendaFactory).toBe(true);
  });

});
