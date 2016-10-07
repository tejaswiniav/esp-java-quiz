import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Quiz
{
  public static void main(String[] args) {
      /*
        Ask a question and provide 4 choices for it accept the answer entered by the user.
      */
      final int NUM_OF_QUESTIONS = 4;
      final int NUM_OF_OPTIONS = 4;
      //Console console = System.console();
      String quit;

      String[] opt1 = {"o1", "o2", "o3", "o4"};
      String[] opt2 = {"o1", "o2", "o3", "o4"};
      String[] opt3 = {"o1", "o2", "o3", "o4"};
      String[] opt4 = {"o1", "o2", "o3", "o4"};

      // quests is an array of QuestionAnswer.
      // Each element of this array will refer to object of class QuestionAnswer
      ArrayList<QuestionAnswer> quests = new ArrayList<QuestionAnswer>();

      // Initialize the array

      quests.add(new QuestionAnswer("question1", opt1, 1));
      quests.add(new QuestionAnswer("question2", opt2, 4));
      quests.add(new QuestionAnswer("question3", opt3, 2));
      quests.add(new QuestionAnswer("question4", opt4, 3));
      quests.add(new QuestionAnswer("question5", opt1, 1));
      quests.add(new QuestionAnswer("question6", opt2, 4));
      quests.add(new QuestionAnswer("question7", opt3, 2));
      quests.add(new QuestionAnswer("question8", opt4, 3));

      // Play the quiz and get answers from user.
      // Play until the user says quit.
      do
      {
        int score = 0;
        Scanner input = new Scanner(System.in);
        for (int qIndex=0; qIndex<quests.size(); qIndex++)
        {
          System.out.println("Question" + (qIndex+1) + ": " + quests.get(qIndex).getQuestion());
          System.out.println("Your options are:");
          System.out.print(quests.get(qIndex));
          System.out.print("Answer(1): ");
          int uAnswer = input.nextInt();
          quests.get(qIndex).setUserChoice(uAnswer);
          if(quests.get(qIndex).getUserChoice() == quests.get(qIndex).getSolution())
          {
            score++;
            System.out.println("Good Job! That's correct\n");
          }
          else
          {
            System.out.println("Oops!! Wrong one\n");
          }
        }
        System.out.println("Your score is: " + score + " on " + quests.size());
        double percent = ((double)score/(double)quests.size())*100;
        System.out.println("Your percent is: " + percent + "%");
        System.out.print("Do you want to play again? (y/n): ");
        quit = input.next();
    } while (quit.equals("y"));

  }

}
