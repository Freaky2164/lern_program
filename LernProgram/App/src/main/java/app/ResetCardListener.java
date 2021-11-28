package app;


import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Listener that resets the shown panel when the user clicks on the reset button.
 * 
 * @author Paul Faller
 *
 */
public class ResetCardListener implements ComponentListener
{
    private final CardLayout cardLayout;

    public ResetCardListener(CardLayout cardLayout)
    {
        this.cardLayout = cardLayout;
    }


    @Override
    public void componentResized(ComponentEvent e)
    {
        // Nothing to do here
    }


    @Override
    public void componentMoved(ComponentEvent e)
    {
        // Nothing to do here
    }


    @Override
    public void componentShown(ComponentEvent e)
    {
        // Nothing to do here
    }


    @Override
    public void componentHidden(ComponentEvent e)
    {
        cardLayout.first((Container)e.getSource());
    }
}
