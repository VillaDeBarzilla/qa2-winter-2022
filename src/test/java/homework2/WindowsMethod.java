package homework2;

import homework1.Window;
import org.junit.jupiter.api.Test;

public class WindowsMethod {
    @Test
    public void workingWithWindow(){
        Window watchingWindow = new Window();

        watchingWindow.setColor("White");
        watchingWindow.setBlinds(true);
        watchingWindow.setTransparency("Transparent");
        watchingWindow.setHeight(1.2);
        watchingWindow.setWidth(1.4);

        System.out.println("Object Window");
        System.out.println("Color:" + " " + watchingWindow.getColor());
        System.out.println("Blinds:" + " " + watchingWindow.isBlinds());
        System.out.println(watchingWindow.getTransparency());
        System.out.println("Height:" + " " + watchingWindow.getHeight());
        System.out.println("Width:" + " " + watchingWindow.getWidth());
    }
}
