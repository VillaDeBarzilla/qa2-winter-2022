package homework5;

import org.junit.jupiter.api.AfterEach;
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
    private final By GETTING_STARS_FIRST = By.xpath(".//div[@class = 'a-icon-row']/a[@class = 'a-link-normal']");
    private final By GETTING_REVIEWS_FIRST = By.xpath(".//span[@class = 'a-size-small']");
    private final By GETTING_STARS_SECOND = By.xpath(".//span[@class = 'a-size-medium a-color-base']");
    private final By GETTING_REVIEWS_SECOND = By.xpath(".//div[contains(@class, 'a-spacing-base a-size-base')]");
    private WebDriver browser;


    @Test
    public void findingStarsComments() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.amazon.de/");
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

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
        List<WebElement> findingStarsFirst = browser.findElements(GETTING_STARS_FIRST);
        String starsFirst = findingStarsFirst.get(3).getAttribute("title");
        String textFirst = starsFirst;
        String starsCountFirst = textFirst.split(" ")[0];
        System.out.println(starsCountFirst);


       //--- FINDING 4TH BOOK AND CLICKING ON IT
       List<WebElement> findingBook = browser.findElements(FINDING_FOURTH_BOOK);
       for(int i = 0; i< 3; i++);
       {
           findingBook.get(3).click();
       }

       //--- FINDING STARS ON A SECOND PAGE
       WebElement findingStarsSecond = browser.findElement(GETTING_STARS_SECOND);
       String starsSecond = findingStarsSecond.getText();
       String textSecond = starsSecond;
       String starsCountSecond = textSecond.split(" ")[0];
       System.out.println(starsCountSecond);

        //--- COMPARE STARS ON TWO PAGES
        Assertions.assertEquals(starsCountFirst, starsCountSecond, "They are equals");

    }
    @AfterEach
    public void closeBrowser(){
        browser.close();
    }
}

