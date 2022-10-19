package homework2;

import homework1.Smartphone;
import org.junit.jupiter.api.Test;

public class SmartphoneMethod {
@Test
    public void workingWithSmartphone(){
       Smartphone watchingSmartphone = new Smartphone();

       watchingSmartphone.setBrandName("Samsung");
       watchingSmartphone.setModelName("S21 5G");
       watchingSmartphone.setImeiNumber(2147454654546583647L);
       watchingSmartphone.setScreenSize(5.6);
       watchingSmartphone.setScreenProtection(true);

        System.out.println("Object Smartphone");
        System.out.println("Brand:" + " " + watchingSmartphone.getBrandName());
        System.out.println("Model:" + " " + watchingSmartphone.getModelName());
        System.out.println("IMEI:" + " " + watchingSmartphone.getImeiNumber());
        System.out.println("Screen size:" + " " + watchingSmartphone.getScreenSize() + " " + " inch ");
        System.out.println("Screen protector:" + " " + watchingSmartphone.isScreenProtection());


    }
}
