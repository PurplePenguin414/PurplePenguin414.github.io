// Delta College - CST 283 - Klingler
// This class defines a final exam assessment.  It inherits from Test and is
// essentially a test with a 10 point extra credit component added.
// These components are calculated and then the score is mapped to a 100 percentage
// point scale.

public class FinalExam extends Test
{
   private int extraCredit;  // Number multiple choice correct

   private final int TEST_COMPONENT_POINTS = 90;

   // No-arg constructor
   public FinalExam()
   {
      extraCredit = 0;
   }

   // Parameterized constructor
   public FinalExam(int c, int p, int a, int e)
   {
      super(c,p,a);      // Instantiate data from Test class
      extraCredit = e;
   }

   // Set/get methods
   public void setExtraCredit(int e) {
      extraCredit = e;
   }
   public int setExtraCredit() {
      return extraCredit;
   }

   // This method grades a test based on the stored data.
   // Scheme:  100 points total:
   // --> 100 points from Test components contributes 90% of test
   // --> Extra credit points from this class added to it.
   // Assign "score" inherited from superclass
   public void gradeTest()
   {
      super.gradeTest();    // Grade standard test components
      score = (int)Math.round(super.getScore() / 100.0 * TEST_COMPONENT_POINTS) + extraCredit;
   }

   // Method toString() for debugging.  Data returned as comma-delimited string.
   public String toString()
   {
      return super.toString() + "," + Integer.toString(extraCredit);
   }
}