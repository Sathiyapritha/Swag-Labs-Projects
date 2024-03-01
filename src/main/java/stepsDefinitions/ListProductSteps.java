package stepsDefinitions;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonFunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static stepsDefinitions.LoginSteps.driver;

public class ListProductSteps extends CommonFunctions {

   @Then("User should see {int} products listed")
    public void verifyAllProductsListed(int numberOfProducts) {
    List< WebElement> productsPage = driver.findElements(By.xpath("//div[@class='inventory_item']"));
    Assert.assertEquals(numberOfProducts, productsPage.size());
    //productsPage.size();
    System.out.println("Number of product list : "+numberOfProducts);

    }

 @Then("User should see products with {string},{string}, {string}, {string}, and {string} button")
 public void userShouldSeeAllProducts(String title, String price, String description, String imageAlt, String addToCartBtnText)
     {
    String text = driver.findElement(By.xpath("//div[text()='"+title+"']")).getText();
      //Assert.assertEquals(title,driver.findElement(By.xpath("//div[text()='"+title+"']")).getText());
      //Assert.assertEquals(title, actualTitle);

      System.out.println("The product Title is : "+title);


        // (Another method to get txt using string webelement)  //String priceDet = driver.findElement(By.xpath("//div[text()='"+title+"']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div")).getText();
      Assert.assertEquals(price, driver.findElement(By.xpath("//div[text()='"+title+"']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div")).getText());
      System.out.println("The product Price is : "+price);

      Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+title+"']/ancestor::a/following-sibling::div")).getText().contains(description));
      System.out.println("The product Description is : "+description);

      Assert.assertEquals(imageAlt,driver.findElement(By.xpath("//div[text()='"+imageAlt+"']/ancestor::div[@class='inventory_item']/div[@class='inventory_item_img']/a/img")).getAttribute("alt"));
      System.out.println("The product Image-txt is : "+imageAlt);

      Assert.assertEquals(addToCartBtnText,driver.findElement(By.xpath("//div[text()='"+title+"']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/button")).getText());
      System.out.println("The product Cart button is : "+addToCartBtnText);
/*
      Assert.assertEquals(addToCartBtnText,driver.findElement(By.xpath("//div[text()='"+title+"']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/button")).getText());
      System.out.println("The product Cart button is : "+addToCartBtnText);*/

      driver.quit();
    }


/* public void userShouldSeeProductsWithAndButton(String string, String string2, String string3, String string4, String string5)
 {
 }*/
}

