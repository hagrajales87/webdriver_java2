package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setup(){
       System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // Create an object of WebDriver class and pass the Chrome Options object as an
        // argument
        driver = new ChromeDriver(getChromeOptions());


        //driver.manage().window().setSize(new Dimension(375, 812));
        driver.manage().window().maximize();

        //WebElement inputsLink = driver.findElement(By.cssSelector("a[href='/inputs']"));
        //WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        //inputsLink.click();

      //List<WebElement> links = driver.findElements(By.tagName("a"));
       // System.out.println(links.size());

     /*   WebElement shiftingContent =driver.findElement(By.linkText("Shifting Content"));
        shiftingContent.click();
        WebElement menuElement = driver.findElement(By.cssSelector(".example a[href*=menu]"));
        menuElement.click();

        List <WebElement> elements = driver.findElements(By.cssSelector("ul>li"));
        System.out.println(elements.size());
*/
        goHome();
        setCookie();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus()){
            var camera = ((TakesScreenshot)driver);
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    @AfterClass
    public void tearDown(){
       // driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){

        // Create an object of Chrome Options class
        ChromeOptions options = new ChromeOptions();

        // prevents Chrome from displaying the notification 'Chrome is being controlled
        // by automated software'
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

        //Run the test cases without open the browser
        /*
        options.setHeadless(true);
         */

        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123").domain("the-internet.herokuapp.com").build();
        driver.manage().addCookie(cookie);
    }

/*    public static void main (String args[]){
        BaseTest test = new BaseTest();
        test.setup();
    }

 */
}
