package keys;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTest {

    @Test
    public  void testBackspace(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.clickOnTextBox();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE!", "Text incorrect");

    }

    @Test
    public void testPi(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.clickOnTextBox();
        keyPage.enterPi();
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE!", "Text incorrect");
    }
}
