// Delta College - CST 283 - Klingler & Gaddis Text                  
// This class implements a binary search tree of String data.

public class BinarySearchTree<ItemType extends Comparable<ItemType>>
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
        ItemType value;
        Node left, right;

        // Constructor for leaf nodes
        Node(ItemType val) 
        {
            value = val;
            left = null;
            right = null;
        }

        // Constructor for non-leaf nodes
        Node(ItemType val, Node leftChild, Node rightChild) 
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
    public boolean add(ItemType newItem) 
    {
        root = add(newItem, root);
        return true;
    }
    
    /**
     * The add method adds a value to the search tree.
     *
     * @newItem the value to add.
     * @param bstree The root of the binary search tree.
     * @return The root of the resulting binary search tree.
     */
    private Node add(ItemType newData, Node bstree) 
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
    public boolean remove(ItemType removalTarget) 
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
    private RemovalResult remove(Node bTree, ItemType deleteValue) 
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
    
    
    // ---------------------------------------------------------------------
    // The contains method checks to see if a value is in the binary tree.
    // Param searchTarget The value to check for.
    // Return true if searchTarget is in the tree, false otherwise.
    public boolean contains(ItemType searchTarget) 
    {
        // Call the private recursive method.
        return contains(searchTarget, root);
    }

    // The method contains checks whether an item is in a binary search tree.
    // Param searchItem The item to check for.
    // Param bstree The binary tree to look in.
    // Return true if found, false otherwise.
    private boolean contains(ItemType searchItem, Node bstree) 
    {
        if (bstree == null) 
            return false;

        if (searchItem.compareTo(bstree.value) == 0)
            return true;
        if (searchItem.compareTo(bstree.value) < 0)
            // Recursively look in left subtree.
            return contains(searchItem, bstree.left);
        else 
            // Recursively look in right subtree.
            return contains(searchItem, bstree.right);
    }
    
    // --------------------------------------------------------------
    // Method searches for existence of target in tree.  If matching 
    // (i.e. compareTo method returns zero) object from list is returned.
    public ItemType retrieve(ItemType target)
    {
        // Call the private recursive method.
        return retrieve(target, root);
    }

    // The method contains checks whether an item is in a binary search tree.
    // Param searchItem The item to check for.
    // Param bstree The binary tree to look in.
    // Return node value if found; null otherwise.
    private ItemType retrieve(ItemType searchItem, Node bstree) 
    {
        if (bstree == null) 
            return null;

        if (searchItem.compareTo(bstree.value) == 0)
            return bstree.value;
        if (searchItem.compareTo(bstree.value) < 0)
            // Recursively look in left subtree.
            return retrieve(searchItem, bstree.left);
        else 
            // Recursively look in right subtree.
            return retrieve(searchItem, bstree.right);
    }    
    // ---------------------------------------------------------------------
    // The contains method recursively counts the number of elements in the
    // binary search tree.
    // Return: integer count
    public int size()
    {
        return count(root);
    }

    int count(Node tree)
    // Post: returns the number of nodes in the tree.
    {
        if (tree == null)
            return 0;
        else
            return count(tree.left)  + count(tree.right) + 1;
    }

    // ---------------------------------------------------------------------
    // Public method initiating count and returning total to main
    // function call
    public int treeDepth()
    {
        int depth = getDepth(root) - 1;
        return depth;
    }


    // Private function checking maximum depth below current node
    private int getDepth(Node tree)
    {
        if (tree == null)
            return 0;
        else
        {
            // Get depths below current node
            int leftDepth  = getDepth(tree.left);
            int rightDepth = getDepth(tree.right);

            // Return max depth of subtrees plus one for "this" node
            if ( leftDepth > rightDepth)
                return leftDepth  + 1;
            else
                return rightDepth + 1;  
        }  
    }

    private LinkedQueue<ItemType> traversalQueue;

    // ----------------------------------------------------------
    // Public launcher for IN-ORDER traversal
    public LinkedQueue traverseInOrder() 
    {        
        traversalQueue = new LinkedQueue<ItemType>();     
        inorder(root);    // Launch recursion
        return traversalQueue;
    }

    private void inorder(Node btree) 
    {
        if (btree != null) 
        {
            inorder(btree.left);
            traversalQueue.enqueue(btree.value);
            inorder(btree.right);
        }
    }
}