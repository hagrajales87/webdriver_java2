package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private WebDriver driver;

    private By textBox = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnTextBox(){
        driver.findElement(textBox).click();
    }

    public void enterText(String text){
        driver.findElement(textBox).sendKeys(text);
    }

    public String getResult(){
        return driver.findElement(resultText).getText();
    }

    public void enterPi(){
        enterText(Keys.chord(Keys.ALT, "p") + "π=3.14");
    }

}
