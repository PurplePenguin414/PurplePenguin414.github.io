// Delta College - CST 283 - Klingler
// This class defines a quiz assessment.  It inherits from GradedAssessment.
// A quiz is defined by a simple 20 point assessment.  Constructor input
// is the number correct out of 20.  This is mapped then to a 100 point percentage
// point scale.

public class Quiz extends GradedAssessment
{
   private int correctQuizAnswers;  // Number quiz answers correct

   private final int POSSIBLE_QUIZ_POINTS = 20;

   // No-arg constructor
   public Quiz()
   {
      correctQuizAnswers = 0;
   }

   // Parameterized constructor
   public Quiz(int q)
   {
      correctQuizAnswers = q;
   }

   // Set/get methods
   public void setCorrectQuestions(int q)
   {
      correctQuizAnswers = q;
   }
   public int getCorrectQuestions() { return correctQuizAnswers; }


   // This method grades a test based on the stored data.
   // Scheme:  100 points total:
   // --> Multiple choice "weighs" 75% of the total
   // --> Short answer is the remaining 25%
   // Assign "score" inherited from superclass
   public void gradeTest()
   {
      score = (int)Math.round((double)correctQuizAnswers / (double)POSSIBLE_QUIZ_POINTS * 100);
   }

   // Method toString() for debugging
   public String toString()
   {
       return Integer.toString(correctQuizAnswers);
   }
}