/**
 * A class for a Question on a quiz or test. There is nothing to do for this class.
 */
class Question
{
    //instance variables
    private String text;
    private String answer;
    /**
     A default constructor method that initializes text and answer
     */
    public Question()
    {
        text = "1 + 1 = " ;
        answer = "2" ;
    }
    /**
     A constructor method to initialize text to parameter questionText, set answer to empty String
     @param questionText the text of this question
     */
    public Question(String questionText)
    {
        text = questionText;
        answer = "";
    }
    /**
     Sets the answer for this question.
     @param correctResponse the answer
     */
    public void setAnswer(String correctResponse)
    {
        answer = correctResponse;
    }
    /**
     Gets the answer for this question.
     @return the correct answer
     */
    public String getAnswer()
    {
        return answer ;
    }
    /**
     Checks a given response for correctness.
     @param response the response to check
     @return true if the response was correct, false otherwise
     */
    public boolean checkAnswer(String response)
    {
        return response.equals(answer);
    }
    /**
     Sets the question text
     @param questionText the text of this question
     */
    public void setQuestion(String questionText)
    {
        text = questionText;
    }
    /**
     Displays this question.
     */
    public void display()
    {
        System.out.println(text);
    }
}
