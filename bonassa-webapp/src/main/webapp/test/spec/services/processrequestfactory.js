'use strict';

describe('Service: processRequestFactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var processRequestFactory;
  beforeEach(inject(function (_processRequestFactory_) {
    processRequestFactory = _processRequestFactory_;
  }));

  it('should do something', function () {
    expect(!!processRequestFactory).toBe(true);
  });

});
