package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSearchField";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_TITLE_FOR_COMPARE = "id:org.wikipedia:id/search_src_text";
        SEARCH_WORD = "id:org.wikipedia:id/page_list_item_container";
        FIRST_SEARCH = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Island of Indonesia']";
        SECOND_SEARCH = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java version history']";
        CLOSE_SEARCH = "id:org.wikipedia:id/search_close_btn";
        SEARCH_TITLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Republic in Southern Europe']";
        SEARCH_TITLE_ASSERT = "xpath://*[@resource-id='org.wikipedia:id/view_page_title_text']";
        SEARCH_TITLE_INIT = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Constitutional monarchy in Southwest Europe']";
        SEARCH_ELEMENT_PRESENT = "id:org.wikipedia:id/view_page_title_text";
    }

    public iOSSearchPageObject(AppiumDriver driver){
        super(driver);
    }
}
