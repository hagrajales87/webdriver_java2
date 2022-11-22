package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromDropDown(String option){
        Select dropdownElement = new Select(driver.findElement(dropdown));
        dropdownElement.selectByVisibleText(option);
        //findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedWebElements = findDropDownElement().getAllSelectedOptions();
        List<String> textElements = new ArrayList<>();
        for (var element : selectedWebElements){
            textElements.add(element.getText());
        }
        return textElements;
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }
}
