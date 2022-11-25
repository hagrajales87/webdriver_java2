package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

import java.util.List;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setup(){
       System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();


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
        System.out.println(driver.getTitle());
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
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

/*    public static void main (String args[]){
        BaseTest test = new BaseTest();
        test.setup();
    }

 */
}
