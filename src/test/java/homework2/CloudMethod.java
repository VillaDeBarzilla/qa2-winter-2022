package homework2;

import homework1.Cloud;
import org.junit.jupiter.api.Test;

public class CloudMethod
{
    @Test
    public void workingWithCloud(){
        Cloud watchingCloud = new Cloud();

        watchingCloud.setAlt(10.232);
        watchingCloud.setDirection("To Miami");
        watchingCloud.setShape("Chaotic");
        watchingCloud.setSpeed(125.5);
        watchingCloud.setType("Rainy");

        System.out.println("Object Cloud");
        System.out.println(watchingCloud.getAlt() + " " + "km");
        System.out.println(watchingCloud.getDirection());
        System.out.println(watchingCloud.getShape());
        System.out.println(watchingCloud.getSpeed() + " " + "km/h");
        System.out.println(watchingCloud.getType());

    }

}
