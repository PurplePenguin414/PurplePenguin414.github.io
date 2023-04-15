// Delta College - CST 283 - Klingler & Gaddis Text                  
// This class implements a binary search tree of String data.

public class BinarySearchTree
{
    // This class represents the result of removing a node from a binary tree.
    private class RemovalResult 
    {
        Node node;    // Removed node
        Node tree;    // Remaining tree

        RemovalResult(Node node, Node tree) 
        {
            this.node = node;
            this.tree = tree;
        }
    }

    // Node class
    public class Node 
    {
        String value;
        Node left, right;

        // Constructor for leaf nodes
        Node(String val) 
        {
            value = val;
            left = null;
            right = null;
        }

        // Constructor for non-leaf nodes
        Node(String val, Node leftChild, Node rightChild) 
        {
            value = val;
            left = leftChild;
            right = rightChild;
        }
    }

    private Node root;

    // ----------------------------------------------------------------------
    // Check if the binary tree is empty.
    public boolean isEmpty() 
    {
        return root == null;
    }

     // ----------------------------------------------------------------------
    /**
     * The public add method adds a value to the tree by calling a private add
     * method and passing it the root of the tree.
     *
     * @param newItem The value to add to the tree.
     * @return true.
     */
    public boolean add(String newItem) 
    {
        root = add(newItem, root);
        return true;
    }

    /**
     * The add method adds a value to the search tree.
     *
     * @newData the value to add.
     * @param bstree The root of the binary search tree.
     * @return The root of the resulting binary search tree.
     */
    private Node add(String newData, Node bstree) 
    {
        if (bstree == null) 
            return new Node(newData);
        
        // bstree is not null. 
        if (newData.compareTo(bstree.value) < 0)
        {
            // Add newData to the left subtree and replace 
            // the current left subtree with the result.
            bstree.left = add(newData, bstree.left);
        } 
        else 
        {
            // Add newData to the right subtree.
            bstree.right = add(newData, bstree.right);
        }
        return bstree;
    }

    // ----------------------------------------------------------------------
    /**
     * The remove method removes a value from the binary search tree.
     *
     * @param removalTarget The value to remove.
     * @returns true if removalTarget was removed, false if removalTarget not found.
     */
    public boolean remove(String removalTarget) 
    {
        RemovalResult result = remove(root, removalTarget);
        if (result == null) 
            return false;
        else
        {
            root = result.tree;
            return true;
        }
    }

    // This remove method removes a value a from a binary search tree
    // and returns the removed node and the remaining tree wrapped in a
    // RemovalResult object.
    // Parameter bTree is binary search tree (or subtree)
    //  @param bTree The binary search tree.
    //  @param deleteValue The value to be removed.
    //  @return null if deleteValue is not found in bTree.
    private RemovalResult remove(Node bTree, String deleteValue) 
    {
        if (bTree == null) 
            return null;
        
        if (deleteValue.compareTo(bTree.value) < 0) 
        {
            // Remove deleteValue from the left subtree.
            RemovalResult result = remove(bTree.left, deleteValue);
            if (result == null) 
                return null;
            bTree.left = result.tree;
            result.tree = bTree;
            return result;
        }
        
        if (deleteValue.compareTo(bTree.value) > 0)
        {
            // Remove deleteValue from the right subtree.
            RemovalResult result = remove(bTree.right, deleteValue);
            if (result == null) 
                return null;
            bTree.right = result.tree;
            result.tree = bTree;
            return result;
        }
        
        // deleteValue is in this root node.      
        // Is it a leaf? 
        if (bTree.right == null && bTree.left == null) 
            return new RemovalResult(bTree, null);

        // Does the node have two children?
        if (bTree.right != null && bTree.left != null) 
        {
            // Remove largest node in left subtree and 
            // make it the root of the remaining tree.
            RemovalResult remResult = removeLargest(bTree.left);
            Node newRoot = remResult.node;
            newRoot.left = remResult.tree;
            newRoot.right = bTree.right;

            // Prepare the result to be returned.
            bTree.left = null;
            bTree.right = null;
            return new RemovalResult(bTree, newRoot);
        }
        
        // The node has one child
        Node node = bTree;
        Node tree;
        if (bTree.left != null) 
            tree = bTree.left;
        else
            tree = bTree.right;
        
        node.left = null;
        node.right = null;
        return new RemovalResult(node, tree);
    }

    /**
     * The removeLargest method removes the largest node from a binary search
     * tree.
     *
     * @param bTree: The binary search tree.
     * @return The result of removing the largest node.
     */
    private RemovalResult removeLargest(Node bTree) 
    {
        if (bTree == null) 
            return null;
        
        if (bTree.right == null) 
        {
            // Root is the largest node
            Node tree = bTree.left;
            bTree.left = null;
            return new RemovalResult(bTree, tree);
        } 
        else 
        {
            // Remove the largest node from the right subtree.
            RemovalResult remResult = removeLargest(bTree.right);
            bTree.right = remResult.tree;
            remResult.tree = bTree;
            return remResult;
        }
    }

    // ----------------------------------------------------------
    // Public launcher for IN-ORDER traversal
    public void traverseInOrder() 
    {        
        System.out.println("IN-ORDER"); 
        
        inorder(root);    // Launch recursion
   
        System.out.println("\n\n");
    }

    private void inorder(Node btree) 
    {
        if (btree != null) 
        {
            inorder(btree.left);
            System.out.print(btree.value + " ");
            inorder(btree.right);
        }
    }
    
    // ----------------------------------------------------------
    // Public launcher for PRE-ORDER traversal
    public void traversePreOrder() 
    {        
        System.out.println("PRE-ORDER"); 
        
        preorder(root);    // Launch recursion
   
        System.out.println("\n\n");
    }

    private void preorder(Node btree) 
    {
        if (btree != null) 
        {
            System.out.print(btree.value + " ");
            preorder(btree.left);
            preorder(btree.right);
        }
    }
   
    // ----------------------------------------------------------
    // Public launcher for POST-ORDER traversal
    public void traversePostOrder() 
    {        
        System.out.println("POST-ORDER"); 
        
        postorder(root);    // Launch recursion
   
        System.out.println("\n\n");
    }

    private void postorder(Node btree) 
    {
        if (btree != null) 
        {
            postorder(btree.left);
            postorder(btree.right);
            System.out.print(btree.value + " "); 
        }
    }

}
