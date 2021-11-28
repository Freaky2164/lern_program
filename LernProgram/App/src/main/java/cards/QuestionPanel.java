package cards;


import app.Panel;


/**
 * Panel used for the question of a card.
 * 
 * @author Paul Faller
 */
public class QuestionPanel extends CardContentPanel
{
    private static final long serialVersionUID = -4248096282404829458L;
    private static final String ANSWER_PANEL = "answerPanel";

    public QuestionPanel(Panel parentPanel, Panel cardsPanel, String panelContent, Integer number)
    {
        super(parentPanel, cardsPanel, ANSWER_PANEL, panelContent, number);
    }
}
