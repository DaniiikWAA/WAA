package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KalkulackaPage {
    WebDriver pageDriver;

    public KalkulackaPage(WebDriver pageDriver) {
        this.pageDriver = pageDriver;
    }

    public void enterFirstInput(String textToInput) {
        pageDriver.findElement(By.id("firstInput")).sendKeys(textToInput);
    }

    public void enterSecondInput(String textToInput) {
        pageDriver.findElement(By.id("secondInput")).sendKeys(textToInput);
    }

    public String getResult() {
        return pageDriver.findElement(By.id("result")).getText();
    }

    public void deductNumbers() {
        pageDriver.findElement(By.id("deduct")).click();
    }

    public void sumNumbers() {
        pageDriver.findElement(By.id("count")).click();
    }

    public void resetNumbers() {
        pageDriver.findElement(By.id("reset")).click();
    }
}
