package homework1;

public class Smartphone {
    //smartphone description
    private double screenSize;
    private String brandName;
    private String modelName;
    private Long imeiNumber;
    private boolean screenProtection;

    //---------SETTERS/GETTERS------

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(Long imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    public boolean isScreenProtection() {
        return screenProtection;
    }

    public void setScreenProtection(boolean screenProtection) {
        this.screenProtection = screenProtection;
    }
}
