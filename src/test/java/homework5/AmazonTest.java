package homework5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonTest {
    private WebDriver browser;
    private final By ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By CLICK_BESTSELLERS = By.xpath(".//a[contains(@data-csa-c-content-id, 'nav_cs_bestsellers')]");
    private final By CLICK_ON_BOOKS = By.xpath(".//div[contains(@class, '_p13n-zg-nav-tree-all_style_zg-browse-item__1rdKf')]/a");
    private final By FINDING_FOURTH_BOOK = By.xpath(".//a[@class = 'a-link-normal']/i");
    private final By GETTING_ON_ELEMENT = By.id("averageCustomerReviews");
    private final By GETTING_STARS_FIRST = By.xpath(".//div[@class = 'a-icon-row']/a[@class = 'a-link-normal']");
    private final By GETTING_REVIEWS_FIRST = By.xpath(".//span[@class = 'a-size-small']");
    private final By GETTING_STARS_SECOND = By.xpath(".//span[@class = 'a-size-medium a-color-base']");
    private final By GETTING_REVIEWS_SECOND = By.xpath(".//div[contains(@class, 'a-spacing-base a-size-base')]");



    @Test
    public void findingStarsComments() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.amazon.de/");
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        Actions action = new Actions(browser);

        //--- ACCEPTING COOKIES
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        //--- CLICK ON BESTSELLERS
        browser.findElement(CLICK_BESTSELLERS).click();

        //--- CLICK ON BOOKS
        List<WebElement> booksInMenu = browser.findElements(CLICK_ON_BOOKS);
        for (WebElement link : booksInMenu) {
            if (link.getText().equals("Books")) {
                link.click();
                break;
            }
        }

        //--- FINDING STARS ON THE FIRST PAGE
        List<WebElement> findingStarsFirst = browser.findElements(GETTING_STARS_FIRST);
        for (int i = 0; i < 3; i++) ;
        {
            findingStarsFirst.get(3).getAttribute("title");
            System.out.println(findingStarsFirst.get(3).getAttribute("title"));
        }

        //--- FINDING REVIEWS ON THE FIRST PAGE
        List<WebElement> findingReviewFirst = browser.findElements(GETTING_REVIEWS_FIRST);
        for (int i = 0; i < 3; i++) ;
        {
            findingReviewFirst.get(3).getText();
            System.out.println(findingReviewFirst.get(3).getText());
        }

        //--- FINDING 4TH BOOK AND CLICKING ON IT
        List<WebElement> findingBook = browser.findElements(FINDING_FOURTH_BOOK);
        for (int i = 0; i < 3; i++) ;
        {
            findingBook.get(3).click();
        }

        //--- FINDING STARS ON THE SECOND PAGE
        List<WebElement> findingStarsSecond = browser.findElements(GETTING_STARS_SECOND);
        for (int i = 0; i < 1; i++) ;
        {
            findingStarsSecond.get(0).getText();
            System.out.println(findingStarsSecond.get(0).getText() + " stars");

        }

        //--- FINDING COMMENTS ON THE SECOND PAGE
        List<WebElement> findingReviewsSecond = browser.findElements(GETTING_REVIEWS_SECOND);
        for (int i = 0; i < 1; i++) ;
        {
            findingStarsSecond.get(0).getText();
            System.out.println(findingReviewsSecond.get(0).getText());

        }

        System.out.println("Is stars on a first page equals to a stars on second page? " + findingStarsFirst.equals(findingStarsSecond));
        System.out.println("Is reviews on a first page equals to a reviews on second page? " + findingReviewFirst.equals(findingReviewsSecond));
    }
}

