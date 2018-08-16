package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search…')]",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results found']",
            SEARCH_TITLE_FOR_COMPARE = "org.wikipedia:id/search_src_text",
            SEARCH_WORD = "org.wikipedia:id/page_list_item_container",
            FIRST_SEARCH = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Island of Indonesia']",
            SECOND_SEARCH = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java version history']",
            CLOSE_SEARCH = "org.wikipedia:id/search_close_btn",
            SEARCH_TITLE = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Republic in Southern Europe']",
            SEARCH_TITLE_ASSERT = "//*[@resource-id='org.wikipedia:id/view_page_title_text']",
            SEARCH_TITLE_INIT = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Constitutional monarchy in Southwest Europe']",
            SEARCH_ELEMENT_PRESENT = "org.wikipedia:id/view_page_title_text";


    public SearchPageObject(AppiumDriver driver){

        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring){

        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void initSearchInput(){

        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
    }

    public void waitForCancelButtonToAppear(){

        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear(){

        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
    }

    public void clickCancelSearch(){

        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line){

        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring){

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring){

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles(){
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request ",
                15
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultsLabel(){

        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result element.", 15);
    }

    public void assertThereIsNoResultOfSearch(){
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "We supposed not to find any results");
    }

    public void assertCheckText(){
        this.checkText(By.id(SEARCH_TITLE_FOR_COMPARE), "Cannot find search field",5, "We see unexpected title", "Search…");
    }

    public void checkDoubleSearch(){
        this.checkText(By.xpath(FIRST_SEARCH), "Cannot find 'Island of Indonesia' topic searching by Java", 5, "We wait for topic of island", "Island of Indonesia");
        this.checkText(By.xpath(SECOND_SEARCH), "Cannot find 'Java version history' topic searching by Java", 5, "We wait for topic of Java history", "Java version history");
    }

    public void closeSearch(){
        this.waitForElementAndClick(By.id(CLOSE_SEARCH), "Cannot find X to cancel search", 5);
    }

    public void bothSearchNotPresent(){
        this.waitForElementNotPresent(By.xpath(FIRST_SEARCH), "'Island of Indonesia' is still present", 5);
        this.waitForElementNotPresent(By.xpath(SECOND_SEARCH), "'Java version history' is still present", 5);
    }

    public void checkWordInSearch(){
        this.checkWordInSearchResult(By.id(SEARCH_WORD), "Java is not contains in each results", 5);
    }

    public void initAssertTitle(){
        this.waitForElementAndClick(By.xpath(SEARCH_TITLE),"Cannot find 'Republic in Southern Europe' topic searching by Italy", 20);
    }

    public void assertElementPresent(){
        this.assertElementPresent(By.xpath(SEARCH_TITLE_ASSERT), "We've found some results by request " + SEARCH_TITLE_ASSERT);
    }

    public void initTitle(){
        this.waitForElementAndClick(By.xpath(SEARCH_TITLE_INIT), "Cannot find 'Constitutional monarchy in Southwest Europe' topic searching by Spain", 5);
    }

    public void elementPresent(){
        this.waitForElementPresent(
                By.id(SEARCH_ELEMENT_PRESENT),
                "Cannot find article title",
                15
        );
    }
}
