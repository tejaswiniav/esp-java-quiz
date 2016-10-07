/** class QuestionAnswer
* This class contains all the member variables and methods required by a question.
*/
public class QuestionAnswer
{
  public String question;
  public String[] options;
  public int solution;
  public int chosen;

  //QuestionAnswer(String quest, String[] opt, int sol)
  QuestionAnswer(Triplet<String, String[], Integer> triplet)
  {
    question = triplet.getValue0();
    options = triplet.getValue1();
    solution = triplet.getValue2();
  }

}
