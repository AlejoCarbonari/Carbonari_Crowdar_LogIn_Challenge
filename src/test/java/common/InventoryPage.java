package common;

import common.myUtils.Utils;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends acts.common.basePage
{
    Utils utils = new Utils();
    WebDriverWait wait;

    public void visualizeContainer()
    {
        wait = utils.setExplicitWait();
        wait.until(ExpectedConditions.visibilityOf(utils.getElementById("inventory_container")));
    }

    public void visualizeInventoryListImages()
    {
        long currentImagesQuantity = utils.getElementsByCssSelector(".inventory_item_img > a > img")
                .stream()
                .map(element -> element.getAttribute("src"))
                .distinct()
                .count();

        long ExpectedImagesQuantity = utils.getElementsByCssSelector(".inventory_item_img > a > img")
                .size();

        Assert.assertEquals(currentImagesQuantity, ExpectedImagesQuantity);
    }
}
