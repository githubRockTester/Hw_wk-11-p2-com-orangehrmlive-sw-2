package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //Set up method and tear down method
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        //calling Method to open the browser with URL
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.name("username")).sendKeys("Admin");    //Find the login link and enter user ID
        driver.findElement(By.name("password")).sendKeys("admin123");   //Find the password link and enter password
        driver.findElement(By.xpath("//button[text()=' Login ']")).click(); //Find the X-path & Click on login button
        String expectedMessage = "Dashboard";                                       //Expected message
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Dashboard']")); //find x-path for the dashboard
        String actualMessage = actualTextElement.getText();                         //matching actual with the expected
        Assert.assertEquals("Not redirected to login page", expectedMessage, actualMessage); //
    }

    @After
    public void tearDown() {
        //To close the browser
        closeBrowser();
    }
}
