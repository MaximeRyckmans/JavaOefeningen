package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JButton;

import model.Quiz;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class QuizWijzigenView extends JFrame {

	/**
	 * @author Davy Pulinx
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	
	
	public QuizWijzigenView() {
		super("Wijzigen van quizzen");
		this.setSize(900,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		this.setVisible(true);
	}
}
