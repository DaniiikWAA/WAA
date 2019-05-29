/*. samostatna praca - otestujte kalkulacku
 - otestujte spocitanie, odpocitanie
 - resetovanie kalkulacky
 - posledne vysledky
 - prepouzite kroky pomocou metod
 - vytvorte stranku calculator Page a definujte na nej kroky*/

package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Kalkulacka extends TestBase {

    @Before
    public void openPage(){
        driver.get(BASE_URL + "/kalkulacka.php");
    }

    //spocitanie
    @Test
    public void itShouldSumUp() {


        driver.findElement(By.id("firstInput")).sendKeys("1");
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        //driver.findElement(By.id("result")).isDisplayed();
        Assert.assertEquals("3", driver.findElement(By.id("result")).getText());

    }

   //odpocitanie
   @Test
   public void itShouldDeduct() {
       driver.findElement(By.id("firstInput")).sendKeys("2");
       driver.findElement(By.id("secondInput")).sendKeys("1");
       driver.findElement(By.id("deduct")).click();
       //driver.findElement(By.id("result")).isDisplayed();
       Assert.assertEquals("1", driver.findElement(By.id("result")).getText());
   }

   //resetovanie kalkulacky
    @Test
    public void itShouldResetNumbers() {
        driver.findElement(By.id("firstInput")).sendKeys("2");
        driver.findElement(By.id("secondInput")).sendKeys("1");
        driver.findElement(By.id("deduct")).click();
        //driver.findElement(By.id("result")).isDisplayed();
        driver.findElement(By.id("reset")).click();
        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
    }

    //posledne vysledky
    @Test
    public void itSHouldDisplayLastResults() {
        driver.findElement(By.id("firstInput")).sendKeys("2");
        driver.findElement(By.id("secondInput")).sendKeys("1");
        driver.findElement(By.id("deduct")).click();
        //driver.findElement(By.id("result")).isDisplayed();
        Assert.assertEquals(
                "2-1 = 1",
                driver.findElement(By.cssSelector("ul.latest-results li")).getText());
    }

}
