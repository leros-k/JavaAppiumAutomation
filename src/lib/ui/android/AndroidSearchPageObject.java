package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
                SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
                SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";
                SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
                SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
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
    public AndroidSearchPageObject(AppiumDriver driver){

        super(driver);
    }
}
