'use strict';

describe('Service: userFactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var userFactory;
  beforeEach(inject(function (_userFactory_) {
    userFactory = _userFactory_;
  }));

  it('should do something', function () {
    expect(!!userFactory).toBe(true);
  });

});
