'use strict';

describe('Service: employeeservice', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var employeeservice;
  beforeEach(inject(function (_employeeservice_) {
    employeeservice = _employeeservice_;
  }));

  it('should do something', function () {
    expect(!!employeeservice).toBe(true);
  });

});
