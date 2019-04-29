package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTrainingTest {
//na zaciatku treba definovat driver
WebDriver driver;
    //metoda ktora spusti prvu cast a tu si zadam prikazy, ktore chcem, aby sa mi opakovali pred kazdym testom

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:81/xpathtrainingcenter.php");
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
        System.out.println("koniec");
    }

    @Test
    public void itShouldDisplayACtion(){
        String buttonText = "One more button";
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).click();

        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();

        Assert.assertEquals(
                "you clicked " + buttonText.toLowerCase(),
                actualMessage
        );
    }

    @Test
    public void itSHouldDisplayEnteredMessage(){
        String message  = "vonku prsi";
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:81/xpathtrainingcenter.php");
        driver.findElement(By.cssSelector("input")).sendKeys(message);
        driver.findElement(By.id("hitme")).click();
        //precitam hodnotu zo stranky a ulozim ju do premennnej
        String actualmessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        Assert.assertEquals(
                "you entered " + message,
                actualmessage);
    }
}
