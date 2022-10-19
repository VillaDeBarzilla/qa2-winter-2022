package homework2;

import homework1.Tea;
import org.junit.jupiter.api.Test;

public class TeaMethod {
   @Test
    public void workingWithTea(){
        Tea watchingTea = new Tea();

        watchingTea.setColor("Black");
        watchingTea.setGranulated(false);
        watchingTea.setTaste("Good");
        watchingTea.setTeabag(false);
        watchingTea.setLooseLeaf(true);

        System.out.println("Object tea");
        System.out.println("Color:" + " " + watchingTea.getColor());
        System.out.println("Taste:" + " " + watchingTea.getTaste());
        System.out.println("Granulated:" + " " + watchingTea.isGranulated());
        System.out.println("Teabag:" + " " + watchingTea.isTeabag());
        System.out.println("Loose leaf:" + " " + watchingTea.isLooseLeaf());
    }
}
