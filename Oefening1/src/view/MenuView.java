package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
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

	public MenuView() {
		super("Menu");
		this.setLocation(500, 400);
		this.setSize(400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) {
		        int result = JOptionPane.showConfirmDialog(
		        		e.getWindow(),
		        		"Bent u zeker dat u wilt afsluiten? Niet opgeslagen gegevens kunnen verloren gaan.",
		        		"Confirmatie voor aflsuiten",
		        		JOptionPane.YES_NO_OPTION);
		        if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
		    }
		});
		
		this.add(createPanel());
		this.setVisible(true);
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
		System.exit(0);
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
