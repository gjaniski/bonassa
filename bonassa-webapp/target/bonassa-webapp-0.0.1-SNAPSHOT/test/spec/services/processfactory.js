'use strict';

describe('Service: processfactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var processfactory;
  beforeEach(inject(function (_processfactory_) {
    processfactory = _processfactory_;
  }));

  it('should do something', function () {
    expect(!!processfactory).toBe(true);
  });

});
