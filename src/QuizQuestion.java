public class QuizQuestion {
    private String question;
    private String answer;
    private String choiceA;
    private String choiceB;
    private String choiceC;

    public QuizQuestion(String question, String answer, String choiceA, String choiceB, String choiceC){
        this.question = question;
        this.answer = answer;
        this.choiceA = "A." + choiceA;
        this.choiceB = "B." + choiceB;
        this.choiceC = "C." + choiceC;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }
}
