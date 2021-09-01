package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebDrivenSeleniumHQ {
    @Test
    public void commonSearchTermResultsNotEmpty() {


    WebDriver driver = new ChromeDriver();
        driver.get("https://www.lamoda.by/"); // risky point here

        new WebDriverWait(driver,10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[@id='menu-wrapper']/div/div/div/div/input")));

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='menu-wrapper']/div/div/div/div/input"));
        searchInput.sendKeys("куртка");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@id='menu-wrapper']/div/div/div/div/button/div"));
        searchBtn.get(0).click(); //risky point here

        Assert.assertTrue(searchResults.size()"");
        Thread.sleep(2000);
        driver.quit();

    }
}
