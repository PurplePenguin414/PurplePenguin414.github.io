// Delta College - CST 283 - Klingler
// This class defines a framework common to all classroom assessment.
// It is an abstract class and therefore cannot be instantiated.

public abstract class GradedAssessment
{
   protected int score;  // Numeric score

   // No-arg constructor
   public GradedAssessment()
   {
       score = 0;
   }

   // Set/get methods
   public void setScore(int s)
   {
      score = s;
   }
   public int getScore()
   {
      return score;
   }

   // Method derives and returns letter grade A..F based on stored score
   public char determineGrade()
   {
      char letterGrade;

      if (score >= 90)
         letterGrade = 'A';
      else if (score >= 80)
         letterGrade = 'B';
      else if (score >= 70)
         letterGrade = 'C';
      else if (score >= 60)
         letterGrade = 'D';
      else
         letterGrade = 'F';

      return letterGrade;
   }
}