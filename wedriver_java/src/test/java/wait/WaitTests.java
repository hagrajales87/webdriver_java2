package wait;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTest {

    @Test
    public void testWaitUntilHidden(){
        /*var dynamicPage = homePage.clickDynamicLoading();
        var loadingPage = dynamicPage.clickExample1();
        */
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickOnStartButton();

        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
    }
}
