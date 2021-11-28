package cards;


import java.awt.Component;
import java.util.List;

import app.Panel;

/**
 * This {@link PanelBuilder} is used to build all panel that show the different cards from the database.
 * 
 * @author Paul Faller
 *
 */
public class CardsPanelBuilder
{
    private static final String ANSWER_PANEL = "answerPanel";
    private static final String QUESTION_PANEL = "questionPanel";

    private final List<Card> cardsList;

    public CardsPanelBuilder(List<Card> cardsList)
    {
        this.cardsList = cardsList;
    }


    public Component buildPanel()
    {
        Panel cardsPanel = new Panel();
        for (Card card : cardsList)
        {
            Panel cardPanel = new Panel();
            cardPanel.add(new QuestionPanel(cardPanel, cardsPanel, card.getQuestion(), card.getNumber()), QUESTION_PANEL);
            cardPanel.add(new AnswerPanel(cardPanel, cardsPanel, card.getAnswer(), card.getNumber()), ANSWER_PANEL);
            cardsPanel.add(cardPanel);
        }
        return cardsPanel;
    }
}
