'use strict';

describe('Service: processDocumentFactory', function () {

  // load the service's module
  beforeEach(module('webappApp'));

  // instantiate service
  var processDocumentFactory;
  beforeEach(inject(function (_processDocumentFactory_) {
    processDocumentFactory = _processDocumentFactory_;
  }));

  it('should do something', function () {
    expect(!!processDocumentFactory).toBe(true);
  });

});
