package homework1;

public class Street {
    // street description
    private double streetLength;
    private int howManyHouses;
    private String streetName;
    private String districtName;
    private int fiveStoryHouses;
    private int nineStoryHouses;

    //---------SETTERS/GETTERS---------

    public double getStreetLength() {
        return streetLength;
    }

    public void setStreetLength(double streetLength) {
        this.streetLength = streetLength;
    }

    public int getHowManyHouses() {
        return howManyHouses;
    }

    public void setHowManyHouses(int howManyHouses) {
        this.howManyHouses = howManyHouses;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getFiveStoryHouses() {
        return fiveStoryHouses;
    }

    public void setFiveStoryHouses(int fiveStoryHouses) {
        this.fiveStoryHouses = fiveStoryHouses;
    }

    public int getNineStoryHouses() {
        return nineStoryHouses;
    }

    public void setNineStoryHouses(int nineStoryHouses) {
        this.nineStoryHouses = nineStoryHouses;
    }
}
