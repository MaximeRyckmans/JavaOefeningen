package view;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JButton;

import model.Opdracht;
import model.Quiz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class QuizWijzigenView extends JFrame {

	/**
	 * @author Davy Pulinx
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnlBackground, pnlLeft, pnlRight, pnlListQuizzen, pnlListOpdrInQuiz, pnlListOpdrachten;
	private JLabel lblLijstVanQuizzen, lblOpdrachtenInQuiz, lblOpdrachtenInSystem;
	private JList<?> listQuizzen, listOpdrachtenInQuiz, listOpdrachten;
	private JButton btnWijzigQuiz, btnVerwijderOpdracht, btnToevoegenOpdracht, btnWijzigingOpslaan;
	
	public QuizWijzigenView() {
		super("Wijzigen van quizzen");
		this.setSize(900,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		pnlBackground = new JPanel();
		pnlBackground.setLayout(new GridBagLayout());
		
		CreateLeftPanel();
		CreateRightPanel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		pnlBackground.add(pnlLeft);
		
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.gridx++;
		gbc.weightx = 0.5;
		pnlBackground.add(pnlRight);
		
		this.add(pnlBackground , BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	private void CreateLeftPanel() {
		lblLijstVanQuizzen = new JLabel("Lijst van quizzen");
		pnlListQuizzen = new JPanel();
		listQuizzen = new JList<Quiz>();
		btnWijzigQuiz = new JButton("Wijzig quiz");
		
		pnlLeft = new JPanel();
		pnlLeft.setPreferredSize(new Dimension(435,857));
		pnlLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlLeft.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlLeft.add(lblLijstVanQuizzen, gbc);
		
		pnlListQuizzen.setPreferredSize(new Dimension(350, 500));
		pnlListQuizzen.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlListQuizzen.add(listQuizzen);
		gbc.gridy = 1;
		pnlLeft.add(pnlListQuizzen, gbc);
		
		gbc.gridy = 2;
		pnlLeft.add(btnWijzigQuiz, gbc);
		
		
	}

	private void CreateRightPanel() {
		lblOpdrachtenInQuiz = new JLabel("Opdrachten in quiz");
		lblOpdrachtenInSystem = new JLabel("Opdrachten in het systeem");
		pnlListOpdrInQuiz = new JPanel();
		listOpdrachtenInQuiz = new JList<Opdracht>();
		pnlListOpdrachten = new JPanel();
		listOpdrachten = new JList<Opdracht>();
		btnToevoegenOpdracht = new JButton("Voeg opdracht toe aan quiz");
		btnVerwijderOpdracht = new JButton(" Verwijder opdracht in quiz ");
		btnWijzigingOpslaan = new JButton("Wijziging opslaan");
		
		pnlRight = new JPanel();
		pnlRight.setPreferredSize(new Dimension(435,857));
		pnlRight.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlRight.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlRight.add(lblOpdrachtenInQuiz, gbc);
		
		pnlListOpdrInQuiz.setPreferredSize(new Dimension(350, 300));
		pnlListOpdrInQuiz.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlListOpdrInQuiz.add(listOpdrachtenInQuiz);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlRight.add(pnlListOpdrInQuiz, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		pnlRight.add(btnVerwijderOpdracht, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		pnlRight.add(btnToevoegenOpdracht, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		pnlRight.add(lblOpdrachtenInSystem, gbc);
		
		pnlListOpdrachten.setPreferredSize(new Dimension(350, 300));
		pnlListOpdrachten.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlListOpdrachten.add(listOpdrachten);
		gbc.gridx = 0;
		gbc.gridy = 5;
		pnlRight.add(pnlListOpdrachten, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		pnlRight.add(btnWijzigingOpslaan, gbc);
	}
}
