package view;

import javax.swing.*;

public class QuizCreatieView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizCreatieView(){
		createAndShowGUI();
	}
	
	// Create the content pane which displays the buttons and widgets on-screen.
    private JPanel createContentPane()
    {
        JPanel totalGUI = new JPanel();
       // totalGUI.setSize(500, 200);
        totalGUI.setOpaque(true);
        return totalGUI;
    }
	
    private void createAndShowGUI()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Quiz");
        frame.setSize(500, 200);
        // Set the content pane.
        frame.setContentPane(createContentPane());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
