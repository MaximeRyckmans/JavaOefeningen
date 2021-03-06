package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Categorie;
import model.OpdrachtCategorie;

/**
 * @author Goossens Nicolas
 * @version 1.0
 */

/**
 * @author java
 * 
 */
public class OpdrachtCreatieView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4522864890874195880L;
	private JLabel vraagL, antwoordL, maxAantalPogingenL, antwoordHintL,
			maxAntwoordTijdL, alleKeuzesL, trefwoordenL, minAantalJuisteTrefwoordenL;
	private JTextField vraagT, antwoordT, antwoordHintT, alleKeuzesT, trefwoordenT;
	private JComboBox maxAantalPogingenC, maxAntwoordTijdC, categorie,
			opdrachtCategorie, minAantalJuisteTrefwoordenC;
	private JButton toevoegen = new JButton("Toevoegen");
	private JPanel defaultPanel, meerKeuzePanel, opsommingPanel, reproductiePanel;
	String[] aantalPogingen = { "", "1", "2", "3", "4", "5" };
	String[] tijd = { "", "30", "60", "90", "120" };
	String[] minAantalJuisteTrefwoorden = { "", "1", "2", "3", "4", "5" };

	public OpdrachtCreatieView() {

		super("Aanmaken nieuwe Opdracht");
		JPanel panel = new JPanel();
		this.setSize(600,400);
		this.setLocation(500, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//createDefaultPanel();
		/*createOpsommingPanel();
		createReproductiePanel();
		createMeerkeuzePanel();*/
		
		panel.setLayout(new GridLayout(2,2));
		panel.add(createMeerkeuzePanel());
		panel.add(createReproductiePanel());
		panel.add(createOpsommingPanel());
		panel.add(toevoegenButton());
		this.add(createDefaultPanel());
		this.add(panel, BorderLayout.SOUTH);
		/*this.add(defaultPanel, BorderLayout.NORTH);
		this.add(meerKeuzePanel, BorderLayout.SOUTH);
		this.add(reproductiePanel, BorderLayout.SOUTH);
		this.add(opsommingPanel, BorderLayout.SOUTH);*/
		/*opsommingPanel.setVisible(false);
		meerKeuzePanel.setVisible(true);
		reproductiePanel.setVisible(false);*/
		this.setVisible(true);

	}

	public JPanel createDefaultPanel() {
		defaultPanel = new JPanel();
		defaultPanel.setLayout(new GridLayout(6, 2));
		categorie = new JComboBox(Categorie.values());
		opdrachtCategorie = new JComboBox(OpdrachtCategorie.values());
		vraagL = new JLabel("Vraag :");
		vraagT = new JTextField(20);
		antwoordL = new JLabel("Antwoord :");
		antwoordT = new JTextField(20);
		maxAantalPogingenL = new JLabel("Maximum aantal pogingen :");
		maxAantalPogingenC = new JComboBox(aantalPogingen);
		antwoordHintL = new JLabel("Hint :");
		antwoordHintT = new JTextField(20);
		maxAntwoordTijdL = new JLabel("Maximum tijd in seconden :");
		maxAntwoordTijdC = new JComboBox(tijd);

		defaultPanel.add(categorie);
		defaultPanel.add(opdrachtCategorie);
		defaultPanel.add(vraagL);
		defaultPanel.add(vraagT);
		defaultPanel.add(antwoordL);
		defaultPanel.add(antwoordT);
		defaultPanel.add(maxAantalPogingenL);
		defaultPanel.add(maxAantalPogingenC);
		defaultPanel.add(antwoordHintL);
		defaultPanel.add(antwoordHintT);
		defaultPanel.add(maxAntwoordTijdL);
		defaultPanel.add(maxAntwoordTijdC);
		defaultPanel.setVisible(true);
		return defaultPanel;
	}


	public JPanel createOpsommingPanel() {
		opsommingPanel = new JPanel();
		opsommingPanel.setLayout(new GridLayout(2, 1));  
		opsommingPanel.setVisible(false);
		return opsommingPanel;
	}
	
	public JPanel createMeerkeuzePanel() {
		meerKeuzePanel = new JPanel();
		meerKeuzePanel.setLayout(new GridLayout(3, 2));
		alleKeuzesL = new JLabel("Keuzes :");
		alleKeuzesT = new JTextField(20);
		meerKeuzePanel.add(alleKeuzesL);
		meerKeuzePanel.add(alleKeuzesT);
		meerKeuzePanel.setVisible(true);
		return meerKeuzePanel;
	}
	
	public JPanel createReproductiePanel() {
		reproductiePanel = new JPanel();
		reproductiePanel.setLayout(new GridLayout(5, 2));
		trefwoordenL = new JLabel("Trefwoorden :");
		trefwoordenT = new JTextField(20);
		minAantalJuisteTrefwoordenL = new JLabel("Minimum aantal trefwoorden :");
		minAantalJuisteTrefwoordenC = new JComboBox(minAantalJuisteTrefwoorden);
		reproductiePanel.add(trefwoordenL);
		reproductiePanel.add(trefwoordenT);
		reproductiePanel.add(minAantalJuisteTrefwoordenL);
		reproductiePanel.add(minAantalJuisteTrefwoordenC);
		reproductiePanel.setVisible(false);
		return reproductiePanel;
	}
	
	public JPanel toevoegenButton() {
		JPanel panel = new JPanel();
		panel.add(toevoegen);
		return panel;
	}
	
	public JLabel getAlleKeuzesL() {
		return alleKeuzesL;
	}

	public void setAlleKeuzesL(JLabel alleKeuzesL) {
		this.alleKeuzesL = alleKeuzesL;
	}

	public JTextField getAlleKeuzesT() {
		return alleKeuzesT;
	}

	public void setAlleKeuzesT(JTextField alleKeuzesT) {
		this.alleKeuzesT = alleKeuzesT;
	}

	public JPanel getDefaultPanel() {
		return defaultPanel;
	}

	public void setDefaultPanel(JPanel defaultPanel) {
		this.defaultPanel = defaultPanel;
	}

	public JPanel getMeerKeuzePanel() {
		return meerKeuzePanel;
	}

	public void setMeerKeuzePanel(JPanel meerKeuzePanel) {
		this.meerKeuzePanel = meerKeuzePanel;
	}

	public JPanel getOpsommingPanel() {
		return opsommingPanel;
	}

	public void setOpsommingPanel(JPanel opsommingPanel) {
		this.opsommingPanel = opsommingPanel;
	}

	public JPanel getReproductiePanel() {
		return reproductiePanel;
	}

	public void setReproductiePanel(JPanel reproductiePanel) {
		this.reproductiePanel = reproductiePanel;
	}

	public JLabel getVraagL() {
		return vraagL;
	}

	public void setVraagL(JLabel vraagL) {
		this.vraagL = vraagL;
	}

	public JLabel getAntwoordL() {
		return antwoordL;
	}

	public void setAntwoordL(JLabel antwoordL) {
		this.antwoordL = antwoordL;
	}

	public JLabel getMaxAantalPogingenL() {
		return maxAantalPogingenL;
	}

	public void setMaxAantalPogingenL(JLabel maxAantalPogingenL) {
		this.maxAantalPogingenL = maxAantalPogingenL;
	}

	public JLabel getAntwoordHintL() {
		return antwoordHintL;
	}

	public void setAntwoordHintL(JLabel antwoordHintL) {
		this.antwoordHintL = antwoordHintL;
	}

	public JLabel getMaxAntwoordTijdL() {
		return maxAntwoordTijdL;
	}

	public void setMaxAntwoordTijdL(JLabel maxAntwoordTijdL) {
		this.maxAntwoordTijdL = maxAntwoordTijdL;
	}

	public JTextField getVraagT() {
		return vraagT;
	}

	public void setVraagT(JTextField vraagT) {
		this.vraagT = vraagT;
	}

	public JTextField getAntwoordT() {
		return antwoordT;
	}

	public void setAntwoordT(JTextField antwoordT) {
		this.antwoordT = antwoordT;
	}

	public JTextField getAntwoordHintT() {
		return antwoordHintT;
	}

	public void setAntwoordHintT(JTextField antwoordHintT) {
		this.antwoordHintT = antwoordHintT;
	}

	public JComboBox getMaxAntwoordTijdC() {
		return maxAntwoordTijdC;
	}

	public void setMaxAntwoordTijdT(JComboBox maxAntwoordTijdC) {
		this.maxAntwoordTijdC = maxAntwoordTijdC;
	}

	public JComboBox getMaxAantalPogingenC() {
		return maxAantalPogingenC;
	}

	public void setMaxAantalPogingenC(JComboBox maxAantalPogingenC) {
		this.maxAantalPogingenC = maxAantalPogingenC;
	}

	public JComboBox getCategorie() {
		return categorie;
	}

	public void setCategorie(JComboBox categorie) {
		this.categorie = categorie;
	}

	public String[] getAantalPogingen() {
		return aantalPogingen;
	}

	public void setAantalPogingen(String[] aantalPogingen) {
		this.aantalPogingen = aantalPogingen;
	}

	public String[] getTijd() {
		return tijd;
	}

	public void setTijd(String[] tijd) {
		this.tijd = tijd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setMaxAntwoordTijdC(JComboBox maxAntwoordTijdC) {
		this.maxAntwoordTijdC = maxAntwoordTijdC;
	}

	public JComboBox getOpdrachtCategorie() {
		return opdrachtCategorie;
	}

	public void setOpdrachtCategorie(JComboBox opdrachtCategorie) {
		this.opdrachtCategorie = opdrachtCategorie;
	}

	public JButton getToevoegen() {
		return toevoegen;
	}

	public void setToevoegen(JButton toevoegen) {
		this.toevoegen = toevoegen;
	}
	
	public JLabel getTrefwoordenL() {
		return trefwoordenL;
	}

	public void setTrefwoordenL(JLabel trefwoordenL) {
		this.trefwoordenL = trefwoordenL;
	}

	public JLabel getMinAantalJuisteTrefwoordenL() {
		return minAantalJuisteTrefwoordenL;
	}

	public void setMinAantalJuisteTrefwoordenL(JLabel minAantalJuisteTrefwoordenL) {
		this.minAantalJuisteTrefwoordenL = minAantalJuisteTrefwoordenL;
	}

	public JTextField getTrefwoordenT() {
		return trefwoordenT;
	}

	public void setTrefwoordenT(JTextField trefwoordenT) {
		this.trefwoordenT = trefwoordenT;
	}

	public JComboBox getMinAantalJuisteTrefwoordenC() {
		return minAantalJuisteTrefwoordenC;
	}

	public void setMinAantalJuisteTrefwoordenC(JComboBox minAantalJuisteTrefwoordenC) {
		this.minAantalJuisteTrefwoordenC = minAantalJuisteTrefwoordenC;
	}

	public String[] getMinAantalJuisteTrefwoorden() {
		return minAantalJuisteTrefwoorden;
	}

	public void setMinAantalJuisteTrefwoorden(String[] minAantalJuisteTrefwoorden) {
		this.minAantalJuisteTrefwoorden = minAantalJuisteTrefwoorden;
	}

	public void buttonActionListener(ActionListener al) {
		toevoegen.setActionCommand(toevoegen.getName());
		toevoegen.addActionListener(al);
		
		categorie.setActionCommand(categorie.getSelectedItem().toString());
		categorie.addActionListener(al);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
