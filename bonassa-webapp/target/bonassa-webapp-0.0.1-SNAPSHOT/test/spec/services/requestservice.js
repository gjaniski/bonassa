'use strict';

describe('Service: RequestService', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var RequestService;
  beforeEach(inject(function (_RequestService_) {
    RequestService = _RequestService_;
  }));

  it('should do something', function () {
    expect(!!RequestService).toBe(true);
  });

});
