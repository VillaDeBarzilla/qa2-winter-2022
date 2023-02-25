package homework5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class AmazonTest {
    private final By ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By CLICK_CONTINUE_BTN = By.xpath(".//span[contains(@class, 'glow-toaster-button-dismiss')]");
    private final By CLICK_BESTSELLERS = By.xpath(".//a[contains(@data-csa-c-content-id, 'nav_cs_bestsellers')]");
    private final By CLICK_ON_BOOKS = By.xpath(".//div[contains(@class, '_p13n-zg-nav-tree-all_style_zg-browse-item__1rdKf')]/a");
    private final By FINDING_FOURTH_BOOK = By.xpath(".//a[@class = 'a-link-normal']/i");
    private final By GETTING_STARS = By.xpath(".//span[@class = 'a-icon-alt']");
    private final By GETTING_REVIEWS = By.xpath(".//div[contains(@class, 'a-section review')]");
    private final By NEXT_PAGE_BTN = By.xpath(".//li[@class = 'a-last']");
    private final By NEXT_PAGE_BTN_DISABLED = By.xpath(".//li[@class = 'a-disabled a-last']");

    private WebDriver browser;
    private WebDriverWait wait;


    @Test
    public void findingStarsComments() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.amazon.de/");
        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        //--- ACCEPTING COOKIES
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        //--- CLICKING CONTINUE BTN
        wait.until(ExpectedConditions.elementToBeClickable(CLICK_CONTINUE_BTN));
        browser.findElement(CLICK_CONTINUE_BTN).click();

        //--- CLICK ON BESTSELLERS
        browser.findElement(CLICK_BESTSELLERS).click();

        //--- CLICK ON BOOKS
        List<WebElement> booksInMenu = browser.findElements(CLICK_ON_BOOKS);
        for (WebElement we : booksInMenu) {
            if (we.getText().equals("Books")) {
                we.click();
                break;
            }
        }

        //--- FINDING STARS ON A FIRST PAGE
        List<WebElement> findingStarsFirst = browser.findElements(GETTING_STARS);
        String starsFirst = findingStarsFirst.get(1).getAttribute("innerText");
        String textFirst = starsFirst;
        String starsCountFirst = textFirst.split(" ")[0];

        //--- FINDING 4TH BOOK AND CLICKING ON IT
        List<WebElement> findingBook = browser.findElements(FINDING_FOURTH_BOOK);
        findingBook.get(1).click();

        //--- FINDING STARS ON A SECOND PAGE
        List<WebElement> findingStarsSecond = browser.findElements(GETTING_STARS);
        String starsSecond = findingStarsSecond.get(0).getAttribute("innerText");
        String textSecond = starsSecond;
        String starsCountSecond = textSecond.split(" ")[0];

        //--- COMPARE STARS ON TWO PAGES
        Assertions.assertEquals(starsCountFirst, starsCountSecond, "Stars are not equals");

        List<WebElement> reviews = browser.findElements(GETTING_REVIEWS);
        for (int i = 0; i < reviews.size(); i++) {
            reviews.get(i);
                 }

        WebElement nextPageEnabled = browser.findElement(NEXT_PAGE_BTN);
       // WebElement nextPageDisabled = browser.findElement(NEXT_PAGE_BTN_DISABLED);

        if(nextPageEnabled.isDisplayed()) nextPageEnabled.click();





     // WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
     // WebElement selectElement =
     //         wait.until(ExpectedConditions
     //                 .visibilityOfElementLocated(NEXT_PAGE_BTN));
     // browser.findElement(NEXT_PAGE_BTN).click();



    }

 //  @AfterEach
 //  public void closeBrowser() {
 //      browser.close();
 //  }
}

