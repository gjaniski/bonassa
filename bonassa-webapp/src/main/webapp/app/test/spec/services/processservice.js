'use strict';

describe('Service: ProcessService', function () {

  // load the service's module
  beforeEach(module('appApp'));

  // instantiate service
  var ProcessService;
  beforeEach(inject(function (_ProcessService_) {
    ProcessService = _ProcessService_;
  }));

  it('should do something', function () {
    expect(!!ProcessService).toBe(true);
  });

});
