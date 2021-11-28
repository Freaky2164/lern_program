package cards;

/**
 * Model for the cards.
 * 
 * @author Paul Faller
 *
 */
public class Card
{
    private String question;
    private String answer;
    private int number;

    public Card(String question, String answer, int number)
    {
        super();
        this.question = question;
        this.answer = answer;
        this.number = number;
    }


    public String getQuestion()
    {
        return question;
    }


    public void setQuestion(String question)
    {
        this.question = question;
    }


    public String getAnswer()
    {
        return answer;
    }


    public void setAnswer(String answer)
    {
        this.answer = answer;
    }


    public int getNumber()
    {
        return number;
    }


    public void setNumber(int number)
    {
        this.number = number;
    }

}
