package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Goossens Nicolas
 * @version 1.0
 */

public class MenuView extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4793454034322997018L;
	private JButton quiz, opdracht, sluit;
	private JFrame frame;

	public MenuView() {
		frame = new JFrame("Menu");
		frame.setLocation(500, 400);
		frame.setSize(400, 100);
		
		frame.add(createPanel());
		frame.setVisible(true);
	}
	
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setLayout(new GridLayout(3,0));
		quiz = new JButton("Lijst van Quizzen");
		opdracht = new JButton("Lijst van Opdrachten");
		sluit = new JButton("Sluiten");
		
		panel.add(quiz);
		panel.add(opdracht);
		panel.add(sluit);
		return panel;
	}
	
	public void buttonActionListener(ActionListener al) {
		
		quiz.setActionCommand(quiz.getName());
		quiz.addActionListener(al);
		
		opdracht.setActionCommand(opdracht.getName());
		opdracht.addActionListener(al);
		
		sluit.setActionCommand(sluit.getName());
		sluit.addActionListener(al);
	}
	
	public void close() {
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public JButton getQuiz() {
		return quiz;
	}

	public void setQuiz(JButton quiz) {
		this.quiz = quiz;
	}

	public JButton getOpdracht() {
		return opdracht;
	}

	public void setOpdracht(JButton opdracht) {
		this.opdracht = opdracht;
	}

	public JButton getSluit() {
		return sluit;
	}

	public void setSluit(JButton sluit) {
		this.sluit = sluit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
