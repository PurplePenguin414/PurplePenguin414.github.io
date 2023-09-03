
public class OrderDemo {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();
        
        
        orderList.addOrder(100, "John");
        orderList.addOrder(150, "Beth");
        orderList.addOrder(122, "Sally");
        orderList.addOrder(50, "Ali");
        orderList.addOrder(250, "Felix");
        
        orderList.printOrders();
        
        System.out.println("\nUpdated list:");
        //update test?
        orderList.addOrder(25, "Felix");
        orderList.addOrder(111, "Sally");
        
        orderList.printOrders();
    }//end main
}
