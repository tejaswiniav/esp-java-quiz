import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.List;


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

      Hashtable question_list = new Hashtable();

      question_list.put(1, new Triplet.with("question1", opt1, 1));
      question_list.put(2, new Triplet.with("question2", opt2, 4));
      question_list.put(3, new Triplet.with("question3", opt2, 2));
      question_list.put(4, new Triplet.with("question4", opt2, 3));


      // quests is an array of QuestionAnswer.
      // Each element of this array will refer to object of class QuestionAnswer
      QuestionAnswer[] quests = new QuestionAnswer[NUM_OF_QUESTIONS];

      // Initialize the array
      /*
      quests[0] = new QuestionAnswer("question1", opt1, 1);
      quests[1] = new QuestionAnswer("question2", opt2, 4);
      quests[2] = new QuestionAnswer("question3", opt3, 2);
      quests[3] = new QuestionAnswer("question4", opt4, 3);
      */

      for (int i=0; i< NUM_OF_QUESTIONS; i++)
      {
        quests[i] = new QuestionAnswer(question_list.get(i));
      }


      // Play the quiz and get answers from user.
      // Play until the user says quit.
      do
      {
        int score = 0;
        Scanner input = new Scanner(System.in);
        for (int qindex=0; qindex<NUM_OF_QUESTIONS; qindex++)
        {

          System.out.println("Question" + (qindex+1) + ": " + quests[qindex].question);
          System.out.println("Your options are:");
          for (int oindex=0; oindex<NUM_OF_OPTIONS; oindex++)
          {
              System.out.print("Option" + (oindex+1) + ": " + quests[qindex].options[oindex] + "\t");
          }
          int uanswer = Integer.parseInt(input.nextLine());
          System.out.println("You have entered: " + uanswer);
          quests[qindex].chosen = uanswer;
          //System.out.println("Solution" + j + ": " + quests[index].solution);
        }
        for (int qindex=0; qindex<NUM_OF_QUESTIONS; qindex++)
        {
          if(quests[qindex].chosen == quests[qindex].solution)
          {
            score++;
          }
        }
        System.out.println("Your score is: " + score);
        //System.out.println("Your percent is: " + ((score/NUM_OF_QUESTIONS)*100));
        System.out.print("Do you want to play again? (y/n): ");
        quit = input.next();
    } while (quit.equals("y"));

  }

}
