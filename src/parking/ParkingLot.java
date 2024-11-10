package parking;

import java.util.concurrent.Semaphore;

public class ParkingLot {
    private static final int TOTAL_SPOTS = 4;
    private Semaphore parkingSpots;

    public ParkingLot() {
        this.parkingSpots = new Semaphore(TOTAL_SPOTS, true); // Semaphore to control access
    }

    // Method to attempt parking; returns true if parking was successful
    public boolean tryToPark() {
        return parkingSpots.tryAcquire(); // Acquires a permit if available, or returns false
    }

    // Method to release a parking spot only if it was occupied
    public void leaveSpot() {
        if (getAvailableSpots() < TOTAL_SPOTS) { // Ensure no over-release of permits
            parkingSpots.release();
        }
    }

    // Method to get the number of free spots
    public int getAvailableSpots() {
        return parkingSpots.availablePermits();
    }

    // Log car arrival
    public synchronized void logCarArrival(String carId) {
        System.out.println(carId + " arrived.");
    }

    // Log car parking
    public synchronized void logCarParked(String carId) {
        System.out.println(carId + " parked. (Parking Status: " + (TOTAL_SPOTS - getAvailableSpots()) + " spots occupied)");
    }

    // Log car departure and accurate parking status
    public synchronized void logCarDeparture(String carId) {
        leaveSpot(); // Release the parking spot if it was actually occupied
        System.out.println(carId + " left. (Parking Status: " + getAvailableSpots() + " spots free)");
    }

    // Print a final summary of the simulation
    public void printSummary() {
        System.out.println("Simulation Complete.");
        System.out.println("Final Parking Status: " + getAvailableSpots() + " spots free");
    }
}
