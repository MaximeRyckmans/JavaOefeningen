package view;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ListModel;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JButton;

import model.Opdracht;
import model.Quiz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Davy Pulinx
 * @version 1.0
 */

public class QuizWijzigenView extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	
	private JPanel pnlBackground, pnlLeft, pnlRight, pnlListQuizzen, pnlListOpdrInQuiz, pnlListOpdrachten;
	private JLabel lblLijstVanQuizzen, lblOpdrachtenInQuiz, lblOpdrachtenInSystem;
	private JList<String> listQuizzen, listOpdrachtenInQuiz, listOpdrachten;
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
		listQuizzen = new JList<String>();
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
		listOpdrachtenInQuiz = new JList<String>();
		pnlListOpdrachten = new JPanel();
		listOpdrachten = new JList<String>();
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
	
	public void buttonActionListener(ActionListener al) {

		btnToevoegenOpdracht.setActionCommand(btnToevoegenOpdracht.getName());
		btnToevoegenOpdracht.addActionListener(al);

		btnVerwijderOpdracht.setActionCommand(btnVerwijderOpdracht.getName());
		btnVerwijderOpdracht.addActionListener(al);

		btnWijzigingOpslaan.setActionCommand(btnWijzigingOpslaan.getName());
		btnWijzigingOpslaan.addActionListener(al);

		btnWijzigQuiz.setActionCommand(btnWijzigQuiz.getName());
		btnWijzigQuiz.addActionListener(al);
	}
	
	public void setInitiëleWaarden(List<Quiz> quizzen, List<Opdracht> opdrachten){
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (Quiz q : quizzen) {
			model.addElement(q.getOnderwerp());
		}
		listQuizzen.setModel(model);
		
		DefaultListModel<String> modelO = new DefaultListModel<String>();
		for (Opdracht o : opdrachten) {
			modelO.addElement(o.getVraag());
		}
		listOpdrachten.setModel(modelO);
	}
	
	public void setOpdrachtenInQuiz(List<Opdracht> opdrachten){
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (Opdracht o : opdrachten) {
			model.addElement(o.getVraag());
		}
		listOpdrachtenInQuiz.setModel(model);
	}

	public JPanel getPnlBackground() {
		return pnlBackground;
	}

	public void setPnlBackground(JPanel pnlBackground) {
		this.pnlBackground = pnlBackground;
	}

	public JPanel getPnlLeft() {
		return pnlLeft;
	}

	public void setPnlLeft(JPanel pnlLeft) {
		this.pnlLeft = pnlLeft;
	}

	public JPanel getPnlRight() {
		return pnlRight;
	}

	public void setPnlRight(JPanel pnlRight) {
		this.pnlRight = pnlRight;
	}

	public JPanel getPnlListQuizzen() {
		return pnlListQuizzen;
	}

	public void setPnlListQuizzen(JPanel pnlListQuizzen) {
		this.pnlListQuizzen = pnlListQuizzen;
	}

	public JPanel getPnlListOpdrInQuiz() {
		return pnlListOpdrInQuiz;
	}

	public void setPnlListOpdrInQuiz(JPanel pnlListOpdrInQuiz) {
		this.pnlListOpdrInQuiz = pnlListOpdrInQuiz;
	}

	public JPanel getPnlListOpdrachten() {
		return pnlListOpdrachten;
	}

	public void setPnlListOpdrachten(JPanel pnlListOpdrachten) {
		this.pnlListOpdrachten = pnlListOpdrachten;
	}

	public JLabel getLblLijstVanQuizzen() {
		return lblLijstVanQuizzen;
	}

	public void setLblLijstVanQuizzen(JLabel lblLijstVanQuizzen) {
		this.lblLijstVanQuizzen = lblLijstVanQuizzen;
	}

	public JLabel getLblOpdrachtenInQuiz() {
		return lblOpdrachtenInQuiz;
	}

	public void setLblOpdrachtenInQuiz(JLabel lblOpdrachtenInQuiz) {
		this.lblOpdrachtenInQuiz = lblOpdrachtenInQuiz;
	}

	public JLabel getLblOpdrachtenInSystem() {
		return lblOpdrachtenInSystem;
	}

	public void setLblOpdrachtenInSystem(JLabel lblOpdrachtenInSystem) {
		this.lblOpdrachtenInSystem = lblOpdrachtenInSystem;
	}

	public JList<String> getListQuizzen() {
		return listQuizzen;
	}

	public void setListQuizzen(JList<String> listQuizzen) {
		this.listQuizzen = listQuizzen;
	}

	public JList<String> getListOpdrachtenInQuiz() {
		return listOpdrachtenInQuiz;
	}

	public void setListOpdrachtenInQuiz(JList<String> listOpdrachtenInQuiz) {
		this.listOpdrachtenInQuiz = listOpdrachtenInQuiz;
	}

	public JList<String> getListOpdrachten() {
		return listOpdrachten;
	}

	public void setListOpdrachten(JList<String> listOpdrachten) {
		this.listOpdrachten = listOpdrachten;
	}

	public JButton getBtnWijzigQuiz() {
		return btnWijzigQuiz;
	}

	public void setBtnWijzigQuiz(JButton btnWijzigQuiz) {
		this.btnWijzigQuiz = btnWijzigQuiz;
	}

	public JButton getBtnVerwijderOpdracht() {
		return btnVerwijderOpdracht;
	}

	public void setBtnVerwijderOpdracht(JButton btnVerwijderOpdracht) {
		this.btnVerwijderOpdracht = btnVerwijderOpdracht;
	}

	public JButton getBtnToevoegenOpdracht() {
		return btnToevoegenOpdracht;
	}

	public void setBtnToevoegenOpdracht(JButton btnToevoegenOpdracht) {
		this.btnToevoegenOpdracht = btnToevoegenOpdracht;
	}

	public JButton getBtnWijzigingOpslaan() {
		return btnWijzigingOpslaan;
	}

	public void setBtnWijzigingOpslaan(JButton btnWijzigingOpslaan) {
		this.btnWijzigingOpslaan = btnWijzigingOpslaan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
