package cards;


import app.Panel;

/**
 * Panel used for the answer of a card.
 * 
 * @author Paul Faller
 *
 */
public class AnswerPanel extends CardContentPanel
{
    private static final long serialVersionUID = -4248096282404829458L;
    private static final String QUESTION_PANEL = "questionPanel";

    public AnswerPanel(Panel parentPanel, Panel cardsPanel, String panelContent, Integer number)
    {
        super(parentPanel, cardsPanel, QUESTION_PANEL, panelContent, number);
    }
}
