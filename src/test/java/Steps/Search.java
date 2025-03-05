package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Search {
    WebDriver driver;
    @Given("open the login page")
    public void open_the_login_page(){

        System.out.println("Opening login page");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/login");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

    }

    @When("enter username {string}")
    public void enter_username(String name){
        //WebDriver driver = new ChromeDriver();
        WebElement username =driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        username.sendKeys(name);
    }


    @And("enter password {string}")
    public void enterPassword(String pass) {
        WebElement password=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        password.sendKeys(pass);
    }

    @Then("click login and redirect")
    public void clickLoginAndRedirect() {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
    }

    @Given("products url")
    public void productsUrl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement productsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")));
        productsTab.click();

        // Ensure the products page loads completely
        wait.until(ExpectedConditions.urlContains("products"));
        System.out.println("Products page opened successfully: " + driver.getTitle());
    }

    @When("enter Shirt")
    public void enterShirt() {
        WebElement shirtSearch=driver.findElement(By.xpath("//*[@id=\"search_product\"]"));
        shirtSearch.sendKeys("Shirt");

    }

    @Then("open related results")
    public void openRelatedResults() {
        WebElement shirtSearch=driver.findElement(By.xpath("//*[@id=\"search_product\"]"));
        shirtSearch.click();
    }
}
