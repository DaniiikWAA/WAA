package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {

    //TENTO MA PASS
    @Test
    public void itShouldAddOneRyan() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //nazov testu, mal by ho vystihovat
        //0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:81/gosslingator.php");
        //2. kliknut na button "pridat"
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        //3. overit pocitanie Ryanov
        Assert.assertEquals("3", driver.findElement(By.id("ryanCounter")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
    }

    //TENTO MA FAILNUT
    @Test
    public void itShouldAddTwoRyan() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //nazov testu, mal by ho vystihovat
        //0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:81/gosslingator.php");
        //2. kliknut na button "pridat"
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        //3. overit pocitanie Ryanov
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
    }
}
