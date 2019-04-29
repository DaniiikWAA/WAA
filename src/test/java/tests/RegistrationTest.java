package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class RegistrationTest {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:81/registracia.php");
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
        System.out.println("koniec");
    }

    @Test
    public void itSHouldRegisterValidUser(){
        //definovat premenne
        String email = "dana@aaa.sk";
        String meno = "Daniela";
        String priezvisko = "Nova";
        String heslo = "heslo";
        String heslo2 = "heslo";

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(meno);
        driver.findElement(By.name("surname")).sendKeys(priezvisko);
        driver.findElement(By.name("password")).sendKeys(heslo);
        driver.findElement(By.name("password-repeat")).sendKeys(heslo2);

        driver.findElement(By.name("robot")).click();
        driver.findElement(By.xpath("/html/body/div/div/form/button")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/strong")).getText();
        driver.findElement(By.cssSelector("div.alert-success"));
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());

    }

    //NEUSPESNA REGISTRACIA
    @Test
    public void itSHouldntRegisterInvalidUser(){
        //definovat premenne
        String email = "dana@aaa.sk";
        String meno = "Daniela";
        String priezvisko = "Nova";
        String heslo = "heslo";
        String heslo2 = "";

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(meno);
        driver.findElement(By.name("surname")).sendKeys(priezvisko);
        driver.findElement(By.name("password")).sendKeys(heslo);
        driver.findElement(By.name("password-repeat")).sendKeys(heslo2);

        driver.findElement(By.name("robot")).click();
        driver.findElement(By.xpath("/html/body/div/div/form/button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
    }
}
