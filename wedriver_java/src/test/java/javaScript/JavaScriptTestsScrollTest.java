package javaScript;

import base.BaseTest;
import org.testng.annotations.Test;

public class JavaScriptTestsScrollTest extends BaseTest {
    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollParagraphPresent(){
        var infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(5);
    }
}
