//----------------------------------------------------------------------
//  Delta College - CST 283 - Klingler                          
//  This class implements a set of characters.  It includes not only the
//  means to manage set elements, but also the basic set operations.
//  The set also includes set cardinality.
//
// DOMAIN: A CharSet instance is a set of Unicode characters 
//         having domain with numerical range decimal 32 to 126
//----------------------------------------------------------------------

class CharSet2
{
    private final int MIN_UNICODE_VAL = 32;
    private final int MAX_UNICODE_VAL = 127;  
    
    private boolean[] theSet;     

    //------------------------------------------------------------------
    // No-Arg Constructor
    CharSet2()
    {
        theSet = new boolean [MAX_UNICODE_VAL];
        
        for (int i = MIN_UNICODE_VAL; i < MAX_UNICODE_VAL; i++)
            theSet[i] = false;
    }

    //------------------------------------------------------------------
    // Observer function to test if a set is full.  
    boolean isFull()
    {
        boolean fullOutcome = true;      // Assume full
        for (int i = MIN_UNICODE_VAL; i < MAX_UNICODE_VAL; i++)
        {
            if (theSet[i] == false)     // If any positions marked false,
                fullOutcome = false;    //     then set is not full
        }
        return fullOutcome;
    }

    //------------------------------------------------------------------
    // Observer function to test if a set is empty.  
    boolean isEmpty()
    {
        boolean emptyOutcome = true;      // Assume empty
        for (int i = MIN_UNICODE_VAL; i < MAX_UNICODE_VAL; i++)
        {
            if (theSet[i] == true)       // If any positions marked false,
                emptyOutcome = false;    //     then set is not empty
        }
        return emptyOutcome;
    }

    //------------------------------------------------------------------
    // Insert a member into a set
    // POST: If element not in set domain or already a member, nothing done.
    void insert( char ch )
    {
        if (inDomain(ch))
             theSet[(int)ch] = true;
    }

    //------------------------------------------------------------------
    // Delete a member from a set
    // POST: If element not in set domain or already a member, nothing done.
    void delete( char ch )
    {
        theSet[(int)ch] = false;
    }

    //------------------------------------------------------------------
    // Observer method to test if an element is a member of a set
    boolean isElement( char ch )
    {
        return theSet[(int)ch];
    }

    //------------------------------------------------------------------
    // Determine intersection of two sets
    CharSet2 intersect( CharSet2 set2 )
    {
        CharSet2 resultSet = new CharSet2();

        for (int i = MIN_UNICODE_VAL; i < MAX_UNICODE_VAL; i++)
            resultSet.theSet[i] =(this.theSet[i] && set2.theSet[i]);
        return resultSet;
    }

    //------------------------------------------------------------------
     // Determine union of two sets
    CharSet2 union( CharSet2 set2 )
    {
        CharSet2 resultSet = new CharSet2();

        for (int i = MIN_UNICODE_VAL; i < MAX_UNICODE_VAL; i++)
            resultSet.theSet[i] =(this.theSet[i] || set2.theSet[i]);
        return resultSet;
    }


    //------------------------------------------------------------------
    // Return the set contents as a comma-separated string
    public String toString()
    {
        String outString = "";
        boolean firstCharDone = false;   // To manage comma delimiters
        
        for (int i = MIN_UNICODE_VAL; i < MAX_UNICODE_VAL; i++)
            if (theSet[i] == true)
            {
                if (firstCharDone)
                    outString += "," + (char)i;
                else
                {
                    outString += (char)i;
                    firstCharDone = true;
                }
            }
        return outString;
    }
    
    //------------------------------------------------------------------
    // Private method to test character to determin if with set class domain
    private boolean inDomain(char testChar)
    {
        if (testChar >= MIN_UNICODE_VAL && testChar < MAX_UNICODE_VAL)
            return true;
        else
            return false;
    }

    //------------------------------------------------------------------
    // Private method to return set cardinality (number of elements in set)
    public int cardinality()
    {
        int count = 0;
        for (int i = MIN_UNICODE_VAL; i < MAX_UNICODE_VAL; i++)
        {
            if (theSet[i] == true)
                count++;
        }
        return count;
    }
}

