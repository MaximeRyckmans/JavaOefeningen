package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class QuizDeleteView extends QuizWijzigenView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizDeleteView(){
		this.setTitle("Verwijder quiz");
		this.setSize(500,900);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		this.setPnlBackground(new JPanel());
		
		this.CreateLeftPanel("Verwijder quiz");
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.getPnlBackground().add(this.getPnlLeft());
		
		this.add(getPnlBackground());
		this.setVisible(true);
	}
}
