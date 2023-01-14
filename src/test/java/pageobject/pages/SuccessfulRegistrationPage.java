package pageobject.pages;

import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class SuccessfulRegistrationPage {
    private final String TEXT = "Thank You for flying with us!";
    private final By FINAL_TEXT = By.xpath(".//div[@class = 'finalTxt']");

    private BaseFunc baseFunc;

    public SuccessfulRegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean isSuccessfulRegistrationPageAppears(){
        String textOnPage = baseFunc.findElement(FINAL_TEXT).getText();
        return textOnPage.equals(TEXT);
    }

}

