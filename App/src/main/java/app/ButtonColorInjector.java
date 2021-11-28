package app;


import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

/**
 * This class can be called to inject a button with a specific background color.
 *
 * @author Paul Faller
 *
 */
public class ButtonColorInjector
{
    private static final String CIVILRIGHT_BUTTON = "Zivilrecht";
    private static final String PUBLICRIGHT_BUTTON = "\u00D6ffentliches Recht";
    private static final String CRIMINALRIGHT_BUTTON = "Strafrecht";

    private static final String DEFINITIONS_BUTTON = "Definitionen";
    private static final String SCHEMATA_BUTTON = "Schemata";
    private static final String DISPUTES_BUTTON = "Streitstände";

    public static void injectColor(JButton button)
    {
        switch (button.getText())
        {
            case CIVILRIGHT_BUTTON:
                button.setBackground(new Color(0, 191, 255));
                break;

            case PUBLICRIGHT_BUTTON:
                button.setBackground(new Color(124, 252, 0));
                break;

            case CRIMINALRIGHT_BUTTON:
                button.setBackground(new Color(255, 0, 0));
                break;

            case DEFINITIONS_BUTTON:
                button.setBackground(new Color(0, 102, 204));
                break;

            case SCHEMATA_BUTTON:
                button.setBackground(new Color(102, 204, 51));
                break;

            case DISPUTES_BUTTON:
                button.setBackground(new Color(255, 215, 0));
                break;

            default:
                createRandomColor(button);
                break;
        }
    }


    private static void createRandomColor(JButton button)
    {
        Random random = new Random();
        button.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }
}
