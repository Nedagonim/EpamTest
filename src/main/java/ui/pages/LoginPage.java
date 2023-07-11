package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class LoginPage extends BasePage {

    public final Waiter waiter;

    @FindBy(xpath = "//input[@id='login-username']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[@id='username-error']")
    public WebElement loginErrorMessage;

    @FindBy(xpath = "//div[@id='password-error']")
    public WebElement passwordErrorMessage;

    @FindBy(xpath = "//button[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@data-encore-id='banner']")
    public WebElement mainErrorBanner;

    public LoginPage(WebDriver driver) {
        super(driver);
        waiter = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HomePage openHomePage() {
        super.openHomePage();

        return new HomePage(driver);
    }

    public void inputLogin(String login) {
        waiter.untilVisible(loginInput).sendKeys(login);
    }

    public void inputPassword(String password) {
        waiter.untilVisible(passwordInput).sendKeys(password);
    }

    public void login(String login, String password) {
        inputLogin(login);
        inputPassword(password);
        waiter.untilVisible(loginButton).click();
    }

    /**
    Actions and sendKeys method is used instead of clear()
    because login and password error messages are not
    triggered when using clear() method
    **/
    public void clearCredentials(String login, String password) {
        loginInput.click();
        clickBackSpace(login);
        passwordInput.click();
        clickBackSpace(password);
    }

    private void clickBackSpace(String keyWord) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < keyWord.toCharArray().length; i++) {
            actions.sendKeys(Keys.BACK_SPACE).perform();
        }
    }
}
