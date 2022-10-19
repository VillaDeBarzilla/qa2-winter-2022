package homework2;

import homework1.Flower;
import org.junit.jupiter.api.Test;

public class FlowerMethod {
    @Test
    public void workingWithFlower(){
        Flower watchingFlower = new Flower();

        watchingFlower.setColor("White");
        watchingFlower.setLength(30);
        watchingFlower.setName("Camomile");
        watchingFlower.setThorns(false);
        watchingFlower.setOdorIntensity("Low");

        System.out.println("Object Flower");
        System.out.println(watchingFlower.getName());
        System.out.println(watchingFlower.getColor());
        System.out.println(watchingFlower.getLength() + " " + "cm");
        System.out.println(watchingFlower.isThorns());
        System.out.println(watchingFlower.getOdorIntensity());


    }
}
