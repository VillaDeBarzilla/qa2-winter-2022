package discovercars.model;

public class CarInfo {
    private String seatsCount = "4 seats";
    private String fuel = "Gasoline";
    private String partialPrepayment = "PARTIAL PREPAYMENT";


    public String getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(String seatsCount) {
        this.seatsCount = seatsCount;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getPartialPrepayment() {
        return partialPrepayment;
    }

    public void setPartialPrepayment(String partialPrepayment) {
        this.partialPrepayment = partialPrepayment;
    }
}
