import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LogisticsSystem logisticsSystem = new LogisticsSystem();

        logisticsSystem.addItem("Item A", 10.0);
        logisticsSystem.addItem("Item B", 20.0);

        logisticsSystem.addCustomer("Customer X", "City1");
        logisticsSystem.addCustomer("Customer Y", "City2");

        logisticsSystem.addDeliveryVehicle("ABC123", VehicleType.BIKE, "City1");
        logisticsSystem.addDeliveryVehicle("XYZ456", VehicleType.TRUCK, "City2");

        try {
            logisticsSystem.placeOrder("Item A", "Customer X");
            logisticsSystem.placeOrder("Item B", "Customer Y");

            logisticsSystem.markOrderDelivered(1);
            logisticsSystem.markOrderDelivered(2);
        } catch (LogisticsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
