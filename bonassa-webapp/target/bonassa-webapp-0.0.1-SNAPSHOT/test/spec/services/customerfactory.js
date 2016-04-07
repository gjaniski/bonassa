'use strict';

describe('Service: customerfactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var customerfactory;
  beforeEach(inject(function (_customerfactory_) {
    customerfactory = _customerfactory_;
  }));

  it('should do something', function () {
    expect(!!customerfactory).toBe(true);
  });

});
