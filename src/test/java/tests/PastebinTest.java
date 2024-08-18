package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.PastePage;
import utils.WebDriverManager;

import static org.junit.jupiter.api.Assertions.*;

public class PastebinTest {
    private WebDriver driver;
    private HomePage homePage;
    private PastePage pastePage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get("https://pastebin.com/");
        homePage = new HomePage(driver);
        pastePage = new PastePage(driver);
    }

    @Test
    public void testCreateNewPaste() {
        homePage.goToNewPastePage();
        pastePage.enterCode("Hello from WebDriver");
        pastePage.selectExpiration("10 Minutes");
        pastePage.enterPasteName("helloweb");
        pastePage.createPaste();

        assertEquals(
                "helloweb",
                driver.findElement(By.cssSelector(".info-top h1")).getText()
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
