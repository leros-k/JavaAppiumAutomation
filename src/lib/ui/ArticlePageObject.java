package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;

abstract public class ArticlePageObject extends MainPageObject{

    protected static String
        TITLE,
        FOOTER_ELEMENT,
        OPTIONS_BUTTON,
        OPTIONS_ADD_TO_MY_LIST_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        CLOSE_ARTICLE_BUTTON;

    public ArticlePageObject(AppiumDriver driver){

        super(driver);
    }

    public WebElement waitForTitleElement(){

        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15);
    }

    public String getArticleTitle(){

        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndoid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter(){

        if (Platform.getInstance().isAndoid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        }
    }

    public void addArticleToMyList(String name_of_folder){

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    public void addArticlesToMySaved(){

        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
    }

    public void closeArticle(){

        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5
        );
    }

    public void openOptions(){
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );
    }

    public void deleteArticle(){
        this.waitForElementAndClick(
                "//*[@resource-id='org.wikipedia:id/item_container']//*[@text='Learning countries']",
                "Cannot find 'Learning countries' list",
                5
        );

        this.waitForElementAndClick(
                "//android.widget.ImageButton[@content-desc='Navigate up']",
                "Cannot close article, cannot find X link",
                15
        );

        this.waitForElementAndClick(
                "//android.widget.FrameLayout[@content-desc='My lists']",
                "Cannot find navigation button to My list",
                5
        );

        String name_of_folder = "Learning countries";

        this.waitForElementAndClick(
                "//*[@text='" + name_of_folder + "']",
                "Cannot find created folder",
                5
        );

        this.swipeElementToLeft(
                "//*[@text='Spain']",
                "Cannot find saved article"
        );

        this.waitForElementPresent(
                "//*[@text='republic in Southern Europe']",
                "Republic in Southern Europe' topic is still present",
                5
        );

        this.waitForElementAndClick(
                "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='republic in Southern Europe']",
                "Cannot find 'republic in Southern Europe' topic searching by Italy",
                5
        );

        this.checkText(
                "//*[@resource-id='org.wikipedia:id/view_page_title_text']//*[@text='Italy']",
                "Cannot find 'Italy' title",
                10,
                "We wait for title 'Italy'",
                "Italy"
        );
    }
}
