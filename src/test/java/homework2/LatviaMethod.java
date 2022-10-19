package homework2;

import homework1.Latvia;
import org.junit.jupiter.api.Test;

public class LatviaMethod {
    @Test
    public void workingWithLatvia(){
        Latvia watchingLatvia = new Latvia();

        watchingLatvia.setArea(64.589);
        watchingLatvia.setAccessToTheSea(true);
        watchingLatvia.setNumberOfInhabitants(1902000);
        watchingLatvia.setNumberOfLakes(2000);
        watchingLatvia.setNumberOfRivers(12500);

        System.out.println(watchingLatvia.getArea() + " " + "km²");
        System.out.println("Access to the sea" + " " + watchingLatvia.isAccessToTheSea());
        System.out.println(watchingLatvia.getNumberOfInhabitants() + " " + "citizens");
        System.out.println(watchingLatvia.getNumberOfLakes() + " " + "lakes");
        System.out.println(watchingLatvia.getNumberOfRivers() + " " + "rivers");

    }
}
