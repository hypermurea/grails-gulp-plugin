var samplemodule = require('../sample.js');

describe("A sample test suite", function() {
  it("tests for module", function() {
    expect(samplemodule()).toBe(true);
  });
});