public class DeliveryVehicle {
    private String registrationNumber;
    private VehicleType vehicleType;
    private String city;
    private int activeOrdersCount;

    public DeliveryVehicle(String registrationNumber, VehicleType vehicleType, String city) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.city = city;
        this.activeOrdersCount = 0;
    }

    // Getters and setters
}
