'use strict';

describe('Service: parameterService', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var parameterService;
  beforeEach(inject(function (_parameterService_) {
    parameterService = _parameterService_;
  }));

  it('should do something', function () {
    expect(!!parameterService).toBe(true);
  });

});
