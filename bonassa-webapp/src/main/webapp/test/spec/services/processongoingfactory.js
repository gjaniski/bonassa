'use strict';

describe('Service: processongoingfactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var processongoingfactory;
  beforeEach(inject(function (_processongoingfactory_) {
    processongoingfactory = _processongoingfactory_;
  }));

  it('should do something', function () {
    expect(!!processongoingfactory).toBe(true);
  });

});
