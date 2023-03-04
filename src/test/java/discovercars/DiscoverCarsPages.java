package discovercars;

import discovercars.pages.LoadingPage;
import discovercars.pages.MainPage;
import discovercars.pages.SelectCarPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DiscoverCarsPages {
    private final String URL = "http://www.discovercars.com";
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void discoverCarsTest() {
        baseFunc.openUrl(URL);

        MainPage mainPage = new MainPage(baseFunc);
        mainPage.clickAcceptCookies();
        //mainPage.changeCurrency();
        mainPage.selectLatvia();
        mainPage.selectTownAndDates();
        mainPage.clickSearchNow();

        LoadingPage loadingPage = new LoadingPage(baseFunc);
        loadingPage.checkingLoadingPageInfo();

        SelectCarPage selectCarPage = new SelectCarPage(baseFunc);
        selectCarPage.clickCarousel();
        selectCarPage.selectSmallCars();
        selectCarPage.checkCheckboxes();
        selectCarPage.sortElements();
        selectCarPage.rentalConditions();
        selectCarPage.getCarList();
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowserAfterTest();
    }

}
