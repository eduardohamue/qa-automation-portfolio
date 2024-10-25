import { By, until } from 'selenium-webdriver';

class pimPage{

    constructor(driver){
        this.driver = driver;
        this.employeeNameImput = By.xpath('//label[contains(text(),"Employee Name")]/parent::*/following-sibling::*//input');
        this.searchButtom = By.className('oxd-button oxd-button--medium oxd-button--ghost');
        
    }
    async searchEmployee(employeeName){
        const employeeNameImput = await this.driver.wait(until.elementLocated(this.employeeNameImput),10000);
        await employeeNameImput.sendKeys(employeeName);
        const searchButtom = await this.driver.wait(until.elementLocated(this.searchButtom),10000);
        await searchButtom.click();
    }
    async getNumEmployees(){
        let employees = await this.driver.findElements(By.xpath('//div[@class="oxd-table-card"]'));
        return employees.length;
    }

    
    async validateFirstEmployee(employeeFirstName, employeeLastName){

        let firstEmployee = await this.driver.wait(until.elementLocated(By.xpath('//div[@class="oxd-table-card"]')), 10000);
        let employeeData = await firstEmployee.findElements(By.xpath('.//div[@role="cell"]'));
        
        let employeeDataFirstName = await employeeData[2].getText();
        if (employeeDataFirstName != employeeFirstName){
            return false
        }

        let employeeDataLastName = await employeeData[3].getText();
        if (employeeDataLastName != employeeLastName){
            return false
        }

        return True;

    }
}
export default pimPage