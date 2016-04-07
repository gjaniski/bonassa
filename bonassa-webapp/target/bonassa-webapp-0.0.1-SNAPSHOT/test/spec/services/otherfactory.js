'use strict';

describe('Service: otherFactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var otherFactory;
  beforeEach(inject(function (_otherFactory_) {
    otherFactory = _otherFactory_;
  }));

  it('should do something', function () {
    expect(!!otherFactory).toBe(true);
  });

});
