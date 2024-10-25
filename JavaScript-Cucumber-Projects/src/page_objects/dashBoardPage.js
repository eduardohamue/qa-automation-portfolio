import { By, until } from 'selenium-webdriver';

class dashBoardPage{
    constructor(driver) {
        this.driver = driver;
        this.header = By.css('h6')
        this.PIMLink = By.xpath('//span[text()="PIM"]')
    }

    async getHeaderText(){
        const header = await this.driver.wait(until.elementLocated(this.header), 10000)
        const text = header.getText();
        return text
    }

    async goToPimTab(){
        const PIMLink = await this.driver.wait(until.elementLocated(this.PIMLink), 10000)
        await PIMLink.click()
    }
}

export default dashBoardPage;