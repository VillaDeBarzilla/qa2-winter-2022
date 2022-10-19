package homework2;

import homework1.Street;
import org.junit.jupiter.api.Test;

public class StreetMethod {
    @Test
    public void workingWithStreet(){
        Street watchingStreet = new Street();

        watchingStreet.setStreetLength(300.50);
        watchingStreet.setStreetName("Salnas");
        watchingStreet.setDistrictName("Plavnieki");
        watchingStreet.setHowManyHouses(30);
        watchingStreet.setFiveStoryHouses(15);
        watchingStreet.setNineStoryHouses(15);

        System.out.println("Object Street");
        System.out.println("Street length:" + " " + watchingStreet.getStreetLength());
        System.out.println("Street name:" + " " + watchingStreet.getStreetName());
        System.out.println("District name:" + " " + watchingStreet.getDistrictName());
        System.out.println("Houses quantity:" + " " + watchingStreet.getHowManyHouses());
        System.out.println("Five story houses:" + " " + watchingStreet.getFiveStoryHouses());
        System.out.println("Nine story houses:" + " " + watchingStreet.getNineStoryHouses());

    }
}
