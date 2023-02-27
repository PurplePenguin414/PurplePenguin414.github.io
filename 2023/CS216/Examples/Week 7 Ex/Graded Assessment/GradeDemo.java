// Delta College - CST 283 - Klingler
// This class is a driver to test features of the GradedAssessment
// family of classes.  It prompts the user for input for 2 quizzes,
// 2 tests, and one final example (in one comma-separated input line).

import javax.swing.JOptionPane;

public class GradeDemo
{
   Quiz quiz1, quiz2;
   Test test1, test2;
   FinalExam exam;

   public static void main(String[] args)
   {
      // Manage test objects
      Test test1 = new Test(43,51,80);
      test1.gradeTest();
      Test test2 = new Test(55,75,90);
      test2.gradeTest();

      // Manage quiz objects
      Quiz quiz1 = new Quiz(16);
      quiz1.gradeTest();
      Quiz quiz2 = new Quiz(19);
      quiz2.gradeTest();

      // Manage final exam objects
      FinalExam exam = new FinalExam(78,84,90,15);
      exam.gradeTest();

      // Build output string
      String output = "Test 1: " + test1.getScore() + " (" + test1.determineGrade() + ")\n" +
                      "Test 2: " + test2.getScore() + " (" + test2.determineGrade() + ")\n" +
                      "Quiz 1: " + quiz1.getScore() + " (" + quiz1.determineGrade() + ")\n" +
                      "Quiz 2: " + quiz2.getScore() + " (" + quiz2.determineGrade() + ")\n" +
                      "Final:  " + exam.getScore()  + " (" + exam.determineGrade()  + ")";

      // Display the report
      JOptionPane.showMessageDialog(null,output);

      System.exit(0);
   }
}