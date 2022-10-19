package homework1;

public class Window {
    //window description
    private String color;
    private double width;
    private double height;
    private String transparency;
    private boolean blinds;

    //---------SETTERS/GETTERS---------

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public boolean isBlinds() {
        return blinds;
    }

    public void setBlinds(boolean blinds) {
        this.blinds = blinds;
    }
}
