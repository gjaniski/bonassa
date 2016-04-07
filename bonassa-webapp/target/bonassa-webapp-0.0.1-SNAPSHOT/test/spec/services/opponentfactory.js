'use strict';

describe('Service: opponentFactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var opponentFactory;
  beforeEach(inject(function (_opponentFactory_) {
    opponentFactory = _opponentFactory_;
  }));

  it('should do something', function () {
    expect(!!opponentFactory).toBe(true);
  });

});
