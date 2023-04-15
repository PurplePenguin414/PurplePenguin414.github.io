// Delta College - CST 283 - Klingler             
// This class is a test driver for a generic binary search tree.
// Features testing:  insert, delete, traversal, search

public class BinarySearchTreeDemo2 
{
    public static void main(String[ ] args)
    {	   
         BinarySearchTree<String> binTree = new BinarySearchTree<String>();
         
         binTree.add("J");
         binTree.add("E");
         binTree.add("A");
         binTree.add("H");
         binTree.add("T");
         binTree.add("M");         
         binTree.add("Y"); 

         binTree.traverseInOrder();
         binTree.traversePreOrder();
         binTree.traversePostOrder();
         
         binTree.remove("J");
         binTree.remove("E");
                  
         binTree.traverseInOrder();
         binTree.traversePreOrder();
         binTree.traversePostOrder();
         
         String searchTarget = "T";
         if (binTree.contains(searchTarget))
             System.out.println(searchTarget + " FOUND");
         else
             System.out.println(searchTarget + " NOT FOUND");         

         searchTarget = "X";
         if (binTree.contains(searchTarget))
             System.out.println(searchTarget + " FOUND");
         else
             System.out.println(searchTarget + " NOT FOUND");  
    }   
}