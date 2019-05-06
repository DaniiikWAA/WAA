package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Pokemoniii {
        WebDriver driver;

        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
            driver = new ChromeDriver();
            driver.get("http://localhost:81/vybersi.php");
        }

        @After
        public void tearDown(){
            driver.close();
            driver.quit();
            System.out.println("koniec");
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
}
