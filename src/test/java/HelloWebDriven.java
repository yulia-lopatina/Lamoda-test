import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelloWebDriven {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lamoda.by/"); // risky point here

        new WebDriverWait(driver,10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[@id='menu-wrapper']/div/div/div/div/input")));

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='menu-wrapper']/div/div/div/div/input"));
        searchInput.sendKeys("куртка");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@id='menu-wrapper']/div/div/div/div/button/div"));
        searchBtn.get(0).click(); //risky point here

        Thread.sleep(2000);
        driver.quit();

    }
}
