package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By startButton = By.cssSelector(".example #start button");
    private By loadingImage = By.cssSelector("#loading img");
    private By loadedText = By.id("finish");

    public DynamicLoadingExample1Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnStartButton(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loadingImage)));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingImage)));
    }

    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }

}
