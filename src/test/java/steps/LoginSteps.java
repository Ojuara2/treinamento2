package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPages;

import java.io.File;
import java.io.IOException;

public class LoginSteps {
    private WebDriver driver;
    private LoginPages loginPages;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        loginPages = new LoginPages(driver);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
       driver.quit();
    }


    @Given("que acesso a tela de login")
    public void queAcessoATelaDeLogin() {
     loginPages.url();
    }

    @When("preencho os campos {string} e {string}")
    public void preenchoOsCamposE(String usuario, String senha) {
        loginPages.inserirUsuarioSenha(usuario, senha);
        loginPages.btnLogin();
    }

    @Then("devo ver a tela de dashboard")
    public void devoVerATelaDeDashboard() throws IOException {
        imprimirEvidencia("screenshot1");
  }
    public void imprimirEvidencia(String screenshot1) throws IOException {
        File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printFinal, new File("saida/" + screenshot1 + ".png"));
    }

    @And("adiciono mochila")
    public void adicionoMochila() {
        loginPages.addMochila();
    }

    @Then("devo ver a mochila no carrinho")
    public void devoVerAMochilaNoCarrinho() throws IOException {
        loginPages.verCarrinho();
        loginPages.verificarProdutoNoCarrinho();
        imprimirEvidencia("screenshot2");
    }
}









