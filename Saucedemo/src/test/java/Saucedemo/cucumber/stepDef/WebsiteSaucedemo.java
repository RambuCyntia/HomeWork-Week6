package Saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebsiteSaucedemo {
    WebDriver driver;
    WebDriverWait wait;

    @Given("Navigate in Login Page")
    public void Navigate_Login_Page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        String Url = driver.getCurrentUrl();
        System.out.println(Url);
        Assert.assertEquals("https://www.saucedemo.com/", Url);
    }

    @And("Input valid username")
    public void Valid_Username() {
        WebElement logininput = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        logininput.sendKeys("standard_user");
    }

    @And("Input valid password")
    public void Valid_Password() {
        WebElement passwordinput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordinput.sendKeys("secret_sauce");
    }

    @And("Input invalid password")
    public void Invalid_Password() {
        WebElement passwordinput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordinput.sendKeys("secret");
    }

    @When("Click login button")
    public void Click_Login_Button() {
        WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginbutton.click();
    }

    @Then("User in dashboard menu")
    public void User_In_Dashboard_Menu() {
        WebElement header_label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")));
        String logo = header_label.getText();
        System.out.println(logo);
        Assert.assertEquals("Swag Labs", logo);
        driver.quit();
    }

    @Then("User can't login and get error message")
    public void User_Error_Login_Message() {
        // Add code to verify the error message here
        WebElement AlertKredensial = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")));
        String AlertText = AlertKredensial.getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", AlertText);
        driver.quit();
    }

    @When("User Pick Product and Click Add to cart Button")
    public void Pick_Product() {
        WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        loginbutton.click();
    }

    @Then("User successfully remove product from cart")
    public void successfully_remove() {
        WebElement header_label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")));
        String button = header_label.getText();
        System.out.println(button);
        Assert.assertEquals("Remove", button);
        driver.quit();
    }

    @Then("User successfully add to cart")
    public void successfully_addtocart() {
        WebElement header_label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")));
        String button = header_label.getText();
        System.out.println(button);
        Assert.assertEquals("Remove", button);
        driver.quit();
    }

}
