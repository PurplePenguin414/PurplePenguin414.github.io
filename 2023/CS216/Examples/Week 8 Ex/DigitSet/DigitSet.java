//----------------------------------------------------------------------
//  This module exports a digit set ADT.  The domain of the set are all digits 0...9
//  Set representation: a bit string.
// NOTE: Bits are numbered such that 0 is the rightmost bit
//----------------------------------------------------------------------

public class DigitSet
{
	int bitStr;     // Integer container for bit string

    // No-arg constructor.  Set to empty set (zero)
	public DigitSet()
	{
		bitStr = 0;
	}

	// Accessor for empty set.  If bit string == integer zero, then it is empty.
	public boolean isEmpty()
	{
		return (bitStr == 0);
	}

	// Domain is contrained to 0...9.  Loop shifts a '1' bit through
	// each position.  If 'and' operation with any position results in
	// '0', then false is returned (i.e. not full)
	public boolean isFull()
	{
		boolean fullTest = true;
		for (int i = 0; i < 10; i++)
			if ((bitStr & (1 << i)) == 0)
				fullTest = false;
		return fullTest;
	}

	// Insert an element into the set.
	// Strategy is to create a bit string with only one digit.  Shift one to position for
	// given digit to insert and perform bitwise-or with the given set string.
	public void insert(int someDig)
	{
		bitStr = bitStr | (1 << someDig);
	}

	// Delete an element from the set.
	// Strategy is to create a bit string with only one digit.  Shift one to position for
	// given digit, compliment the bit string, and perform bitwise-and to remove the digit
	// for with the given set string.
	public void delete(int someDig)
	{
		bitStr = bitStr & ~(1 << someDig);
	}

	// Accessor to test if a given element is in set.
    // Utilize bit shift with bitwise-and to detect if a binary digit is '1'.
	public boolean isElement(int someDig)
	{
		return ((bitStr & (1 << someDig)) > 0);
	}

	// Write integers currently in set.  Scan bits in set bit string
	// right-to-left and write corresponding integer if bit on.
	// Elements are returned as a String.
	public String toString()
	{
		String outString = "";
		int i;
		for (i = 0; i < 10; i++)
			if ((bitStr & (1 << i)) > 0)
				outString +=  Integer.toString(i);
		return outString;
	}

	// Set intersection.  Return is new set represented by bit string
	// bitStr BITWISE-AND set2.bitStr
	public DigitSet intersection( DigitSet set2 )
	{
		DigitSet newSet = new DigitSet();
		newSet.bitStr = this.bitStr & set2.bitStr;
		return newSet;
	}

	// Set union.  Returnnew set represented by bit string
	// bitStr BITWISE-OR set2.bitStr
	public DigitSet union( DigitSet set2 )
	{
		DigitSet newSet = new DigitSet();
		newSet.bitStr = bitStr | set2.bitStr;
		return newSet;
	}

	// Set equivalence - Tests if integer member values match exactly.
	boolean equals( DigitSet set2 )
	{
		if (bitStr == set2.bitStr)
			return true;
		else
			return false;
	}
}
