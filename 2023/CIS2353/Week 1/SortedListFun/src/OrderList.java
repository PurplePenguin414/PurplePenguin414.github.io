
public class OrderList {
    private Node firstNode;
    
    public OrderList() {
       firstNode = null; 
       
    }
    
    //addOrder:  
    //   - if it doesn't exist (name), add it
    //   - if it already exists (name), update the total
    //     and then move to the correct spot
    public void addOrder(int total, String name) {
        
        //if it's not already in list, then
        //it is new
        //so find where to place it, and place it there

        Node nodeBefore;
        Node nodeAfter;
        
        Node newNode = new Node(total, name);
        
        Node existingNode = alreadyInList(name);
        nodeBefore = getNodeBefore(total);
        
        if(existingNode == null) {
            //node with that Order Name doesn't already
            //exist in the list, so it's brand new!
            if(isEmpty() || nodeBefore == null) {
                //add at the beginning
                newNode.setNext(firstNode);
                firstNode = newNode;
            }
            else {
                //list isn't empty, so:
                // - place the new node where it belongs
                //   OR
                // - update and place already existing data
                //splice in between the node before, and node after
                nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
            }//end if-else for the empty list or if nodeBefore is null
        }
        else {
            //order with that Order Name DOES already
            //exist in the list, so it's not new
            //So we must:
            //1.  Remove the old instance with that name
            //2.  Insert the new node, in the correct place
            
            //1---- Remove the old one (existingNode)
            nodeBefore = getNodeBefore(existingNode);
            //      bypass the node that currently exists
            nodeBefore.setNext(existingNode.getNext());

            
            //2---- Insert the new instance
            //      into the new location, going by the new total
            //      reuse the variables as needed
            nodeBefore = getNodeBefore(total);
            if(isEmpty() || nodeBefore == null) {
                //add at the beginning
                newNode.setNext(firstNode);
                firstNode = newNode;
            }
            else {
                nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);                
            } 
        }//end if-else
    }//end addOrder method
    
    
    //getNodeBefore - (overloaded method)
    //  get the node before the node with the given total
    private Node getNodeBefore(int total) {
        Node currentNode = firstNode;
        Node nodeBefore = null;
        
        while(currentNode != null && total > currentNode.getTotal()) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNext();
        }//end while
        
        return nodeBefore;
    }//end getNodeBefore
    
    //getNodeBefore - (overloaded method)
    //  get the node before the node with the given ADDRESS
    private Node getNodeBefore(Node givenNode) {
        Node currentNode = firstNode;
        Node nodeBefore = null;
        
        while(currentNode != null && currentNode != givenNode) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNext();
        }//end while
        
        return nodeBefore;
    }//end getNodeBefore
    
    public boolean isEmpty() {
        return firstNode == null;
    }
    
    private Node alreadyInList(String name) {
        Node walker = firstNode;
        Node resultNode = null;
        
        while(walker != null) {
            
            if(walker.getOrderName().equals(name)) {
                resultNode = walker;
                break;
            }
            walker = walker.getNext();
        }//end while
            
        return resultNode;
    }
    
    public void printOrders() {
        Node walker = firstNode;
        
        while(walker != null) {
            System.out.println(walker.getOrderName() + ":  $" + walker.getTotal());
            walker = walker.getNext();
        }//end while
    }
    
    
}//end OrderList
