package control;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ControlPage;


public class ControlTest extends BaseTest {

    @Test
    public void controlTest(){
        ControlPage controlPage = homePage.clickABTesting();

    }
}
