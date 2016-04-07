'use strict';

describe('Service: Errorlogin', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var Errorlogin;
  beforeEach(inject(function (_Errorlogin_) {
    Errorlogin = _Errorlogin_;
  }));

  it('should do something', function () {
    expect(!!Errorlogin).toBe(true);
  });

});
