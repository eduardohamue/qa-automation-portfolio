import { By, until } from 'selenium-webdriver';

class dashBoardPage{
    constructor(driver) {
        this.driver = driver;
        this.header = By.css('h6')
    }

    async getHeaderText(){
        const header = await this.driver.wait(until.elementLocated(this.header), 10000)
        const text = header.getText();
        return text
    }
}

export default dashBoardPage;