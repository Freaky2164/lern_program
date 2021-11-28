package app;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.ui.FlatEmptyBorder;

import fields.FieldsPanelBuilder;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

/**
 * Application starting the programm
 * 
 * @author Paul Faller
 *
 */
public class LearnProgram
{
    private static final String SELECTION_PANEL = "Auswahl-Panel";
    private JFrame frame;
    private Panel startPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                    LearnProgram window = new LearnProgram();
                    window.frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the application.
     */
    public LearnProgram()
    {
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame();
        frame.setTitle("Lern Programm");
        frame.setBounds(0, 0, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        createResetButton();
        createCategories();
    }


    private void createCategories()
    {
        FieldsPanelBuilder fieldsPanelBuilder = new FieldsPanelBuilder(DBClient.getFields());
        startPanel = fieldsPanelBuilder.buildPanel();
        frame.getContentPane().add(startPanel, BorderLayout.CENTER);
    }


    private void createResetButton()
    {
        JButton resetButton = new JButton("Back to Start");
        resetButton.setFont(new Font("Verdana", Font.BOLD, 16));
        resetButton.setPreferredSize(new Dimension(900, 40));
        resetButton.setBorder(new FlatEmptyBorder());
        resetButton.setBackground(new Color(150, 150, 150));
        resetButton.addActionListener(e -> jumpToStart());
        frame.getContentPane().add(resetButton, BorderLayout.NORTH);
    }


    private void jumpToStart()
    {
        startPanel.getCardLayout().show(startPanel, SELECTION_PANEL);
    }
}
