package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class alertTest extends BaseTest {

    @Test
    public void testAcceptAlert(){
        var alertPage = homePage.clickAlert();
        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResultMessage(), "You successfully clicked an alert", "Incorrect Message");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertPage = homePage.clickAlert();
        alertPage.triggerConfirm();
        String text = alertPage.alert_getText();
        alertPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        var alertPage = homePage.clickAlert();
        alertPage.triggerPrompt();

        String text = "TAU rocks!";
        alertPage.alert_setInput(text);
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResultMessage(), "You entered: " +text, "Results text incorrect");
    }

}
