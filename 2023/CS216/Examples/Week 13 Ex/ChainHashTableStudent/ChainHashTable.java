// Delta College - CST 283 - Klingler & Gaddis Text                  
// Definition of class ChainDB, which represents a chained hash table data structure

import java.util.*;

class ChainHashTable<ItemType>
{
    final int ARRAY_SIZE = 100;
    
    ArrayList<LinkedList<ItemType>> hashTable;

    public ChainHashTable()
    {
        // Instantiate ArrayList of objects
        hashTable =  new ArrayList<LinkedList<ItemType>>(ARRAY_SIZE);
        
        // Instantiate each generic linked list within ArrayList
        for (int i = 0; i < ARRAY_SIZE; i++)
            hashTable.add(i, new LinkedList<ItemType>());
    }
        
    // Insert an item into the chained hash table
    public void add(ItemType newItem)
    {
       int hashKey;

       hashKey = newItem.hashCode();
       hashTable.get(hashKey).add(newItem);
    }

    // Delete an item from the chained hash table
    public void remove(ItemType oldItem)
    {
       int hashKey;

       hashKey = oldItem.hashCode();
       hashTable.get(hashKey).remove(oldItem);
    }

    // Delete an item from the chained hash table
    public boolean contains(ItemType targetItem)
    {
       int hashKey;

       hashKey = targetItem.hashCode();
       if (hashTable.get(hashKey).contains(targetItem))
           return true;
       else
           return false;
    }

    // Search hash table and retrive an item
    public ItemType retrieve(ItemType targetItem)
    {
       int hashKey;

       hashKey = targetItem.hashCode();
       return hashTable.get(hashKey).retrieve(targetItem);
    }

    // Display list (only show buckets with non-empty lists
    public String toString()
    {
        String returnString = "";
        
        for (int i = 0; i < ARRAY_SIZE; i++)
        {
            if (!hashTable.get(i).isEmpty())
            {
                returnString += Integer.toString(i) + " " + 
                                hashTable.get(i).toString();
            }
        }
        return returnString;
    }

}

