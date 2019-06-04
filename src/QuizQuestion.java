/**
 * @author Ryan Phan
 * @version 1 14.04.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 *  Stores all the components that make a up a question in a quiz.
 * </p>
 */
public class QuizQuestion {
  /**
   * Stores the various components of the quiz question
   */
  private String question, answer, choiceA, choiceB, choiceC;
  
  /**
   * <p>
   * The constructor method initializes the all of the components of the question.
   * </p>
   *
   * @param question The question
   * @param answer   The answer to the question
   * @param choiceA  First choice
   * @param choiceB  Second choice
   * @param choiceC  Third choice
   */
  QuizQuestion(String question, String answer, String choiceA, String choiceB, String choiceC){
    this.question = question;
    this.answer = answer;
    this.choiceA = choiceA;
    this.choiceB = choiceB;
    this.choiceC = choiceC;
  }
  
  /**
   * <p>
   * Getter method returns the question of the QuizQuestion
   * </p>
   *
   * @return The question
   */
  String getQuestion(){
    return question;
  }
  /**
   * <p>
   * Getter method returns the answer of the QuizQuestion
   * </p>
   *
   * @return Question's Answer
   */
  String getAnswer() {
    return answer;
  }
  
  void setAnswer(String a) {
    answer = a;
  }
  /**
   * <p>
   * Getter method returns the first choice of the QuizQuestion
   * </p>
   *
   * @return Choice A
   */
  String getChoiceA() {
    return choiceA;
  }
  
  void setChoiceA(String c) {
    choiceA = c;
  }
  
  /**
   * <p>
   * Getter method returns the second choice of the QuizQuestion
   * </p>
   *
   * @return Choice B
   */
  String getChoiceB() {
    return choiceB;
  }
  
  void setChoiceB(String c) {
    choiceB = c;
  }
  /**
   * <p>
   * Getter method returns the third choice of the QuizQuestion
   * </p>
   *
   * @return Choice C
   */
  String getChoiceC() {
    return choiceC;
  }
  
  void setChoiceC(String c) {
    choiceC = c;
  }
}
