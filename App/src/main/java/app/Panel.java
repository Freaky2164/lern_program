package app;


import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * Panel that is used as a container for differnt panels.
 * 
 * @author Paul Faller
 *
 */
public class Panel extends JPanel
{
    private static final long serialVersionUID = 1L;

    private final CardLayout cardLayout;

    public Panel()
    {
        this.cardLayout = new CardLayout(0, 0);
        setLayout(cardLayout);

        addComponentListener(new ResetCardListener(cardLayout));
    }


    public CardLayout getCardLayout()
    {
        return cardLayout;
    }
}
