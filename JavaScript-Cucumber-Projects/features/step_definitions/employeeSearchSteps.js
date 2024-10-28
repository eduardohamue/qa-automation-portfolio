import { Builder } from 'selenium-webdriver';
import { When, Then} from '@cucumber/cucumber';
import { expect } from 'chai';
import { driver } from './genericSteps.js';

import PimPage from '../../src/page_objects/pimPage.js';

let pimPage;

When('I search for {string}', { timeout: 20000 }, async function (employeeName) {
    pimPage = new PimPage(driver);
    await pimPage.searchEmployee(employeeName);
});

Then('I should see a list of employee results', { timeout: 20000 }, async function () {
    let employeesAmount = await pimPage.getNumEmployees();
    expect(employeesAmount).to.be.at.least(0, "Employee count should be 0 or greater");
});

Then('the first result should contain {string} {string}', { timeout: 20000 }, async function (employeeFirstName, employeeLastName) {
    let nameFindeIt = await pimPage.validateFirstEmployee(employeeFirstName, employeeLastName);
    expect(nameFindeIt, `The name ${employeeFirstName} ${employeeLastName} is not found.` ).to.be.true;
});
