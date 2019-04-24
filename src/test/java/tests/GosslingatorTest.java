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
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
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
        Assert.assertEquals("3", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        System.out.println("Number of Ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
    }

    //NOVY TEST
    @Test
    public void itShouldDisplayTitle() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:81/gosslingator.php");
        System.out.println("Nazov na stranke je: " + driver.findElement(By.cssSelector("h1.ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector("h1.ryan-title")).getText());
        driver.close();
        driver.quit();
    }

    //ULOHA
    @Test
    public void itShouldChecktheMessage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:81/gosslingator.php");
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        Assert.assertEquals("50", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        System.out.println("Number of Ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        System.out.println("Hlaska: " + driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
        driver.close();
        driver.quit();
    }

    //TENTO MA FAILNUT
    @Test
    public void itShouldAddTwoRyan() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
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
        Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
    }

    //HOMEWORK
    @Test
    public void itShouldOpenthePage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:81/vybersi.php");
        //4. zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
    }
}
