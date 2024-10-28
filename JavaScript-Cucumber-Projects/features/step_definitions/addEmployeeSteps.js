import { Builder } from 'selenium-webdriver';
import { When, Then} from '@cucumber/cucumber';

import { driver } from './genericSteps.js';
import { expect } from 'chai';
import PimPage from '../../src/page_objects/pimPage.js';
import SoftAssert from '../../support/SoftAssert.js'

let pimPage;
let softAssert = new SoftAssert();

When('I click the add button', { timeout: 20000 }, async function () {
    pimPage = new PimPage(driver);
    await pimPage.clickAdButton();
});


When('I enter the first name {string} and the last name {string}', { timeout: 20000 }, async function (employeeFirstName, employeeLastName) {
    await pimPage.fillEmployeInformationToAdd(employeeFirstName,employeeLastName)
    // await pimPage.validateSaveMessage()
});

When('I click the save button', { timeout: 20000 }, async function () {
    await pimPage.clickSaveButton();
});

Then('Should appears a message of "Successfully Saved"', { timeout: 20000 }, async function () {
    let existSaveMessage = await pimPage.appearsSaveMessage();

    softAssert.assertEqual(existSaveMessage, true, 'Text does not match');
});