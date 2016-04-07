'use strict';

describe('Service: processPropertyFactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var processPropertyFactory;
  beforeEach(inject(function (_processPropertyFactory_) {
    processPropertyFactory = _processPropertyFactory_;
  }));

  it('should do something', function () {
    expect(!!processPropertyFactory).toBe(true);
  });

});
