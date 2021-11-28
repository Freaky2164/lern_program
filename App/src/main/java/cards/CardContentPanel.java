package cards;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import app.Panel;

/**
 * This panel represents a single side of a card.
 * 
 * @author Paul Faller
 *
 */
public class CardContentPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private final GridBagLayout mainLayout = new GridBagLayout();
    private JPanel buttonsPanel;

    public CardContentPanel(Panel parentPanel, Panel cardsPanel, String panelName, String panelContent, Integer number)
    {
        setLayout(mainLayout);
        setBackground(Color.LIGHT_GRAY);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;

        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.setPreferredSize(new Dimension(600, 350));

        JLabel questionLabel = new JLabel(panelContent, SwingConstants.CENTER);
        questionLabel.setFont(new Font("Verdana", Font.PLAIN, 20));

        JLabel numberLabel = new JLabel("#" + String.valueOf(number), SwingConstants.RIGHT);
        numberLabel.setFont(new Font("Verdana", Font.PLAIN, 20));

        questionPanel.add(questionLabel, BorderLayout.CENTER);
        questionPanel.add(numberLabel, BorderLayout.SOUTH);
        questionPanel.setBorder(new LineBorder(Color.black));

        c.insets = new Insets(20, 0, 0, 0);
        c.gridx = 1;
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buildButtons(cardsPanel, parentPanel, panelName);

        add(questionPanel, c);
        add(buttonsPanel, c);
    }


    private void buildButtons(Panel cardsPanel, Panel parentPanel, String panelName)
    {
        JButton switchButton = new JButton();
        try
        {
            Image img = ImageIO.read(getClass().getResource("refresh_icon.png"));
            switchButton.setIcon(new ImageIcon(img));
            switchButton.setBackground(Color.LIGHT_GRAY);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        switchButton.addActionListener(e -> parentPanel.getCardLayout().show(parentPanel, panelName));

        JButton nextButton = new JButton();
        try
        {
            Image img = ImageIO.read(getClass().getResource("forward_arrow.png"));
            nextButton.setIcon(new ImageIcon(img));
            nextButton.setBackground(Color.LIGHT_GRAY);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        nextButton.addActionListener(e -> cardsPanel.getCardLayout().next(cardsPanel));

        JButton previousButton = new JButton();
        try
        {
            Image img = ImageIO.read(getClass().getResource("backward_arrow.png"));
            previousButton.setIcon(new ImageIcon(img));
            previousButton.setBackground(Color.LIGHT_GRAY);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        previousButton.addActionListener(e -> cardsPanel.getCardLayout().previous(cardsPanel));

        buttonsPanel.add(previousButton);
        buttonsPanel.add(switchButton);
        buttonsPanel.add(nextButton);
    }
}
