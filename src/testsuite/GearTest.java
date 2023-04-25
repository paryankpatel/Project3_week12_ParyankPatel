package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductsSuccessfullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[7]"));

        // Click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));

        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("(//a[@class = 'product-item-link'])[2]"));

        //Verify the text ‘Overnight Duffle’
        verifyFromElement(By.xpath("//span[@class='base']"),"Overnight Duffle");

        //Change Qty 3
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("3");

        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //Verify the text‘You added Overnight Duffle to your shopping cart.’
        verifyFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),
                "You added Overnight Duffle to your shopping cart.");

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // Verify the product name ‘Overnight Duffle’
        verifyFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"),"Overnight Duffle");

        //Verify the Qty is ‘3’
        //verifyFromElement(By.xpath("(//span[text()='Qty'])[2]"),"3");
        String expectedMessage = "3";
        WebElement actualElement = driver.findElement(By.xpath("//input[@value = '3']"));
        String actualMessage = actualElement.getAttribute("value");
        Assert.assertEquals(expectedMessage,actualMessage);

        //Change Qty to ‘5’
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@class='input-text qty']"));
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextToElement(By.xpath("//input[@class='input-text qty']"),"5");

        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));

        //Verify the product price ‘$225.00’
        verifyFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"), "$225.00");
    }


    @After
    public void tearDown(){

        closeBrowser();
    }
}
