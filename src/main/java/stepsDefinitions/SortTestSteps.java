package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTestSteps extends CommonFunctions {
    private String option3;

    //Sort functionality for name (A to Z)
    @Then("User should see {string} and {string} in sort dropdown")
    public void sortDropdown(String option1, String option2)
    {
        new Select(driver.findElement(By.className("product_sort_container"))).selectByVisibleText(option1);
        System.out.println("The sorted string is : " +option1);
        new Select(driver.findElement(By.className("product_sort_container"))).selectByVisibleText(option2);
        System.out.println("The sorted string is : " +option2);
/*
        Boolean isEnable = new Boolean(driver.findElement(By.className("product_sort_container")));
        isEnable.selectByVisibleText(option1);
        Assert.assertTrue(isEnable);
        System.out.println("Sorted A to z is enable : "+isEnable);*/

    }

//Sort functionality for price (low  to high)
    @When("user choose {string} sort option")
    public void sortOption(String option3){

      // getting all price list from each products before sorting
        List<WebElement> beforeSortPrice = driver.findElements(By.className("inventory_item_price"));

        //Get all price using array list using for loop
        List<Double> beforeSortPriceList = new ArrayList<>();

        for(WebElement priceList : beforeSortPrice) {
            beforeSortPriceList.add(Double.valueOf(priceList.getText().replace("$","")));
        }
        System.out.println("The products price before sort : "+beforeSortPriceList);
        System.out.println("----------------------------------------------");

        // picking price text low to high from sort dropdown
       WebElement sortDropDown = driver.findElement(By.className("product_sort_container"));
       new Select(sortDropDown).selectByVisibleText(option3);
        System.out.println("The sorted string is : "+option3);

        // getting all price list from each products "After" sorting
        List<WebElement> afterSortPrice = driver.findElements(By.className("inventory_item_price"));
        //Get all price using array list using for loop
        List<Double>afterSortList = new ArrayList<>();

            for(WebElement priceList :afterSortPrice)
            {
            afterSortList.add(Double.valueOf(priceList.getText().replace("$","")));
            //System.out.println("The products price after sort : " +text);

        }
        Collections.sort(beforeSortPriceList);
      // Assert.assertEquals(beforeSortPriceList,afterSortList);
        System.out.println("The products price after sort : "+beforeSortPriceList);
    }


    //sort functions in another method

/*     for(int i=0; i<beforeSortPrice.size();i++)
    {
        String text= beforeSortPrice.get(i).getText().replace("$", "");
        System.out.println("The products price before sort : "+text);

    }
    */

//Sort functionality for price (high  to low)

    @Then("the products get sort accordingly {string}")
    public void sortHighToLow(String option4) {
        // getting all price list from each products before sorting
        List<WebElement> beforeSortPriceList = driver.findElements(By.className("inventory_item_price"));

        //Get all price using array list using for loop
        List<Double> beforeArraySort = new ArrayList<>();

        for(WebElement priceList : beforeSortPriceList) {
            beforeArraySort.add(Double.valueOf(priceList.getText().replace("$","")));

        }
        System.out.println("The products price before sort : "+beforeArraySort);
        System.out.println("----------------------------------------------");

        // picking price text low to high from sort dropdown
        WebElement sortDropDown1 = driver.findElement(By.className("product_sort_container"));
        new Select(sortDropDown1).selectByVisibleText(option4);
        System.out.println("The sorted string is : "+option4);

        // getting all price list from each products "After" sorting
        List<WebElement> afterSortPrice1 = driver.findElements(By.className("inventory_item_price"));
        //Get all price using array list using for loop
        List<Double>afterSortList1 = new ArrayList<>();
        for(WebElement priceList1 :afterSortPrice1)
        {
            afterSortList1.add(Double.valueOf(priceList1.getText().replace("$","")));
            //System.out.println("The products price after sort : " +text);

        }
        Collections.sort(afterSortList1);
        //descending order (high to low)
        Collections.reverse(beforeArraySort);//descending order (high to low)
        Assert.assertEquals(beforeArraySort,afterSortList1);


        System.out.println("The products price after sort : "+beforeArraySort);

    }



}// main sort test close brace
