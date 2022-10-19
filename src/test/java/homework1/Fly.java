package homework1;

public class Fly {
    //description of a real fly
    private int qtyOfWings;
    private double speed;
    private String color;
    private boolean live;
    private int age;

    //---------SETTERS/GETTERS---------


    public int getQtyOfWings() {
        return qtyOfWings;
    }

    public void setQtyOfWings(int qtyOfWings) {
        this.qtyOfWings = qtyOfWings;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
