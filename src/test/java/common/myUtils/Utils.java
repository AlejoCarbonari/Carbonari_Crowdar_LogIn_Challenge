package common.myUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Utils extends acts.common.basePage
{

    public WebElement getElementById(String id)
    {
        return driver.findElement(By.id(id));
    }

    public WebElement getElementByCssSelector(String selector)
    {
        return driver.findElement(By.cssSelector(selector));
    }

    public List<WebElement> getElementsByCssSelector(String selector)
    {
        return driver.findElements(By.cssSelector(selector));
    }

    public WebDriverWait setExplicitWait()
    {
        return new WebDriverWait(driver, 10);
    }

    public void closePage()
    {
        driver.quit();
    }

}
