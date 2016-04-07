'use strict';

describe('Service: processRelatedFactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var processRelatedFactory;
  beforeEach(inject(function (_processRelatedFactory_) {
    processRelatedFactory = _processRelatedFactory_;
  }));

  it('should do something', function () {
    expect(!!processRelatedFactory).toBe(true);
  });

});
