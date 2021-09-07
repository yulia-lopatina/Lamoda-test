package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LamodaHomePage {

    private static final String HOMEPAGE_URL = "https://www.lamoda.by";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='menu-wrapper']/div/div/div/div/input")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='menu-wrapper']/div/div/div/div/button/div")
    private WebElement searchButton;

    public LamodaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LamodaHomePage openPage() {
        driver.get(HOMEPAGE_URL);
       new WebDriverWait(driver, 10);
        return this;
    }

    public int searchForTerms(String term) {
        searchInput.sendKeys(term);
        searchButton.click();
        return 0;
    }
}

