import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import javax.xml.namespace.QName;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class SeleniumSignupTest {
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.edge.driver","resources/msedgedriver");
        //1. Open chrome browser
        driver = new EdgeDriver();
        //2. Input Selenium Demo Page URL(https://selenium-blog.herokuapp.com
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        //Test1. Verify the user input the right url and he's on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
        //3.Maximize the browser
        driver.manage().window().maximize();
        //4. Click on the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 0)
    public void positiveSignup() throws InterruptedException {
        //Test7 Verify user can signup with valid username and details
        //5. Input your username on the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("steph90");
        //6. input email in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("stephabuts15@qa.team");
        //7. Locate the password field and input your password
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("Desena@50");
        //8. Click on the Signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void clickUser1Item() throws InterruptedException {
        //9. Click on user1 item on the list
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test2. verify that user is directed to the signup page when user clicks the signup button
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct Webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. Search for an item (Using Python with Selenium) and confirm that it is present
        //Test 9
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        String expectedPageUrl = "http://selenium-blog.herokuapp.com";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Page Contains Item");
        else
            //fail
            System.out.println("Page does not contain Item");
        Thread.sleep(5000);
    }
    @Test (priority = 3)
    public void logoutSuccessfully () throws InterruptedException {

        //11. CLick on logout
        //Test10 verify that user is directed to Homepage when User logs out
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(5000);
        String expectedTitle = "https://selenium-blog.herokuapp.com";
        String actualTitle = driver.getCurrentUrl();
        if (actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("User directed to homepage");
        else
            //fail
            System.out.println("USer not directed to Homepage");
        Thread.sleep(5000);

    }
    @Test(priority = 4)
    public void negativeSignup() throws InterruptedException {
        //click on signup button
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //Test3 Verify user cannot signup with username less than 3 characters
        //5. Input your username on the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("st");
        //6. input email in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("stephabuts@qa.com");
        //7. Locate the password field and input your password
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("commit@12");
        //8. Click on the Signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
}
