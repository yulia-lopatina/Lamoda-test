package first_test;

import jdk.internal.icu.text.UnicodeSet;
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

        new WebDriverWait(driver,10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//div[contains(@class,'vue-widget') and contains (., 'зимняя') and contains (.,'куртка')]")));

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class,'vue-widget') and contains (., 'зимняя') and contains (.,'куртка')]"));
        System.out.println("Search results number for requested term: " + searchResults.size());

        Assert.assertTrue(searchResults.size()>0);
        driver.quit();

    }
}
