package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class fileUploadTests extends BaseTest {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\curses\\SeleniumCurse\\wedriver_java\\resources\\test.pdf");
        assertEquals(uploadPage.getUploadFileName(), "test.pdf", "Incorrect Name");
    }
}
