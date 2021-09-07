package pageobject_model.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.LamodaHomePage;

import java.util.List;

public class WebDrivenSeleniumHQ {
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Just test")
    public void commonSearchTermResultsNotEmpty() {

        int expectedSearchResultsNumber = new LamodaHomePage(driver)
                .openPage()
                .searchForTerms("зимняя куртка");

        Assert.assertTrue(expectedSearchResultsNumber > 0, "Search results are empty!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
