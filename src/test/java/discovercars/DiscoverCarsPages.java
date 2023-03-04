package discovercars;

import discovercars.pages.MainPage;
import org.junit.jupiter.api.Test;

public class DiscoverCarsPages {
    private final String URL = "http://www.discovercars.com";
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void discoverCarsTest(){
        baseFunc.openUrl(URL);

        MainPage mainPage = new MainPage(baseFunc);
        mainPage.clickAcceptCookies();
        mainPage.selectLatvia();
        mainPage.changeCurrency();
        mainPage.selectTownAndDates();
    }


}
