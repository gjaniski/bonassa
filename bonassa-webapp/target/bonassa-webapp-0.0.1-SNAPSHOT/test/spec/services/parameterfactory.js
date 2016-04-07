'use strict';

describe('Service: parameterfactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var parameterfactory;
  beforeEach(inject(function (_parameterfactory_) {
    parameterfactory = _parameterfactory_;
  }));

  it('should do something', function () {
    expect(!!parameterfactory).toBe(true);
  });

});
