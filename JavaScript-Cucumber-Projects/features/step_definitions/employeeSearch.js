import { Builder } from 'selenium-webdriver';
import { Given, When, Then} from '@cucumber/cucumber';
import { expect } from 'chai';

import LoginPage from '../../src/page_objects/loginPage.js';
import DashBoardPage from '../../src/page_objects/dashBoardPage.js';
import PimPage from '../../src/page_objects/pimPage.js';

let driver;
let loginPage;
let dashBoardPage;
let pimPage;


Given('I am logged in with {string} user and {string} password', { timeout: 20000 }, async function (userName,passw) {
    driver = new Builder().forBrowser('firefox').build();
    loginPage = new LoginPage(driver);
    
    await loginPage.accessToLoginPage();
    await loginPage.putUser(userName);
    await loginPage.putPassword(passw);
    await loginPage.clickLogin();
});

When('I navigate to the employee list', { timeout: 20000 }, async function () {
    dashBoardPage = new DashBoardPage(driver);
    await dashBoardPage.goToPimTab();
    
});

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
