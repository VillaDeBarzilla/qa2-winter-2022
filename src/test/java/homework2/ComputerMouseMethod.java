package homework2;

import homework1.ComputerMouse;
import org.junit.jupiter.api.Test;

public class ComputerMouseMethod {
    @Test
    public void workingWithMouse(){
        ComputerMouse watchingMouse = new ComputerMouse();

        watchingMouse.setBluetooth(true);
        watchingMouse.setColor("Blue");
        watchingMouse.setAdditionalButtons(true);
        watchingMouse.setNumberOfButtons(3);
        watchingMouse.setBrandName("Logitech");

        System.out.println("Object Computer Mouse");
        System.out.println(watchingMouse.getBrandName());
        System.out.println(watchingMouse.getColor());
        System.out.println(watchingMouse.isBluetooth());
        System.out.println(watchingMouse.isAdditionalButtons());
        System.out.println(watchingMouse.getNumberOfButtons());

    }
}
