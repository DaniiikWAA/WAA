package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest extends TestBase {

    protected String actualNumberOfRyans;

    @Before
    public void openPage(){
        driver.get(BASE_URL + "/gosslingator.php");
    }

    @Test
    public void itShouldAddOneRyan() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        driver.findElement(By.id("removeRyan")).click();
        //3. overit pocitanie Ryanov
        Assert.assertEquals("3", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        System.out.println("Number of Ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
    }

    @Test
    public void itShouldDisplayTitle() {
        System.out.println("Nazov na stranke je: " + driver.findElement(By.cssSelector("h1.ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector("h1.ryan-title")).getText());
    }

    @Test
    public void itShouldChecktheMessage() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            addRyanButton.click();
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);

            //overit sklonovanie pomocou podmienky
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i + 1 == 1 ) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }
            System.out.println("index i = " + i);
            System.out.println("pocet ryanov = " + actualNumberOfRyans);

            //overit pocet obrazkov Ryana
            int numberOfRyanImages = driver.findElements(By.cssSelector("img")).size();
            Assert.assertEquals(i + 1, numberOfRyanImages);
        }

        Assert.assertEquals("50", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        System.out.println("Number of Ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        System.out.println("Hlaska: " + driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
    }

    //testovanie sa stopne po 30 klikoch
    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        int clickslimit = 30;
        int clicks = 0;
        while (!actualNumberOfRyans.equals("50")&& clicks <= clickslimit){
            addRyanButton.click();
            actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            clicks++;
        }
    }

    @Test
    public void itShouldAddTwoRyan() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        driver.findElement(By.id("removeRyan")).click();

        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();

        Assert.assertEquals("2", actualNumberOfRyans);
        Assert.assertEquals("ryans", actualRyanDescription);
    }

}
