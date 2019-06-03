package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SavingsCalculatorPage {
    WebDriver pageDriver;

    public SavingsCalculatorPage(WebDriver pageDriver) {

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

    public void enterInput() {
        String[] selectedOptions = {"Handelsbanken Aktiv 100", "Hoggwart's Fund", "Fellowship investment group", "McDuck's safe", "Batman's Cave Development", "Death Star real estate", "Tom & Jerry corp"};
        WebElement optionSelect = pageDriver.findElement(By.id("fundSelect"));
        for (String options : selectedOptions) {
            new Select(optionSelect).selectByVisibleText(options);
        }
    }

    public void clickButton() {
        pageDriver.findElement(By.xpath("//button")).click();
    }

}
