package app;


import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.formdev.flatlaf.ui.FlatEmptyBorder;

/**
 * PanelBuilder is used to build the different layers of the application.
 * 
 * @author Paul Faller
 *
 */
public abstract class PanelBuilder
{
    private static final String SELECTION_PANEL = "Auswahl-Panel";
    protected static final String PANEL = "Panel";

    private final List<String> categoriesList;

    public PanelBuilder(List<String> categoriesList)
    {
        this.categoriesList = categoriesList;
    }


    protected abstract void buildCategoryPanel(List<String> categoriesList, Panel mainPanel);


    public Panel buildPanel()
    {
        Panel mainPanel = new Panel();

        createContent(categoriesList, mainPanel);

        return mainPanel;
    }


    private void createContent(List<String> buttonsList, Panel mainPanel)
    {
        buildButtonsPanel(buttonsList, mainPanel);
        buildCategoryPanel(buttonsList, mainPanel);
    }


    private void buildButtonsPanel(List<String> categoriesList, Panel mainPanel)
    {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 0, 0, 0));

        for (String buttonName : categoriesList)
        {
            buttonsPanel.add(buildButtons(buttonName, mainPanel));
        }
        mainPanel.add(buttonsPanel, SELECTION_PANEL);
    }


    private JButton buildButtons(String buttonName, Panel mainPanel)
    {
        JButton button = new JButton(buttonName);
        button.setFont(new Font("Verdana", Font.BOLD, 24));
        button.setBorder(new FlatEmptyBorder());
        ButtonColorInjector.injectColor(button);
        button.addActionListener(e -> {
            mainPanel.getCardLayout().show(mainPanel, buttonName + PANEL);
        });
        return button;
    }
}
