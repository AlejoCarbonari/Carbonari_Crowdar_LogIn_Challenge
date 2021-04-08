package common;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.*;

import common.myUtils.Utils;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HomePage extends acts.common.basePage
{
    Utils utils = new Utils();
    WebDriverWait wait;

    public void openBrowser()
    {
        /* String os = System.getProperty("os.name");
        switch(os)
        {
            case "Linux":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                break;
            case "Windows":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                break;
            case "Mac":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_mac");
                break;
            default:
                System.out.println("Error, os name not found!");
                break;
        } */
        String os = System.getProperty("os.name");
        switch(os)
        {
            case "Linux":
                if (System.getProperties().containsKey("webdriver.gecko.driver"))
                {
                    System.setProperty("webdriver.firefox.bin", "/usr/lib/firefox/firefox");
                }
                break;
        }

        driver = (System.getProperties().containsKey("webdriver.chrome.driver"))
                ? (driver = new ChromeDriver())
                : (driver = new FirefoxDriver());
    }

    public void GoToHomePage()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    public void visualizeHomeView()
    {
        // driver.findElement(By.id("root"));
        wait = utils.setExplicitWait();
        wait.until(ExpectedConditions.titleIs("Swag Labs"));
    }

    public void typeUsername(String username)
    {
        utils.getElementById("user-name").clear();
        utils.getElementById("user-name").sendKeys(username);
    }

    public void typePassword(String password)
    {
        utils.getElementById("password").clear();
        utils.getElementById(("password")).sendKeys(password);
    }

    public void submit()
    {
        utils.getElementById("login-button").click();
    }

    public void visualizeErrorMessage(String expectedMessage)
    {
        String currentMessage = utils.getElementByCssSelector("div.error-message-container > h3").getText();
        Assert.assertEquals(currentMessage, expectedMessage);
    }

}
