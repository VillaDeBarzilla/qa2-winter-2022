package discovercars.pages;

import discovercars.BaseFunc;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoadingPage {
    private final By FIND_LOADING_ANIMATION = By.xpath(".//div[@class = 'spinner-container']");
    private final By FIND_FIRST_TEXT = By.xpath(".//div[contains(@class, 'mb-8')]");
    private final By FIND_SECOND_TEXT = By.xpath(".//div[contains(@class, 'mb-24')]");

    private BaseFunc baseFunc;


    public LoadingPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void checkingLoadingPageInfo(){
        WebElement loadingAnimation = baseFunc.findElement(FIND_LOADING_ANIMATION);
        boolean checkAnimationPresence = loadingAnimation.isEnabled();
        Assertions.assertTrue(checkAnimationPresence, "No loading animation on loading page");

        WebElement loadingFirstText = baseFunc.findElement(FIND_FIRST_TEXT);
        boolean checkFirstTextPresence = loadingFirstText.isEnabled();
        Assertions.assertTrue(checkFirstTextPresence, "No first text on loading page");

        WebElement loadingSecondText = baseFunc.findElement(FIND_SECOND_TEXT);
        boolean checkSecondTextPresence = loadingSecondText.isEnabled();
        Assertions.assertTrue(checkSecondTextPresence, "No second text on loading page");
    }

}
