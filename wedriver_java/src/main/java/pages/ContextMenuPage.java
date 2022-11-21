package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContextMenuPage {

    private WebDriver driver;
    private By square = By.id("hot-spot");
    private By pageTitle = By.cssSelector(".example h3");


    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void rightClickOnSquareFigure(){
        Actions actions = new Actions(driver);
        WebElement squareElement = driver.findElement(square);
        actions.contextClick(squareElement).perform();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void closeAlert(){
        driver.switchTo().alert().accept();
    }

    public String getContextTitlePage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(pageTitle)));
        return driver.findElement(pageTitle).getText();
    }

}
