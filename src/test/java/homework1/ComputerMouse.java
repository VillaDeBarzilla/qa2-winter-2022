package homework1;

public class ComputerMouse {
    //computer mouse description
    private int numberOfButtons;
    private boolean bluetooth; //wireless or not
    private String color;
    private String brandName;
    private boolean additionalButtons;

    //----------SETTERS/GETTERS----------


    public int getNumberOfButtons() {
        return numberOfButtons;
    }

    public void setNumberOfButtons(int numberOfButtons) {
        this.numberOfButtons = numberOfButtons;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isAdditionalButtons() {
        return additionalButtons;
    }

    public void setAdditionalButtons(boolean additionalButtons) {
        this.additionalButtons = additionalButtons;
    }
}
