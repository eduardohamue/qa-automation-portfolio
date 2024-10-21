import { expect } from 'chai';

class SoftAssert {
    constructor() {
        this.errors = [];
    }

    assert(condition, message) {
        try {
            expect(condition).to.be.true;
        } catch (error) {
            this.errors.push(message || error.message);
        }
    }

    assertEqual(actual, expected, message) {
        try {
            expect(actual).to.equal(expected);
        } catch (error) {
            this.errors.push(message || `Expected ${actual} to equal ${expected}`);
        }
    }

    assertAll() {
        if (this.errors.length > 0) {
            const errorMessage = this.errors.join('\n');
            throw new Error(`Soft assertions failed:\n${errorMessage}`);
        }
    }
}

export default SoftAssert;
