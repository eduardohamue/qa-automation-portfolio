import { By, until } from 'selenium-webdriver';

class loginPage{
    constructor(driver) {
        this.driver = driver;
        this.userNameInput = By.xpath('//input[@name="username"]');
        this.passwordInput = By.xpath('//input[@name="password"]');
        this.submitButton = By.xpath('//button[@type="submit"]');
    }

    async accessToLoginPage(){
        await this.driver.get('https://opensource-demo.orangehrmlive.com');
    }

    async putUser(userName){
        const userNameInput = await this.driver.wait(until.elementLocated(this.userNameInput), 10000);
        await userNameInput.sendKeys(userName);
    }

    async putPassword(passw){
        const passwordInput = await this.driver.wait(until.elementLocated(this.passwordInput), 10000);
        await passwordInput.sendKeys(passw);
    }

    async clickLogin(){
        const submitButton = await this.driver.wait(until.elementLocated(this.submitButton), 10000);
        await submitButton.click();
    }
}

// module.exports = loginPage;
export default loginPage