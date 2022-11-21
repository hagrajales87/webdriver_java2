package rightClick;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class rightClickTest extends BaseTest {

    @Test
    public void testRightClick(){
        var contextPage = homePage.clickContextMenu();
        contextPage.rightClickOnSquareFigure();
        assertEquals(contextPage.getAlertText(),"You selected a context menu", "Message is incorrect");
        contextPage.closeAlert();
        assertEquals(contextPage.getContextTitlePage(),"Context Menu", "Invalid Title");
    }


}
