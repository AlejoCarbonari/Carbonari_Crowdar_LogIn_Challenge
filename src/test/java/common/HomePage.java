package common;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import common.myUtils.Utils;

import java.util.concurrent.TimeUnit;

public class HomePage extends acts.common.basePage
{
    // estancia de la clase Utils
    Utils utils = new Utils();
    WebDriverWait wait;

    public void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    public void GoToHomePage()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
