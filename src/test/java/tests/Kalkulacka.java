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
import pages.KalkulackaPage;

public class Kalkulacka extends TestBase {
    private KalkulackaPage KalkulackaPage;

    @Before
    public void openPage(){
        driver.get(BASE_URL + "/kalkulacka.php");
        KalkulackaPage = new KalkulackaPage(driver);
    }

    //spocitanie
    @Test
    public void itShouldSumUp() {

        KalkulackaPage.enterFirstInput("1");
        KalkulackaPage.enterSecondInput("2");
        KalkulackaPage.sumNumbers();
       Assert.assertEquals("3", KalkulackaPage.getResult());

    }


   //odpocitanie
   @Test
   public void itShouldDeduct() {
       KalkulackaPage.enterFirstInput("3");
       KalkulackaPage.enterSecondInput("2");
       KalkulackaPage.deductNumbers();
       Assert.assertEquals("1", KalkulackaPage.getResult());
   }

   //resetovanie kalkulacky
    @Test
    public void itShouldResetNumbers() {
        KalkulackaPage.enterFirstInput("1");
        KalkulackaPage.enterSecondInput("2");
        KalkulackaPage.deductNumbers();
        KalkulackaPage.resetNumbers();
        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
    }

    //posledne vysledky
    @Test
    public void itSHouldDisplayLastResults() {
        KalkulackaPage.enterFirstInput("2");
        KalkulackaPage.enterSecondInput("1");
        KalkulackaPage.deductNumbers();
        Assert.assertEquals(
                "2-1 = 1",
                driver.findElement(By.cssSelector("ul.latest-results li")).getText());
    }

}
