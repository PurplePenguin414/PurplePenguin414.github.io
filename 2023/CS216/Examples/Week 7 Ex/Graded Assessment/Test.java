// Delta College - CST 283 - Klingler
// This class defines a test assessment.  It inherits from GradedAssessment.
// A test includes a multiple choice component and a short answer component.
// These components are calculated and then the score is mapped to a 100 percentage
// point scale.

public class Test extends GradedAssessment {
   private int multipleChoiceCorrect;  // Number multiple choice correct
   private int mulitpleChoiceTotal;    // Total number multiple choice on test
   private int shortAnswerPctCorrect;  // Pct. correctness of short answer work

   private final int MULTIPLE_CHOICE_POINTS = 75;
   private final int SHORT_ANSWER_POINTS = 25;

   // No-arg constructor
   public Test() {
      multipleChoiceCorrect = 0;
      mulitpleChoiceTotal = 0;
      shortAnswerPctCorrect = 0;
   }

   // Parameterized constructor
   public Test(int c, int p, int a) {
      multipleChoiceCorrect = c;
      mulitpleChoiceTotal = p;
      shortAnswerPctCorrect = a;
   }

   // Set/get methods
   public void setCorrectMC(int c) {
      multipleChoiceCorrect = c;
   }

   public void setPossibleMC(int p) {
      mulitpleChoiceTotal = p;
   }

   public void setShortAnswer(int a) {
      shortAnswerPctCorrect = a;
   }

   public int setCorrectMC() {
      return multipleChoiceCorrect;
   }

   public int setPossibleMC() {
      return mulitpleChoiceTotal;
   }

   public int getShortAnswer() {
      return shortAnswerPctCorrect;
   }

   // This method grades a test based on the stored data.
   // Scheme:  100 points total:
   // --> Multiple choice "weighs" 75% of the total
   // --> Short answer is the remaining 25%
   // Assign "score" inherited from superclass
   public void gradeTest() {
      int multipleChoicePoints
              = (int) Math.round((double) multipleChoiceCorrect / (double) mulitpleChoiceTotal * MULTIPLE_CHOICE_POINTS);
      int shortAnswerPts
              = (int) Math.round(shortAnswerPctCorrect / 100.0 * SHORT_ANSWER_POINTS);

      score = multipleChoicePoints + shortAnswerPts;
   }

   // Method toString() for debugging.  Data returned as comma-delimited string.
   public String toString() {
      return Integer.toString(multipleChoiceCorrect) + ","
              + Integer.toString(mulitpleChoiceTotal) + ","
              + Integer.toString(shortAnswerPctCorrect);
   }
}