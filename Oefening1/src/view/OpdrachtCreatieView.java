package view;

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
			maxAntwoordTijdL;
	private JTextField vraagT, antwoordT, antwoordHintT;
	private JComboBox maxAantalPogingenC, maxAntwoordTijdC, categorie,
			opdrachtCategorie;
	private JButton toevoegen;
	String[] aantalPogingen = { "", "1", "2", "3", "4", "5" };
	String[] tijd = { "", "30", "60", "90", "120" };

	public OpdrachtCreatieView() {

		super("Aanmaken nieuwe Opdracht");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(createPanel());
		this.setVisible(true);

	}

	public JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(20, 3));
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
		toevoegen = new JButton("Toevoegen");

		panel.add(categorie);
		panel.add(opdrachtCategorie);
		panel.add(vraagL);
		panel.add(vraagT);
		panel.add(antwoordL);
		panel.add(antwoordT);
		panel.add(maxAantalPogingenL);
		panel.add(maxAantalPogingenC);
		panel.add(antwoordHintL);
		panel.add(antwoordHintT);
		panel.add(maxAntwoordTijdL);
		panel.add(maxAntwoordTijdC);
		panel.add(toevoegen);
		return panel;
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

	public void buttonActionListener(ActionListener al) {
		toevoegen.setActionCommand(toevoegen.getName());
		toevoegen.addActionListener(al);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
