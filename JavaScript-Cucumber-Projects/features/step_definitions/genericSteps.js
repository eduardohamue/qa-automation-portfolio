import { Builder } from 'selenium-webdriver';
import { Given, When } from '@cucumber/cucumber';
import LoginPage from '../../src/page_objects/loginPage.js';
import DashBoardPage from '../../src/page_objects/dashBoardPage.js';

let driver;
let loginPage;
let dashBoardPage;


Given('I am logged in with {string} user and {string} password', { timeout: 20000 }, async function (userName, passw) {
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

export { driver };