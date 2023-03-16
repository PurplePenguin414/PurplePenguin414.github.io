/*  This program is a test driver to demonstrate the set    */
/*  operations of the DigitSet class.                       */

public class TestDigitSet 
{
	public static void main(String args[]) 
	{
		// Build test set 1: { 1, 2 } 
		DigitSet set1 = new DigitSet();
		set1.insert(1);
		set1.insert(2);
		System.out.println("Set 1: ");
		System.out.println(set1.toString());

		if (set1.isFull())
			System.out.println("Set is FULL");
		else
			System.out.println("Set is not full");

		// Build test set 2: { 2, 3 } 
		DigitSet set2 = new DigitSet();
		set2.insert(2);
		set2.insert(3);
		System.out.println("Set 2: ");
		System.out.println(set2.toString());

		// Union of sets 1 & 2:  { 1, 2, 3 }
		DigitSet set3;
		set3 = set1.union(set2);
		System.out.println("Set 1 union Set 2: ");
		System.out.println(set3.toString());

		// Intersection of sets 1 & 2:  { 2 }
		DigitSet set4;
		set4 = set1.intersection(set2);
		System.out.println("Set 1 intersection Set 2: ");
		System.out.println(set4.toString());

		// Test deleting element 2 from { 1, 2, 3 }
		set3.delete(2);
		System.out.println("Union (Set 3) of sets 1 and 2 with element 2 deleted: ");
		System.out.println(set3.toString());

		// Test if 3 is element of Set 3
		if (set3.isElement(3))
			System.out.println("Set 3 has 3");
		else
			System.out.println("Set 3 does not have 3");

		// Test if 2 is element of Set 3
		if (set3.isElement(2))
			System.out.println("Set 3 has 2");
		else
			System.out.println("Set 3 does not have 2");

		// Build large set with digits: { 0, 1, 2, ..., 9 } and write it
		DigitSet bigSet = new DigitSet();
		for (int i = 0; i <= 9; i++)
			bigSet.insert(i);
		System.out.println("The big set has: ");
		System.out.println(bigSet.toString());

		if (bigSet.isFull())
			System.out.println("Large Set is FULL");
		else
			System.out.println("Large Set is not full");

		// Build test set 4: { 2, 3 } 
		DigitSet set5 = new DigitSet();
		set5.insert(2);
		set5.insert(3);
		System.out.println("Set 5: ");
		System.out.println(set5.toString());

		if (set2.equals(set5))
			System.out.println("Sets 2 and 5 are equal" );
		else
			System.out.println("Sets 2 and 5 are not equal");
	}
}

