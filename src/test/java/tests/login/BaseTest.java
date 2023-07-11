package tests.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
