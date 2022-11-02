package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By formAuthenticationLink = By.linkText("Form Authentication");

    private By abTestingLink = By.cssSelector("a[href='/abtest']");


    public LoginPage clickFormAuthentication(){
        driver.findElement(formAuthenticationLink).click();
        return  new LoginPage(driver);
    }

    public ControlPage clickABTesting(){
        driver.findElement(abTestingLink).click();
        return new ControlPage(driver);
    }

}
