package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Fellowship {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:81/fellowship.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("koniec");
    }

    @Test
    public void itSHoulContainNameForEachFellow() {
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));

        for (WebElement fellowElement : fellowElements) {
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("h1")).getText().isEmpty());

        }
    }

    @Test
    public void itShouldContainSpecifiedFieldFellows() {
        //najdem si zoznam elementov
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        //predpripravim si zoznam stringov do ktoreho si ulozim jednotlive mena
        List<String> fellowNames = new ArrayList<String>();
        //prejdem zoznam elementov
        for (WebElement fellowElement : fellowElements) {
            System.out.println(fellowElement.findElement(By.cssSelector("h1")).getText());
            //v ramci kazdej kachlicky si najdem meno a to ulozim do zoznamu mien
            fellowNames.add(fellowElement.findElement(By.cssSelector("h1")).getText());
        }
        System.out.println(fellowNames);
        //over ze list obsahuje jednotlive mena Gandalf a Aragorn
        Assert.assertTrue(fellowNames.contains ("Gandalf"));
        Assert.assertTrue(fellowNames.contains("Frodo"));
        Assert.assertTrue(fellowNames.contains("Aragorn"));
    }
}