package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SavingsCalculatorPage {
    WebDriver pageDriver;
    public SavingsCalculatorPage (WebDriver pageDriver) {

        this.pageDriver = pageDriver;
    }

    public void enterInvestInput(String textToInput) {
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(textToInput);
    }

    public void enterYearsInput(String textToInput) {
        pageDriver.findElement(By.id("yearsInput")).sendKeys(textToInput);
    }

    public void enterEmailInput(String textToInput) {
        pageDriver.findElement(By.id("emailInput")).sendKeys(textToInput);
    }

}
