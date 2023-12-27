package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPages {
    private WebDriver driver;
    private String url = "https://www.saucedemo.com/";
    public LoginPages(WebDriver driver) {
        this.driver = driver;
    }
    private By username = By.cssSelector("*[data-test=\"username\"]");
    private By password = By.cssSelector("*[data-test=\"password\"]");
    private By btnLogin = By.cssSelector("*[data-test=\"login-button\"]");
    private By mochila = By.id("add-to-cart-sauce-labs-bike-light");
    private By carrinho = By.id("shopping_cart_container");
    private By verificarProdutoNoCarrinho = By.cssSelector(".inventory_item_name");

     public void url() {
        driver.get(url);
    }
    public void inserirUsuarioSenha(String usuario, String senha) {
        driver.findElement(username).click();
        driver.findElement(username).sendKeys(usuario);
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(senha);
    }

    public void btnLogin() {

         driver.findElement(btnLogin).click();
    }

    public void addMochila() {
        driver.findElement(mochila).click();
    }

    public void verCarrinho() {
        driver.findElement(carrinho).click();
    }

    public void verificarProdutoNoCarrinho() {
        Assert.assertTrue(driver.findElement(verificarProdutoNoCarrinho).isDisplayed());
    }
}
