package homework2;

import homework1.Bottle;
import org.junit.jupiter.api.Test;

public class BottleMethod
{
    @Test
    public void workingWithBottle() {
        Bottle watchingBottle = new Bottle();

        watchingBottle.setColor("Blue");
        watchingBottle.setFilled(true);
        watchingBottle.setQuantity(1);
        watchingBottle.setVolume(2.0);
        watchingBottle.setTransparency(true);

        System.out.println("Object Bottle");
        System.out.println(watchingBottle.getColor());
        System.out.println(watchingBottle.getQuantity());
        System.out.println(watchingBottle.getVolume() + " " + "L");
        System.out.println(watchingBottle.isFilled());
        System.out.println(watchingBottle.isTransparency());
    }

}

