import org.junit.jupiter.api.Test;

public class ObjectPractice {
    @Test
    public void workingWithOrders() {
        Order firstOrder = new Order();

        firstOrder.setTotalPrice(12.34);
        firstOrder.setAddress("Rigas street 22");
        firstOrder.setItemCount(9);

        Order secondOrder = new Order();
        secondOrder.setTotalPrice(55.67);
        secondOrder.setAddress("Stabu street 12");
        secondOrder.setItemCount(3);

        System.out.println("Hello, World!");
        System.out.println("1st order:");
        System.out.println(firstOrder.getTotalPrice());
        System.out.println(firstOrder.getAddress());
        System.out.println(firstOrder.getItemCount());

        System.out.println("2nd order:");
        System.out.println(secondOrder.getTotalPrice());
        System.out.println(secondOrder.getAddress());
        System.out.println(secondOrder.getItemCount());
    }
}
