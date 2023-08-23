public class Order {
    private static int orderCount = 1;
    private int orderNumber;
    private Item item;
    private double price;
    private Customer customer;
    private DeliveryVehicle deliveryVehicle;
    private OrderStatus status;

    public Order(Item item, Customer customer, DeliveryVehicle deliveryVehicle) {
        this.orderNumber = orderCount++;
        this.item = item;
        this.price = item.getPrice();
        this.customer = customer;
        this.deliveryVehicle = deliveryVehicle;
        this.status = OrderStatus.PENDING;
    }

    // Getters and setters
}
