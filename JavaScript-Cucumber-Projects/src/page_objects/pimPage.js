import { By, Key, until } from 'selenium-webdriver';


class pimPage{

    constructor(driver){
        this.driver = driver;
        this.employeeNameImput = By.xpath('//label[contains(text(),"Employee Name")]/parent::*/following-sibling::*//input');
        this.searchButtom = By.className('oxd-button oxd-button--medium oxd-button--ghost');
        this.addButton = By.xpath('//div[@class="orangehrm-header-container"]/button');
        this.employeeFirstNameImput = By.xpath('//input[@name="firstName"]');
        this.employeeLastNameImput = By.xpath('//input[@name="lastName"]');
        this.saveButton = By.xpath('//button[@type="submit"]');
        this.resetButton = By.xpath('//button[@type="reset"]');
        this.successSavedMessage = By.xpath('//div[@class="oxd-toast-start" and contains(., "Successfully Saved")]');
        
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

    async clickAdButton(){
        const addButton = await this.driver.wait(until.elementLocated(this.addButton), 10000);
        await addButton.click();
    }

    async fillEmployeInformationToAdd(employeeFirstName, employeeLastName) {
        
    
        const employeeFirstNameInput = await this.driver.wait(until.elementLocated(this.employeeFirstNameImput), 10000);
        await employeeFirstNameInput.sendKeys(employeeFirstName);
    
        const employeeLastNameInput = await this.driver.wait(until.elementLocated(this.employeeLastNameImput), 10000);
        await employeeLastNameInput.sendKeys(employeeLastName);
        
        await employeeLastNameInput.sendKeys(Key.ESCAPE);
    
        
    }

    async clickSaveButton(){
        // Wait for loader to disappear (retry locating the loader element)
        await this.driver.wait(until.stalenessOf(await this.driver.findElement(By.className('oxd-form-loader'))), 10000);
        await this.manageStaleElements(this.saveButton)
        
    }

    async manageStaleElements(originalElement){
        // Retry locating the element if it becomes stale
        let element;
        for (let i = 0; i < 3; i++) {
            try {
                element = await this.driver.findElement(originalElement);
                await element.click();
                break; // Break out of the loop if click is successful
            } catch (error) {
                if (error.name === 'StaleElementReferenceError') {
                    console.log('Retrying to locate the element due to stale reference...');
                } else {
                    throw error; // If it's a different error, throw it
                }
            }
        }
    }
    

    async appearsSaveMessage() {
        const successSavedMessage = await this.driver.wait(until.elementLocated(this.successSavedMessage), 600000);
        if(successSavedMessage == null){
            return false;
        }
        return true;
    }
    
    
}
export default pimPage