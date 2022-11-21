package login.modal;

import base.BaseTest;
import org.checkerframework.framework.qual.AnnotatedFor;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ModalTest extends BaseTest {

    @Test
    public void testModalTitle(){
        var modalPage = homePage.clickModal();
        //modalPage.clickOnOpenModalLink();
        assertEquals(modalPage.getModalTitle(), "THIS IS A MODAL WINDOW", "Incorrect Title");
    }

    @Test
    public void testModalContent(){
        var modalPage = homePage.clickModal();
        assertEquals(modalPage.getModalText(),"It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker)." ,"Incorrect Text");
    }

    @Test
    public void testCloseModal(){
        var modalPage = homePage.clickModal();
        modalPage.closeModal();
        assertEquals(modalPage.getPageTitle(),"Entry Ad","Incorrect message");

    }

}
