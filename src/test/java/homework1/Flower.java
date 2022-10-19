package homework1;

public class Flower {
    //flower description
    private int length;
    private String color;
    private String name;
    private String odorIntensity;
    private boolean thorns;

    //-----------GETTERS/SETTERS---------


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOdorIntensity() {
        return odorIntensity;
    }

    public void setOdorIntensity(String odorIntensity) {
        this.odorIntensity = odorIntensity;
    }

    public boolean isThorns() {
        return thorns;
    }

    public void setThorns(boolean thorns) {
        this.thorns = thorns;
    }
}
