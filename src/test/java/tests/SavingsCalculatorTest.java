package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.SavingsCalculatorPage;

public class SavingsCalculatorTest extends TestBase {
    private SavingsCalculatorPage SavingsCalculatorPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
        SavingsCalculatorPage = new SavingsCalculatorPage(driver);
    }

    @Test
    public void applyButtonIsEnabled() {
        String[] selectedOptions = {"Handelsbanken Aktiv 100", "Hoggwart's Fund", "Fellowship investment group", "McDuck's safe", "Batman's Cave Development", "Death Star real estate", "Tom & Jerry corp"};
        WebElement optionSelect = driver.findElement(By.id("fundSelect"));
        for (String options : selectedOptions) {
            new Select(optionSelect).selectByVisibleText(options);
        }

        SavingsCalculatorPage.enterInvestInput("1000");
        SavingsCalculatorPage.enterYearsInput("5");
        SavingsCalculatorPage.enterEmailInput("Dana@gmail.com");
        Assert.assertTrue(driver.findElement(By.xpath("//button")).isEnabled());
        }


    @Test
    public void sumsShouldntBeEmpty() {
        String[] selectedOptions = {"Handelsbanken Aktiv 100", "Hoggwart's Fund", "Fellowship investment group", "McDuck's safe", "Batman's Cave Development", "Death Star real estate", "Tom & Jerry corp"};
        WebElement optionSelect = driver.findElement(By.id("fundSelect"));
        for (String options : selectedOptions) {
            new Select(optionSelect).selectByVisibleText(options);
        }

        SavingsCalculatorPage.enterInvestInput("1000");
        SavingsCalculatorPage.enterYearsInput("5");
        SavingsCalculatorPage.enterEmailInput("Dana@gmail.com");

        WebElement container = driver.findElement(By.cssSelector("div.result"));

        System.out.println(container.findElement(By.xpath("./div[1]/p")).getText());
        System.out.println(container.findElement(By.xpath("./div[2]/p")).getText());

        Assert.assertFalse(container.findElement(By.xpath("./div[1]/p")).getText().isEmpty());
        Assert.assertFalse(container.findElement(By.xpath("./div[2]/p")).getText().isEmpty());
    }

    @Test
    public void riskShouldNotBeEmpty() {
        String[] selectedOptions = {"Handelsbanken Aktiv 100", "Hoggwart's Fund", "Fellowship investment group", "McDuck's safe", "Batman's Cave Development", "Death Star real estate", "Tom & Jerry corp"};
        WebElement optionSelect = driver.findElement(By.id("fundSelect"));
        for (String options : selectedOptions) {
            new Select(optionSelect).selectByVisibleText(options);
        }

        SavingsCalculatorPage.enterInvestInput("1000");
        SavingsCalculatorPage.enterYearsInput("5");
        SavingsCalculatorPage.enterEmailInput("Dana@gmail.com");

        WebElement container = driver.findElement(By.cssSelector("div.result"));
        System.out.println(container.findElement(By.xpath("./div[3]/p")).getText());

        Assert.assertFalse(container.findElement(By.xpath("./div[3]/p")).getText().isEmpty());
    }

    @Test
    public void requestsAreDisplayed() {
        String[] selectedOptions = {"Handelsbanken Aktiv 100", "Hoggwart's Fund", "Fellowship investment group", "McDuck's safe", "Batman's Cave Development", "Death Star real estate", "Tom & Jerry corp"};
        WebElement optionSelect = driver.findElement(By.id("fundSelect"));
        for (String options : selectedOptions) {
            new Select(optionSelect).selectByVisibleText(options);
        }

        SavingsCalculatorPage.enterInvestInput("1000");
        SavingsCalculatorPage.enterYearsInput("5");
        SavingsCalculatorPage.enterEmailInput("Dana@gmail.com");
        driver.findElement(By.xpath("//button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[2]/h2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[2]/p")).isDisplayed());
    }
    }

