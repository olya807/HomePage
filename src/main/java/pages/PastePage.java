package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PastePage {
    private WebDriver driver;

    public PastePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCode(String code) {
        WebElement codeArea = driver.findElement(By.id("postform-text"));
        codeArea.sendKeys(code);
    }

    public void selectExpiration(String expiration) {
        driver.findElement(By.id("select2-postform-expiration-container")).click();
        WebElement dropdownOptions = driver.findElement(By.cssSelector("ul.select2-results__options"));
        List<WebElement> options = dropdownOptions.findElements(By.tagName("li"));
        for (WebElement option : options)
        {
            if (option.getText().equals("10 Minutes"))
            {
                option.click();
                break;
            }
        }
    }

    public void enterPasteName(String name) {
        driver.findElement(By.id("postform-name")).sendKeys(name);
    }

    public void createPaste() {
        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();
    }
}