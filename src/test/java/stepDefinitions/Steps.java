package stepDefinitions;

import common.HomePage;
import common.InventoryPage;

import common.myUtils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class Steps
{
    HomePage homePage = new HomePage();
    InventoryPage inventory = new InventoryPage();
    Utils utils = new Utils();

    @Dado("que el usuario abre el navegador")
    public void userOpenBrowser()
    {
        homePage.openBrowser();
    }

    @Y("navega hacia Saucedemo")
    public void openSaucedemoPage()
    {
        homePage.GoToHomePage();
    }

    @Entonces("debería visualizar la página de inicio")
    public void visualizeHomeView()
    {
        homePage.visualizeHomeView();
    }

    /* FIRST SCENARIO */

    @Cuando("el usuario ingresa {string} en el campo username")
    public void enterUsername(String username)
    {
        homePage.typeUsername(username);
    }

    @Y("{string} en el campo password")
    public void enterPassword(String password)
    {
        homePage.typePassword(password);
    }

    @Y("hace click en el botón submit")
    public void clickOnSubmitButton()
    {
        homePage.submit();
    }

    @Entonces("debería visualizar el inventario de productos")
    public void visualizeInventory()
    {
        inventory.visualizeContainer();
    }

    // LOCKED USER SCENARIO

    @Entonces("debería visualizar un error con el siguiente mensaje: {string}")
    public void visualizeErrorLockedUser(String expectedMessage)
    {
        homePage.visualizeErrorMessage(expectedMessage);
    }

    // PROBLEM USER SCENARIO

    @Entonces("debería visualizar correctamente las imágenes en el inventario")
    public void visualizeInventoryList()
    {
        inventory.visualizeInventoryListImages();
    }

    /* SESSION CLOSE */

    @After
    public void shutdownPage()
    {
        // session.close();
        utils.closePage();
    }

}
