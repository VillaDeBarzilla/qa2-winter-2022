package homework2;

import homework1.Fly;
import org.junit.jupiter.api.Test;

public class FlyMethod {
    @Test
    public void workingWithFly(){
        Fly watchingFly = new Fly();

        watchingFly.setAge(5);
        watchingFly.setColor("Black");
        watchingFly.setLive(true);
        watchingFly.setSpeed(1.3);
        watchingFly.setQtyOfWings(2);

        System.out.println("Object Fly");
        System.out.println(watchingFly.getAge() + " " + "days");
        System.out.println(watchingFly.getColor());
        System.out.println(watchingFly.isLive());
        System.out.println(watchingFly.getSpeed() + " " + "km/h");
        System.out.println(watchingFly.getQtyOfWings());

    }
}
