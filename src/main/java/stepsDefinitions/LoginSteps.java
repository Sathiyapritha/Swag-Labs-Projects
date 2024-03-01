package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonFunctions;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends CommonFunctions {

    @Given("User should navigate to home page {string}")
    public void UserShouldNavigateHomePage(String url)
    {
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }

    @Given("User should enter username as {string}")
    public void userShouldEnterUsernameAs(String username)
    {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    @Given("User should enter password as {string}")
    public void userShouldEnterPasswordAs(String password)
    {

        driver.findElement(By.id("password")).sendKeys(password);
    }
    @When("User clicks login button")
    public void userClicksLoginButton()
    {

        driver.findElement(By.id("login-button")).click();
    }

    @Then("User should be login successfully and redirect to products page {string}")
    public void userShouldBeLoginSuccessfully(String string)
    {
      String expectedProductPageTitle = "Products";
        String actualProductPageTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(expectedProductPageTitle,actualProductPageTitle);
        System.out.println("Actual Product name is :"+actualProductPageTitle);
       // driver.quit();
    }

    @Then("User should be fail with error message as {string}")
    public void userShouldBeFailWithErrorMessage(String string)
    {
       String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMsg);
        System.out.println("Error message is:" + actualErrorMsg);
        //driver.quit();
    }



  }






