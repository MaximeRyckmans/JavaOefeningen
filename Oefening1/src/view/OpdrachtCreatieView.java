package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Categorie;

/**
 * @author Goossens Nicolas
 * @version 1.0
 */

public class OpdrachtCreatieView extends JFrame implements ActionListener {
	
	private JLabel vraagL, antwoordL, maxAantalPogingenL, antwoordHintL, maxAntwoordTijdL;
	private JTextField vraagT, antwoordT, antwoordHintT;
	private JComboBox maxAantalPogingenC, maxAntwoordTijdC;
	String[] aantalPogingen = { "", "1", "2", "3", "4", "5" };
	String[] tijd = { "" ,"30", "60", "90", "120"};
	
	public OpdrachtCreatieView(){
		
		JFrame frame = new JFrame("Aanmaken nieuwe Opdracht");
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		frame.add(createPanel());	
	}
	
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(11, 1));
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
		
		panel.add(new JComboBox(Categorie.values()));
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

	public JComboBox getMaxAantalpogingenC() {
		return maxAantalPogingenC;
	}

	public void setMaxAantalpogingenC(JComboBox maxAantalPogingenC) {
		this.maxAantalPogingenC = maxAantalPogingenC;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
