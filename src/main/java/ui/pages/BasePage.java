package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    public static final String HOME_URL = "https://open.spotify.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage() {
        driver.get(HOME_URL);
        return new HomePage(driver);
    }
}