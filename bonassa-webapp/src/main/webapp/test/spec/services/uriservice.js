'use strict';

describe('Service: UriService', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var UriService;
  beforeEach(inject(function (_UriService_) {
    UriService = _UriService_;
  }));

  it('should do something', function () {
    expect(!!UriService).toBe(true);
  });

});
