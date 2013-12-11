package view;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JButton;

import model.Leraar;
import model.Opdracht;
import model.Quiz;
import model.QuizStatus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * @author Davy Pulinx
 * @version 1.0
 */

public class QuizWijzigenView extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	
	private JPanel pnlBackground, pnlLeft, pnlMiddle, pnlRight, pnlListQuizzen, pnlListOpdrInQuiz, pnlListOpdrachten;
	private JLabel lblLijstVanQuizzen, lblOpdrachtenInQuiz, lblOpdrachtenInSystem, lblMiddle, 
	lblOnderwerp, lblLeerjaar, lblLeraar, lblAantalDeelnames, lblQuizStatus;
	private JTextField txtOnderwerp, txtAantalDeelnames;
	private JComboBox<String> cmbbxLeerjaar, cmbbxLeraar, cmbbxQuizStatus;
	private JList<String> listQuizzen, listOpdrachtenInQuiz, listOpdrachten;
	private JButton btnWijzigQuiz, btnVerwijderOpdracht, btnToevoegenOpdracht, btnWijzigingOpslaan, btnAnnuleerWijziging;
	private boolean trueIndicator = false;
	private final String NOT_SELECTABLE_OPTION = " - Selecteer waarde - ";

	public QuizWijzigenView() {
		super("Wijzigen van quizzen");
		this.setSize(1350,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		pnlBackground = new JPanel();
		pnlBackground.setLayout(new GridBagLayout());
		
		CreateLeftPanel();
		CreateMiddlePanel();
		CreateRightPanel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.3;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		pnlBackground.add(pnlLeft);
		
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.gridx++;
		gbc.weightx = 0.3;
		pnlBackground.add(pnlMiddle);
		
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.gridx++;
		gbc.weightx = 0.3;
		pnlBackground.add(pnlRight);
		
		this.add(pnlBackground , BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	private void CreateMiddlePanel() {
		lblMiddle = new JLabel("Quizgegevens");
		lblOnderwerp = new JLabel("Onderwerp:");
		txtOnderwerp = new JTextField(20);
		lblLeerjaar = new JLabel("Leerjaar:");
		cmbbxLeerjaar = new JComboBox<String>();
		lblLeraar = new JLabel("Leraar:");
		cmbbxLeraar = new JComboBox<String>();
		lblAantalDeelnames = new JLabel("Aantal deelnames:");
		txtAantalDeelnames = new JTextField(3);
		lblQuizStatus = new JLabel("Quiz status:");
		cmbbxQuizStatus = new JComboBox<String>();
		
		pnlMiddle = new JPanel();
		pnlMiddle.setPreferredSize(new Dimension(435,857));
		pnlMiddle.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlMiddle.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0, 0, 30, 0);
		gbc.anchor = GridBagConstraints.WEST;
		pnlMiddle.add(lblMiddle, gbc);
		gbc.insets = new Insets(0, 10, 20, 0);
		gbc.gridy++;
		pnlMiddle.add(lblOnderwerp, gbc);
		gbc.gridx++;
		pnlMiddle.add(txtOnderwerp, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		pnlMiddle.add(lblLeerjaar, gbc);
		gbc.gridx++;
		pnlMiddle.add(cmbbxLeerjaar, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		pnlMiddle.add(lblLeraar, gbc);
		gbc.gridx++;
		pnlMiddle.add(cmbbxLeraar, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		pnlMiddle.add(lblAantalDeelnames, gbc);
		gbc.gridx++;
		pnlMiddle.add(txtAantalDeelnames, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		pnlMiddle.add(lblQuizStatus, gbc);
		gbc.gridx++;
		pnlMiddle.add(cmbbxQuizStatus, gbc);
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
		btnWijzigingOpslaan = new JButton("Alle wijzigingen opslaan");
		btnAnnuleerWijziging = new JButton("Annuleer");
		
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
		gbc.insets = new Insets(0, 0, 30, 0);
		pnlRight.add(btnVerwijderOpdracht, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 0, 0);
		pnlRight.add(lblOpdrachtenInSystem, gbc);
		
		pnlListOpdrachten.setPreferredSize(new Dimension(350, 300));
		pnlListOpdrachten.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlListOpdrachten.add(listOpdrachten);
		gbc.gridx = 0;
		gbc.gridy = 4;
		pnlRight.add(pnlListOpdrachten, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(0, 0, 30, 0);
		pnlRight.add(btnToevoegenOpdracht, gbc);
		
		JPanel btns = new JPanel();
		btns.add(btnWijzigingOpslaan);
		btns.add(btnAnnuleerWijziging);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.insets = new Insets(0, 0, 0, 0);
		pnlRight.add(btns, gbc);
		
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
		
		btnAnnuleerWijziging.setActionCommand(btnAnnuleerWijziging.getName());
		btnAnnuleerWijziging.addActionListener(al);
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
		
		DefaultComboBoxModel<String> modelL = new DefaultComboBoxModel<String>();
		modelL.addElement(NOT_SELECTABLE_OPTION);
		for (Leraar leraar : Leraar.values()) {
			modelL.addElement(leraar.toString());
		}
		cmbbxLeraar.setModel(modelL);
		
		DefaultComboBoxModel<String> modelS = new DefaultComboBoxModel<String>();
		modelS.addElement(NOT_SELECTABLE_OPTION);
		for (QuizStatus quizStatus : QuizStatus.values()) {
			modelS.addElement(quizStatus.toString());
		}
		cmbbxQuizStatus.setModel(modelS);
	}
	
	public void setOpdrachtenInQuiz(Quiz quiz){
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (Opdracht o : quiz.getOpdrachten()) {
			Integer parse = quiz.getAantalDeelnames();
			txtAantalDeelnames.setText(parse.toString());
			txtOnderwerp.setText(quiz.getOnderwerp());
			cmbbxLeraar.setSelectedItem(quiz.getLeraar().toString());
			cmbbxQuizStatus.setSelectedItem(quiz.getQuizStatus().toString());
			model.addElement(o.getVraag());
		}
		listOpdrachtenInQuiz.setModel(model);
	}
	
	public void windowClosing(String Confirmation, String title){
        int result = JOptionPane.showConfirmDialog(
            this,
            Confirmation,
            title,
            JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION){
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            trueIndicator = true;
        } else {
			trueIndicator = false;
		}
    }
	
	public void popUpWindow(){
		// check the pop up!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		String text = "Selecteer een geldige waarde voor ";
		
		if (cmbbxLeraar.getSelectedItem().equals(NOT_SELECTABLE_OPTION)) {
			JOptionPane.showMessageDialog(this, text + "leraar", text + "leraar", ABORT);
		}else if (cmbbxQuizStatus.getSelectedItem().equals(NOT_SELECTABLE_OPTION)) {
			JOptionPane.showMessageDialog(this, text + "quiz status", text + "quiz status", ABORT);
		}else if (cmbbxLeerjaar.getSelectedItem().equals(NOT_SELECTABLE_OPTION)) {
			JOptionPane.showMessageDialog(this, text + "leerjaar", text + "leerjaar", ABORT);
		}
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

	public JPanel getPnlMiddle() {
		return pnlMiddle;
	}

	public void setPnlMiddle(JPanel pnlMiddle) {
		this.pnlMiddle = pnlMiddle;
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

	public boolean isTrueIndicator() {
		return trueIndicator;
	}

	public void setTrueIndicator(boolean trueIndicator) {
		this.trueIndicator = trueIndicator;
	}

	public JLabel getLblMiddle() {
		return lblMiddle;
	}

	public void setLblMiddle(JLabel lblMiddle) {
		this.lblMiddle = lblMiddle;
	}

	public JLabel getLblOnderwerp() {
		return lblOnderwerp;
	}

	public void setLblOnderwerp(JLabel lblOnderwerp) {
		this.lblOnderwerp = lblOnderwerp;
	}

	public JLabel getLblLeerjaar() {
		return lblLeerjaar;
	}

	public void setLblLeerjaar(JLabel lblLeerjaar) {
		this.lblLeerjaar = lblLeerjaar;
	}

	public JLabel getLblLeraar() {
		return lblLeraar;
	}

	public void setLblLeraar(JLabel lblLeraar) {
		this.lblLeraar = lblLeraar;
	}

	public JLabel getLblAantalDeelnames() {
		return lblAantalDeelnames;
	}

	public void setLblAantalDeelnames(JLabel lblAantalDeelnames) {
		this.lblAantalDeelnames = lblAantalDeelnames;
	}

	public JLabel getLblQuizStatus() {
		return lblQuizStatus;
	}

	public void setLblQuizStatus(JLabel lblQuizStatus) {
		this.lblQuizStatus = lblQuizStatus;
	}

	public JTextField getTxtOnderwerp() {
		return txtOnderwerp;
	}

	public void setTxtOnderwerp(JTextField txtOnderwerp) {
		this.txtOnderwerp = txtOnderwerp;
	}

	public JTextField getTxtAantalDeelnames() {
		return txtAantalDeelnames;
	}

	public void setTxtAantalDeelnames(JTextField txtAantalDeelnames) {
		this.txtAantalDeelnames = txtAantalDeelnames;
	}

	public JComboBox<String> getCmbbxLeerjaar() {
		return cmbbxLeerjaar;
	}

	public void setCmbbxLeerjaar(JComboBox<String> cmbbxLeerjaar) {
		this.cmbbxLeerjaar = cmbbxLeerjaar;
	}

	public JComboBox<String> getCmbbxLeraar() {
		return cmbbxLeraar;
	}

	public void setCmbbxLeraar(JComboBox<String> cmbbxLeraar) {
		this.cmbbxLeraar = cmbbxLeraar;
	}

	public JComboBox<String> getCmbbxQuizStatus() {
		return cmbbxQuizStatus;
	}

	public void setCmbbxQuizStatus(JComboBox<String> cmbbxQuizStatus) {
		this.cmbbxQuizStatus = cmbbxQuizStatus;
	}

	public JButton getBtnAnnuleerWijziging() {
		return btnAnnuleerWijziging;
	}

	public void setBtnAnnuleerWijziging(JButton btnAnnuleerWijziging) {
		this.btnAnnuleerWijziging = btnAnnuleerWijziging;
	}

	public String getNotSelectableOption() {
		return NOT_SELECTABLE_OPTION;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
