package pageobject.model;

public class FlightInfo {
    private String destination;
    private String departure;
    private String discount;
    private int adultCount;
    private int childCount;
    private int bagsCount;
    private String flightDate;
    private int seatNr;
    private Passenger passenger;

    public FlightInfo(String departure, String destination, String discount, int adultCount, int childCount, int bagsCount, String flightDate, int seatNr) {
        this.destination = destination;
        this.departure = departure;
        this.discount = discount;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.bagsCount = bagsCount;
        this.flightDate = flightDate;
        this.seatNr = seatNr;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public int getBagsCount() {
        return bagsCount;
    }

    public void setBagsCount(int bagsCount) {
        this.bagsCount = bagsCount;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getSeatNr() {
        return seatNr;
    }

    public void setSeatNr(int seatNr) {
        this.seatNr = seatNr;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
