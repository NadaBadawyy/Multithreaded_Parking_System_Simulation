package parking;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        // Cars A and B arrive and park
        parkingLot.logCarArrival("Car A");
        if (parkingLot.tryToPark()) {
            parkingLot.logCarParked("Car A");
        }

        parkingLot.logCarArrival("Car B");
        if (parkingLot.tryToPark()) {
            parkingLot.logCarParked("Car B");
        }

        // Car A leaves, making space for Car C
        parkingLot.logCarDeparture("Car A");

        // Car C arrives and parks
        parkingLot.logCarArrival("Car C");
        if (parkingLot.tryToPark()) {
            parkingLot.logCarParked("Car C");
        }

        // Car B and Car C leave
        parkingLot.logCarDeparture("Car B");
        parkingLot.logCarDeparture("Car C");

        parkingLot.printSummary();
    }
}
