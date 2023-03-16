//----------------------------------------------------------------------
//  Delta College - CST 283 - Klingler                          
//  This class implements a generic set of Objects.  It wraps around
//  the standard Java HashSet class using inheritance to add required
//  set operations.
//----------------------------------------------------------------------

import java.util.*;

class GenSet<ItemType> extends HashSet<ItemType>
{
    //------------------------------------------------------------------
    // No-Arg Constructor
    // Implicitly instantiate set by further instantiating base set class
    GenSet()
    {
        // Do nothing
    }

    //------------------------------------------------------------------
    // Determine intersection of two sets
    GenSet intersection( GenSet set2 )
    {
        GenSet intersectSet = new GenSet();

        intersectSet.addAll(this);
        intersectSet.retainAll(set2);
        return intersectSet;
    }
    
    //------------------------------------------------------------------
    // Determine union of two sets
    GenSet union( GenSet set2 )
    {
        GenSet unionSet = new GenSet();

        unionSet.addAll(this);
        unionSet.addAll(set2);
        return unionSet;
    }
    
}

