package homework3;

import org.junit.jupiter.api.Test;

public class RouteCalculation {
    @Test
    public void workingWithRoute() {
        Transport calculatingTransport = new Transport();
            calculatingTransport.setCar("Car Opel");
            calculatingTransport.setCarTankVol(80);
            calculatingTransport.setCarFuelConsump(5);
            calculatingTransport.setCarTotalKm(calculatingTransport.carTankVol / calculatingTransport.carFuelConsump * 100);
            calculatingTransport.setTrain("Train ЧМЭ3");
            calculatingTransport.setTrainTankVol(6000);
            calculatingTransport.setTrainFuelConsump(200);
            calculatingTransport.setTrainTotalKm(calculatingTransport.trainTankVol / calculatingTransport.trainFuelConsump * 100);
            calculatingTransport.setPlane("Plane TU-134");
            calculatingTransport.setPlaneTankVol(18000);
            calculatingTransport.setPlaneFuelConsump(400);
            calculatingTransport.setPlaneTotalKm(calculatingTransport.planeTankVol / calculatingTransport.planeFuelConsump * 100);

        Route calculatingRoute = new Route();
            calculatingRoute.setStart("Riga");
            calculatingRoute.setFinish("Barcelona");
            calculatingRoute.setDistance(3000);

        //------Output
        System.out.println("Route calculation for" + " " + calculatingTransport.getCar() + "," + " " + calculatingTransport.getTrain() + "," + " " + calculatingTransport.getPlane() + ".");
        System.out.println("Will the following vehicles have enough fuel to get from" + " " + calculatingRoute.getStart() + " " + "to" + " " + calculatingRoute.getFinish() + " " + "(" + calculatingRoute.getDistance() + "km)?");
        System.out.println(" ");

        //------Car output
        System.out.println("---------------CAR--------------");
        System.out.println(calculatingTransport.getCar() + " " + "will goes" + " " + calculatingTransport.getCarTotalKm() + " " + "km on a full tank" + " " + "(" + calculatingTransport.carTankVol + "L)?");

            if (calculatingTransport.carTotalKm < calculatingRoute.distance) {
                System.out.println("❌ This amount of fuel IS NOT ENOUGH for this route.");
            }
            if (calculatingTransport.carTotalKm >= calculatingRoute.distance) {
                System.out.println("✔ This amount of fuel IS ENOUGH for this route.");
            }

        //------Train output
        System.out.println(" ");
        System.out.println("--------------TRAIN-------------");
        System.out.println(calculatingTransport.getTrain() + " " + "will goes" + " " + calculatingTransport.trainTotalKm + " " + "km on a full tank" + " " + "(" + calculatingTransport.trainTankVol + "L)?");

            if (calculatingTransport.trainTotalKm < calculatingRoute.distance) {
                System.out.println("❌ This amount of fuel IS NOT ENOUGH for this route.");
            }
            if (calculatingTransport.trainTotalKm >= calculatingRoute.distance) {
                System.out.println("✔ This amount of fuel IS ENOUGH for this route.");
            }

        //------Plane output
        System.out.println(" ");
        System.out.println("--------------PLANE-------------");
        System.out.println(calculatingTransport.getPlane() + " " + "will goes" + " " + calculatingTransport.planeTotalKm + " " + "km on a full tank" + " " + "(" + calculatingTransport.planeTankVol + "L)?");

            if (calculatingTransport.planeTotalKm < calculatingRoute.distance) {
                System.out.println("❌ This amount of fuel IS NOT ENOUGH for this route.");
            }
            if (calculatingTransport.planeTotalKm >= calculatingRoute.distance) {
                System.out.println("✔ This amount of fuel IS ENOUGH for this route.");
            }

        //------Copyright
        System.out.println(" ");
        System.out.println("© Code by Eduards Barzilovics");
    }
}