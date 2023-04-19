package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";  // website Link

    @Before
    public void setUp() {
        //calling Method to open the browser with URL
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToForgotPasswordPageSuccessfully() {
        WebElement loginLink = driver.findElement(By.xpath("//p[text()='Forgot your password? ']")); //
        loginLink.click();
        String expectedMessage = "Reset Password";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        //To close the browser
        closeBrowser();
    }
}
