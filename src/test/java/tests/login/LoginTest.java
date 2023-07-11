package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.LoginPage;

public class LoginTest extends BaseTest {

    private final String INVALID_LOGIN = "asd";
    private final String INVALID_PASSWORD = "asd";
    private final String LOGIN = "pawookpaw@gmail.com";
    private final String PASSWORD = "pawook111";

    @Test
    public void loginEmptyCredentialsTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.openHomePage()
                .openLoginPage()
                .login(INVALID_LOGIN, INVALID_PASSWORD);
        loginPage.clearCredentials(INVALID_LOGIN, INVALID_PASSWORD);

        Assert.assertTrue(loginPage.waiter.untilVisible(loginPage.loginErrorMessage).isDisplayed());
        Assert.assertTrue(loginPage.waiter.untilVisible(loginPage.passwordErrorMessage).isDisplayed());

        loginPage.login(LOGIN, PASSWORD);
    }

    @Test
    public void loginWithInvalidCredentialsTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.openHomePage()
                .openLoginPage()
                .login(INVALID_LOGIN, INVALID_PASSWORD);

        Assert.assertTrue(loginPage.waiter.untilVisible(loginPage.mainErrorBanner).isDisplayed());
    }

    @Test
    public void loginWithValidCredentialsTest() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.openHomePage()
                .openLoginPage()
                .login(LOGIN, PASSWORD);

        Assert.assertTrue(loginPage.waiter.untilVisible(homePage.userIcon).isDisplayed());
    }
}
