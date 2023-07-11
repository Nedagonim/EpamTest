package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class HomePage extends BasePage {

    private final Waiter waiter;

    @FindBy(xpath = "//button[@data-testid='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//figure[@title='Pawook']")
    public WebElement userIcon;

    public HomePage(WebDriver driver) {
        super(driver);
        waiter = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage openLoginPage() {
        waiter.untilVisible(loginButton).click();
        return new LoginPage(driver);
    }
}
