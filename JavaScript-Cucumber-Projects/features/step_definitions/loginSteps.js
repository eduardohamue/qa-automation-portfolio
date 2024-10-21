import { Builder } from 'selenium-webdriver';
import { Given, When, Then} from '@cucumber/cucumber';
import { expect } from 'chai';
import SoftAssert from '../../support/SoftAssert.js'

import LoginPage from '../../src/page_objects/loginPage.js';
import DashBoardPage from '../../src/page_objects/dashBoardPage.js';


const driver = new Builder().forBrowser('firefox').build();
const loginPage = new LoginPage(driver);
const dashBoardPage = new DashBoardPage(driver)
const softAssert = new SoftAssert();


Given('I am on the login page', { timeout: 20000 }, async function () {
    await loginPage.accessToLoginPage();
});

When('I enter {string} as username', async function (userName) {
    await loginPage.putUser(userName);
    
});

When('I enter {string} as password', async function (passw) {
    await loginPage.putPassword(passw)
});

When('I click the login button', async function () {
    await loginPage.clickLogin();
});

Then('I should see the dashboard page', { timeout: 20000 }, async function () {
    
    const text = await dashBoardPage.getHeaderText();
    softAssert.assertEqual(text, 'Dashboard', 'Text does not match');
    
    
});

Then('the title should be {string}', async function (titleExpected) {

    const title = await driver.getTitle();
    softAssert.assertEqual(title, titleExpected, 'Title does not match');
    
});

Then('Verify all asserts an exit from web site', async function() {
    await driver.quit();

    //Note: this step fail if one or more soft assertions fails, but only show 1 fail even if all soft asserts fail
    softAssert.assertAll();
    
});