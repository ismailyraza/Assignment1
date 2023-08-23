import java.util.List;
import java.util.ArrayList;

public class LogisticsSystem {
    private List<Item> items;
    private List<Customer> customers;
    private List<DeliveryVehicle> deliveryVehicles;
    private List<Order> orders;

    public LogisticsSystem() {
        items = new ArrayList<>();
        customers = new ArrayList<>();
        deliveryVehicles = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    public void addCustomer(String name, String city) {
        customers.add(new Customer(name, city));
    }

    public void addDeliveryVehicle(String registrationNumber, VehicleType vehicleType, String city) {
        deliveryVehicles.add(new DeliveryVehicle(registrationNumber, vehicleType, city));
    }

    public void placeOrder(String itemName, String customerName) throws LogisticsException {
        Item item = findItem(itemName);
        Customer customer = findCustomer(customerName);

        if (item == null || customer == null) {
            throw new LogisticsException("Item or customer not found.");
        }

        DeliveryVehicle availableVehicle = findAvailableVehicle(customer.getCity());
        if (availableVehicle == null) {
            throw new LogisticsException("No available vehicles for this order.");
        }

        if (availableVehicle.getActiveOrdersCount() >= 2) {
            throw new LogisticsException("Delivery vehicle is full. Cannot place order.");
        }

        Order order = new Order(item, customer, availableVehicle);
        availableVehicle.setActiveOrdersCount(availableVehicle.getActiveOrdersCount() + 1);
        orders.add(order);
    }

    public void markOrderDelivered(int orderNumber) throws LogisticsException {
        Order order = findOrder(orderNumber);
        if (order == null) {
            throw new LogisticsException("Order not found.");
        }

        if (order.getStatus() == OrderStatus.DELIVERED) {
            throw new LogisticsException("Order has already been delivered.");
        }

        order.setStatus(OrderStatus.DELIVERED);
        order.getDeliveryVehicle().setActiveOrdersCount(order.getDeliveryVehicle().getActiveOrdersCount() - 1);
    }

    private Item findItem(String itemName) {
        // Implementation to find an item
    }

    private Customer findCustomer(String customerName) {
        // Implementation to find a customer
    }

    private DeliveryVehicle findAvailableVehicle(String city) {
        // Implementation to find an available vehicle
    }

    private Order findOrder(int orderNumber) {
        // Implementation to find an order
    }
}
