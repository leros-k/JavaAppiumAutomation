package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject{

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_TITLE_FOR_COMPARE,
            SEARCH_WORD,
            FIRST_SEARCH,
            SECOND_SEARCH,
            CLOSE_SEARCH,
            SEARCH_TITLE,
            SEARCH_TITLE_ASSERT,
            SEARCH_TITLE_INIT,
            SEARCH_ELEMENT_PRESENT;


    public SearchPageObject(AppiumDriver driver){

        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring){

        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void initSearchInput(){

        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
    }

    public void waitForCancelButtonToAppear(){

        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear(){

        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void clickCancelSearch(){

        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line){

        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring){

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring){

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles(){
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel(){

        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element.", 15);
    }

    public void assertThereIsNoResultOfSearch(){
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
    }

    public void assertCheckText(){
        this.checkText(SEARCH_TITLE_FOR_COMPARE, "Cannot find search field",5, "We see unexpected title", "Search…");
    }

    public void checkDoubleSearch(){
        this.checkText(FIRST_SEARCH, "Cannot find 'Island of Indonesia' topic searching by Java", 5, "We wait for topic of island", "Island of Indonesia");
        this.checkText(SECOND_SEARCH, "Cannot find 'Java version history' topic searching by Java", 5, "We wait for topic of Java history", "Java version history");
    }

    public void closeSearch(){
        this.waitForElementAndClick(CLOSE_SEARCH, "Cannot find X to cancel search", 5);
    }

    public void bothSearchNotPresent(){
        this.waitForElementNotPresent(FIRST_SEARCH, "'Island of Indonesia' is still present", 5);
        this.waitForElementNotPresent(SECOND_SEARCH, "'Java version history' is still present", 5);
    }

    public void checkWordInSearch(){
        this.checkWordInSearchResult(SEARCH_WORD, "Java is not contains in each results", 5);
    }

    public void initAssertTitle(){
        this.waitForElementAndClick(SEARCH_TITLE,"Cannot find 'Republic in Southern Europe' topic searching by Italy", 20);
    }

    public void assertElementPresent(){
        this.assertElementPresent(SEARCH_TITLE_ASSERT, "We've found some results by request " + SEARCH_TITLE_ASSERT);
    }

    public void initTitle(){
        this.waitForElementAndClick(SEARCH_TITLE_INIT, "Cannot find 'Constitutional monarchy in Southwest Europe' topic searching by Spain", 5);
    }

    public void elementPresent(){
        this.waitForElementPresent(
                SEARCH_ELEMENT_PRESENT,
                "Cannot find article title",
                15
        );
    }
}
