import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Quiz
{
  private static int mUserScore;

  public static void main(String[] args) {
      /*
        Ask a question and provide 4 choices for it accept the answer entered by the user.
      */
      String quit;

      String[] opt1 = {"The Lost Symbol", "The Alchemist", "Journey to the center of the earth", "The Notebook"};
      String[] opt2 = {"Angels & Demons", "Deception Point", "The Da Vinci Code", "Inferno"};
      String[] opt3 = {"Portland State University", "Harvard University", "Oxford University", "Stanford University"};
      String[] opt4 = {"Physics", "Statistics", "Botny", "Symbology"};
      String[] opt5 = {"Journey to the center of the earth", "Deception Point", "Inferno", "Digital Fortress"};

      // quests is an array of QuestionAnswer.
      // Each element of this array will refer to object of class QuestionAnswer
      ArrayList<QuestionAnswer> quests = new ArrayList<QuestionAnswer>();

      // Initialize the array

      quests.add(new QuestionAnswer("Which novel among the following is authored by Dan Brown?", opt1, 1));
      quests.add(new QuestionAnswer("In which of the novel is Prof. Robert Langdon not featured?", opt2, 2));
      quests.add(new QuestionAnswer("In which college does Prof. Robert Langdon teach?", opt3, 2));
      quests.add(new QuestionAnswer("What is Prof. Robert Langdon's speciality?", opt4, 4));
      quests.add(new QuestionAnswer("Which of the following novel of Dan Brown is also a movie?", opt5, 3));

      // Play the quiz and get answers from user.
      // Play until the user says quit.
      System.out.println("\n#########################################################################################");
      System.out.println("\t\tWelcome to the world of Dan Brown!");
      System.out.println("\t\tTake this quiz and check for yourself if you are a Dan Brown fan.");
      System.out.println("#########################################################################################\n\n");
      do
      {

        System.out.println("\t\tLet's start with the quiz. All the best :)\n");
        Scanner input = new Scanner(System.in);
        for (int qIndex=0; qIndex<quests.size(); qIndex++)
        {
          System.out.println("\nQuestion" + (qIndex+1) + ": " + quests.get(qIndex).getQuestion());
          System.out.print(quests.get(qIndex));
          System.out.print("\tAnswer(1): ");
          int uAnswer = input.nextInt();
          quests.get(qIndex).setUserChoice(uAnswer);
          CalculateScore(quests.get(qIndex));
        }

        System.out.println("You have correctly answered " + getUserScore() + " questions on " + quests.size());
        System.out.println("Your score is: " + CalculatePercent(quests.size()) + "%");
        System.out.print("Do you want to play again? (y/n): ");
        quit = input.next();
        if(quit.equals("y"))
        {
          System.out.println("\n\t\tThis is amazing!! Let's play again. :D\n");
        }
    } while (quit.equals("y"));

  }

  public static Integer getUserScore()
  {
    return Quiz.mUserScore;
  }

  public static void setUserScore(int score)
  {
    Quiz.mUserScore = score;
  }

  public static void CalculateScore(QuestionAnswer quest)
  {
    if(quest.getUserChoice() == quest.getSolution())
    {
      setUserScore((getUserScore() + 1));
      System.out.println("\nGood Job! That's correct\n");
    }
    else
    {
      System.out.println("\nOops!! Wrong one\n");
    }
  }

  public static double CalculatePercent(int length)
  {
    return (((double)getUserScore()/(double)length)*100);
  }

}
