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
        SavingsCalculatorPage.enterInput();
        SavingsCalculatorPage.enterInvestInput("1000");
        SavingsCalculatorPage.enterYearsInput("5");
        SavingsCalculatorPage.enterEmailInput("Dana@gmail.com");
        Assert.assertTrue(driver.findElement(By.xpath("//button")).isEnabled());
        }


    @Test
    public void sumsShouldntBeEmpty() {
        SavingsCalculatorPage.enterInput();
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
        SavingsCalculatorPage.enterInput();
        SavingsCalculatorPage.enterInvestInput("1000");
        SavingsCalculatorPage.enterYearsInput("5");
        SavingsCalculatorPage.enterEmailInput("Dana@gmail.com");

        WebElement container = driver.findElement(By.cssSelector("div.result"));
        System.out.println(container.findElement(By.xpath("./div[3]/p")).getText());

        Assert.assertFalse(container.findElement(By.xpath("./div[3]/p")).getText().isEmpty());
    }

    @Test
    public void requestsAreDisplayed() {
        SavingsCalculatorPage.enterInput();
        SavingsCalculatorPage.enterInvestInput("1000");
        SavingsCalculatorPage.enterYearsInput("5");
        SavingsCalculatorPage.enterEmailInput("Dana@gmail.com");
        SavingsCalculatorPage.clickButton();
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[2]/h2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[2]/p")).isDisplayed());
    }
    }

