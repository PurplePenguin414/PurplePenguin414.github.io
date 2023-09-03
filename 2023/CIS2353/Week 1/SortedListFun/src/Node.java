
public class Node {
    private int total;
    private String orderName;
    private Node next;
    
    public Node(int total, String orderName) {
        this(total, orderName, null);
    }
    
    public Node(int total, String orderName, Node next) {
        this.total = total;
        this.orderName = orderName;
        this.next = next;
    }//end Node
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public int getTotal() {
        return total;
    }
    
    public String getOrderName() {
        return orderName;
    }
    
    public Node getNext() {
        return next;
    }
    
}//end class Node
