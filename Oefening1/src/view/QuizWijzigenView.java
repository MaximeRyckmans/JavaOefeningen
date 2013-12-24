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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Klas;
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
import java.util.Iterator;
import java.util.List;

/**
 * @author Davy Pulinx
 * @version 1.0
 */

public class QuizWijzigenView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlBackground, pnlRightBackground, pnlRightBot, pnlLeft,
			pnlMiddle, pnlRight, pnlListQuizzen, pnlListOpdrachten;
	private JScrollPane scrlPnlOpdrachtenInQuiz;
	private JLabel lblLijstVanQuizzen, lblOpdrachtenInQuiz,
			lblOpdrachtenInSystem, lblMiddle, lblOnderwerp, lblLeerjaar,
			lblLeraar, lblAantalDeelnames, lblQuizStatus;
	private JTextField txtOnderwerp, txtAantalDeelnames;
	private JComboBox<String> cmbbxLeerjaar, cmbbxLeraar, cmbbxQuizStatus;
	private JList<Quiz> listQuizzen;
	private JList<Opdracht> listOpdrachten;
	private JTable tableOpdrachtenInQuiz;
	private JButton btnWijzigQuiz, btnVerwijderOpdracht, btnToevoegenOpdracht,
			btnWijzigingOpslaan, btnAnnuleerWijziging;
	private boolean trueIndicator = false;
	private final String NOT_SELECTABLE_OPTION = " - Selecteer waarde - ";
	private DefaultTableModel tblModel;
	
	public QuizWijzigenView() {}

	public QuizWijzigenView(String nameButton) {
		super("Wijzigen van quizzen");
		this.setSize(1350, 900);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());

		pnlBackground = new JPanel();
		pnlBackground.setLayout(new GridBagLayout());
		pnlRightBackground = new JPanel();
		pnlRightBackground.setLayout(new GridBagLayout());
		pnlRightBot = new JPanel();

		CreateLeftPanel(nameButton);
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

		this.add(pnlBackground, BorderLayout.NORTH);
		this.setVisible(true);
	}

	protected void CreateMiddlePanel() {
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
		pnlMiddle.setPreferredSize(new Dimension(435, 857));
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

	protected void CreateLeftPanel(String nameButton) {
		lblLijstVanQuizzen = new JLabel("Lijst van quizzen");
		pnlListQuizzen = new JPanel();
		listQuizzen = new JList<Quiz>();
		btnWijzigQuiz = new JButton(nameButton);

		pnlLeft = new JPanel();
		pnlLeft.setPreferredSize(new Dimension(435, 857));
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

	protected void CreateRightPanel() {
		lblOpdrachtenInQuiz = new JLabel("Opdrachten in quiz");
		lblOpdrachtenInSystem = new JLabel("Opdrachten in het systeem");
		scrlPnlOpdrachtenInQuiz = new JScrollPane();
		// pnlListOpdrInQuiz = new JPanel();
		// listOpdrachtenInQuiz = new JList<Opdracht>();
		tableOpdrachtenInQuiz = new JTable();
		pnlListOpdrachten = new JPanel();
		listOpdrachten = new JList<Opdracht>();
		btnToevoegenOpdracht = new JButton("Voeg opdracht toe aan quiz");
		btnVerwijderOpdracht = new JButton(" Verwijder opdracht in quiz ");
		btnWijzigingOpslaan = new JButton("Alle wijzigingen opslaan");
		btnAnnuleerWijziging = new JButton("Annuleer");
		final String[] col = { "Opdracht", "MaximumScore" };

		pnlRight = new JPanel();
		pnlRight.setPreferredSize(new Dimension(435, 857));
		pnlRight.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlRight.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlRight.add(lblOpdrachtenInQuiz, gbc);

		scrlPnlOpdrachtenInQuiz.setPreferredSize(new Dimension(400, 300));
		scrlPnlOpdrachtenInQuiz.setBorder(BorderFactory
				.createLoweredBevelBorder());
		tblModel = new DefaultTableModel(col, 0);
		tableOpdrachtenInQuiz.setModel(tblModel);
		// scrlPnlOpdrachtenInQuiz.add(tableOpdrachtenInQuiz);
		scrlPnlOpdrachtenInQuiz.getViewport().add(tableOpdrachtenInQuiz);
		gbc.gridy = 1;
		gbc.gridx = 0;
		pnlRight.add(scrlPnlOpdrachtenInQuiz, gbc);
		/*
		 * pnlListOpdrInQuiz.setPreferredSize(new Dimension(400, 300));
		 * pnlListOpdrInQuiz
		 * .setBorder(BorderFactory.createLoweredBevelBorder());
		 * pnlListOpdrInQuiz.add(listOpdrachtenInQuiz); gbc.gridx = 0; gbc.gridy
		 * = 1; pnlRight.add(pnlListOpdrInQuiz, gbc);
		 */

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 30, 0);
		pnlRight.add(btnVerwijderOpdracht, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 0, 0);
		pnlRight.add(lblOpdrachtenInSystem, gbc);

		pnlListOpdrachten.setPreferredSize(new Dimension(400, 300));
		pnlListOpdrachten.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlListOpdrachten.add(listOpdrachten);
		gbc.gridx = 0;
		gbc.gridy = 4;
		pnlRight.add(pnlListOpdrachten, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(0, 0, 30, 0);
		pnlRight.add(btnToevoegenOpdracht, gbc);

		pnlRightBot.add(btnWijzigingOpslaan);
		pnlRightBot.add(btnAnnuleerWijziging);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.insets = new Insets(0, 0, 0, 0);
		pnlRight.add(pnlRightBot, gbc);

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

	public void setInitiëleWaarden(List<Quiz> quizzen, List<Opdracht> opdrachten) {
		DefaultListModel<Quiz> model = new DefaultListModel<Quiz>();
		for (Quiz q : quizzen) {
			model.addElement(q);
		}
		listQuizzen.setModel(model);

		DefaultListModel<Opdracht> modelO = new DefaultListModel<Opdracht>();
		for (Opdracht o : opdrachten) {
			modelO.addElement(o);
		}
		listOpdrachten.setModel(modelO);

		DefaultComboBoxModel<String> modelLj = new DefaultComboBoxModel<String>();
		modelLj.addElement(NOT_SELECTABLE_OPTION);
		for (Klas klas : Klas.values()) {
			modelLj.addElement(klas.toString());
		}
		cmbbxLeerjaar.setModel(modelLj);

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

	public void setOpdrachtenInQuiz(Quiz quiz) {
		// DefaultListModel<Opdracht> model = new DefaultListModel<Opdracht>();
		// Clear the data of the tablemodel
		getTblModel().setRowCount(0);

		Integer parse = quiz.getAantalDeelnames();
		txtAantalDeelnames.setText(parse.toString());
		txtOnderwerp.setText(quiz.getOnderwerp());
		cmbbxLeerjaar.setSelectedItem(quiz.getLeerjaar().toString());
		cmbbxLeraar.setSelectedItem(quiz.getLeraar().toString());
		cmbbxQuizStatus.setSelectedItem(quiz.getQuizStatus().toString());

		Object[] objects = new Object[2];
		Iterator<Opdracht> iterator = quiz.getOpdrachten().listIterator();
		// populating the tablemodel
		while (iterator.hasNext()) {
			Opdracht opdr = iterator.next();
			objects[0] = opdr.getVraag();
			objects[1] = opdr.getMaxAantalPunten();

			getTblModel().addRow(objects);

		}
	}

	public void removeOpdrachtInQuiz(Quiz quiz, String vraag) {
		Iterator<Opdracht> iterator = quiz.getOpdrachten().listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getVraag().equals(vraag)) {
				iterator.remove();
			}
		}
	}

	public void confirmationWindow(String Confirmation, String title) {
		int result = JOptionPane.showConfirmDialog(this, Confirmation, title,
				JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			trueIndicator = true;
		} else {
			trueIndicator = false;
		}
	}

	public void closeWindow() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
	}

	public void popUpWindow() {
		// check the pop up!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		String text = "Selecteer een geldige waarde voor ";

		if (cmbbxLeraar.getSelectedItem().equals(NOT_SELECTABLE_OPTION)) {
			JOptionPane.showMessageDialog(this, text + "leraar", text
					+ "leraar", ABORT);
		} else if (cmbbxQuizStatus.getSelectedItem().equals(
				NOT_SELECTABLE_OPTION)) {
			JOptionPane.showMessageDialog(this, text + "quiz status", text
					+ "quiz status", ABORT);
		} else if (cmbbxLeerjaar.getSelectedItem()
				.equals(NOT_SELECTABLE_OPTION)) {
			JOptionPane.showMessageDialog(this, text + "leerjaar", text
					+ "leerjaar", ABORT);
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

	public DefaultTableModel getTblModel() {
		return tblModel;
	}

	public void setTblModel(DefaultTableModel tblModel) {
		this.tblModel = tblModel;
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

	/*
	 * public JPanel getPnlListOpdrInQuiz() { return pnlListOpdrInQuiz; }
	 * 
	 * public void setPnlListOpdrInQuiz(JPanel pnlListOpdrInQuiz) {
	 * this.pnlListOpdrInQuiz = pnlListOpdrInQuiz; }
	 */

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

	public JList<Quiz> getListQuizzen() {
		return listQuizzen;
	}

	public void setListQuizzen(JList<Quiz> listQuizzen) {
		this.listQuizzen = listQuizzen;
	}

	/*
	 * public JList<Opdracht> getListOpdrachtenInQuiz() { return
	 * listOpdrachtenInQuiz; }
	 * 
	 * public void setListOpdrachtenInQuiz(JList<Opdracht> listOpdrachtenInQuiz)
	 * { this.listOpdrachtenInQuiz = listOpdrachtenInQuiz; }
	 */

	public JList<Opdracht> getListOpdrachten() {
		return listOpdrachten;
	}

	public void setListOpdrachten(JList<Opdracht> listOpdrachten) {
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

	public JTable getTableOpdrachtenInQuiz() {
		return tableOpdrachtenInQuiz;
	}

	public void setTableOpdrachtenInQuiz(JTable tableOpdrachtenInQuiz) {
		this.tableOpdrachtenInQuiz = tableOpdrachtenInQuiz;
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
