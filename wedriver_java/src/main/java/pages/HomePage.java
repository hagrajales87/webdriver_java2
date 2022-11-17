package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //private By formAuthenticationLink = By.linkText("Form Authentication");

    private By abTestingLink = By.cssSelector("a[href='/abtest']");


    public LoginPage clickFormAuthentication(){

        clickLink("Form Authentication");
        //driver.findElement(formAuthenticationLink).click();
        return  new LoginPage(driver);
    }

    public ControlPage clickABTesting(){
        driver.findElement(abTestingLink).click();
        return new ControlPage(driver);
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickHovers(){
        clickLink("Hovers");
        return  new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
