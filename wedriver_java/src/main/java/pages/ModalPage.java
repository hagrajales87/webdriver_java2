package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalPage {

    private WebDriver driver;
    private By openModal = By.id("restart-ad");
    private By modalTitle = By.cssSelector(".modal h3");
    private By close = By.cssSelector(".modal-footer p");
    private By text = By.cssSelector(".modal-body p");
    private By pageTitle = By.cssSelector(".example h3");



    public ModalPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnOpenModalLink(){
        driver.findElement(openModal).click();
    }

    public String getModalTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalTitle)));
        return driver.findElement(modalTitle).getText();
    }

    public String getModalText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(text)));
        return driver.findElement(text).getText();
    }

    public void closeModal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(close)));
        driver.findElement(close).click();
    }

    public String getPageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(pageTitle)));
        return driver.findElement(pageTitle).getText();
    }
}
