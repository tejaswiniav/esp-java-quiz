
import java.util.ArrayList;

/** class QuestionAnswer
* This class contains all the member variables and methods required by a question.
*/
public class QuestionAnswer
{
  private String question;
  private String[] options;
  private Integer solution;
  private Integer userChoice;

  QuestionAnswer()
  {
      question = new String();
      options = new String[4];
  }

  QuestionAnswer(String quest, String[] opt, int sol)
  {
    this.question = quest;
    this.options = opt;
    this.solution = sol;
  }

  public String getQuestion()
  {
    return this.question;
  }

  public String[] getOptions()
  {
    return this.options;
  }

  public Integer getSolution()
  {
    return this.solution;
  }

  public Integer getUserChoice()
  {
    return this.userChoice;
  }

  public void setQuestion(String quest)
  {
    this.question = quest;
  }

  public void setOptions(String[] opt)
  {
    this.options = opt;
  }

  public void setSolution(Integer sol)
  {
    this.solution = sol;
  }

  public void setUserChoice(Integer choice)
  {
    this.userChoice = choice;
  }

  public String toString()
  {
    String formatS = new String();
    for (int i=0; i<this.options.length; i++)
    {
      formatS += ((i+1) + ". " + this.options[i] + "\t");
    }
    return formatS;
  }

}
