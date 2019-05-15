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
import org.openqa.selenium.support.ui.Select;

public class Pokemoniii extends TestBase {

        @Before
        public void openPage(){
            driver.get(BASE_URL + "/vybersi.php");
        }

        //test na vybratie pikachu a overenie textu
        @Test
            public void itShouldSelectPikachu() {
            String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Geodude", "Diglett"};
            //najdem element select
            WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));

            for (String pokemon : selectedPokemons) {
                new Select(pokemonSelect).selectByVisibleText(pokemon);
                String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
                String expectedMessage = "I choose you " + pokemon + " !";
                Assert.assertEquals(expectedMessage, actualMessage);
            }
            }

            @Test
                 public void xpathtestuloha() {
                System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
                driver = new ChromeDriver();
                driver.get("http://localhost:81/xpathtrainingcenter.php");
                 String[] selectedOptions = {"moznost 1", "moznost 2", "moznost 3", "moznost 4","moznost 5", "moznost 6"};
                 WebElement optionSelect = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/select[1]"));

                 for (String options : selectedOptions) {
                     new Select(optionSelect).selectByVisibleText(options);
                     String actualMessage = driver.findElement(By.xpath("/html/body/div/div[4]/div/div/h2/span")).getText();
                     String expectedMessage = "you have chosen " + options;
                     Assert.assertEquals(expectedMessage, actualMessage);
                 }

            }
}
