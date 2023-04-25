package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"));
        //Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        //Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElementAndClick(By.id("option-label-size-143-item-175"));

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElementAndClick(By.id("option-label-color-93-item-49"));

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElementAndClick(By.xpath("(//span[text() ='Add to Cart'])[1]"));

        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        verifyFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),"You added Cronus Yoga Pant to your shopping cart.");

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//div[@class='page messages']//a[contains(text(),'shopping cart')]"));

        //Verify the text ‘Shopping Cart.’
        verifyFromElement(By.xpath("//main[@id='maincontent']//h1"), "Shopping Cart");

        //Verify the product name ‘Cronus Yoga Pant’
        verifyFromElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"), "Cronus Yoga Pant");

        // Verify the product size ‘32’
        verifyFromElement(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/div[1]/div[1]/dl[1]/dd[1]/span[1]"), "32");


        //Verify the product colour ‘Black’
        verifyFromElement(By.xpath("//dd[contains(text(),'Black')]"), "Black");


    }
    @After
    public void tearDown(){

        closeBrowser();
    }
}
