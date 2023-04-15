// Delta College - CST 283 - Klingler             
// This class is a test driver for a binary search tree.
// Features testing:  insert, delete, traversal

public class BinarySearchTreeDemo1 
{
    public static void main(String[ ] args)
    {      
         BinarySearchTree binTree = new BinarySearchTree();  
         
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
    }   
}