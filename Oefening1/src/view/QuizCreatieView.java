package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

import model.Leraar;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class QuizCreatieView extends JFrame {
	private JLabel onderwerpL, klasL, auteurL, categorieL,
			aantalToegevoegdeOpdrL, sorteerOpdrL;
	private JTextField onderwerpText, aantalToegevoegdeOpdr;
	private JComboBox<String> klas, categorie, sorteerOpdr;
	private JComboBox<Leraar> auteur;
	private JButton nieuweQuiz, naarBoven, naarLinks, naarRechts;
	private JPanel upperPanel, lowerPanel;
	private JTable opdrachten, toegevoegdeOpdr;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizCreatieView() {
		JFrame frame = new JFrame("Aanmaken nieuwe Quiz");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout());
		upperPanel = createUpperPanel();
		lowerPanel = createLowerPanel();
		frame.add(upperPanel, BorderLayout.NORTH);
		frame.add(lowerPanel);
		frame.setVisible(true);
	}

	// Create the content pane which displays the buttons and widgets on-screen.
	private JPanel createUpperPanel() {

		JPanel upperPanel = new JPanel();
		upperPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		onderwerpL = new JLabel("Onderwerp:");
		onderwerpText = new JTextField(20);
		klasL = new JLabel("Klas:");
		klas = new JComboBox<String>();
		auteurL = new JLabel("Auteur:");
		auteur = new JComboBox<Leraar>();
		nieuweQuiz = new JButton("Registreer nieuwe quiz");
		upperPanel.add(onderwerpL);
		upperPanel.add(onderwerpText);
		upperPanel.add(klasL);
		upperPanel.add(klas);
		upperPanel.add(auteurL);
		upperPanel.add(auteur);
		upperPanel.add(nieuweQuiz);
		upperPanel.setVisible(true);
		return upperPanel;
	}

	private JPanel createLowerPanel() {
		JPanel lowerPanel = new JPanel();
		lowerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		categorieL = new JLabel("Toon opdrachten van:");
		categorie = new JComboBox<String>();
		aantalToegevoegdeOpdrL = new JLabel("Aantal toegevoegde opdrachten:");
		aantalToegevoegdeOpdr = new JTextField(2);
		sorteerOpdrL = new JLabel("Sorteer opdrachten op:");
		sorteerOpdr = new JComboBox<String>();
		naarBoven = new JButton("^^^^");
		opdrachten = new JTable();
		naarRechts = new JButton(">>>>");
		naarLinks = new JButton("<<<<");
		toegevoegdeOpdr = new JTable();
		lowerPanel.add(categorieL);
		lowerPanel.add(categorie);
		lowerPanel.add(aantalToegevoegdeOpdrL);
		lowerPanel.add(aantalToegevoegdeOpdr);
		lowerPanel.add(sorteerOpdrL);
		lowerPanel.add(sorteerOpdr);
		lowerPanel.add(naarBoven);
		lowerPanel.add(opdrachten);
		lowerPanel.add(naarRechts);
		lowerPanel.add(naarLinks);
		lowerPanel.add(toegevoegdeOpdr);
		return lowerPanel;
		
		
	}

	/**
	 * @return the onderwerpL
	 */
	public JLabel getOnderwerpL() {
		return onderwerpL;
	}

	/**
	 * @param onderwerpL
	 *            the onderwerpL to set
	 */
	public void setOnderwerpL(JLabel onderwerpL) {
		this.onderwerpL = onderwerpL;
	}

	/**
	 * @return the klasL
	 */
	public JLabel getKlasL() {
		return klasL;
	}

	/**
	 * @param klasL
	 *            the klasL to set
	 */
	public void setKlasL(JLabel klasL) {
		this.klasL = klasL;
	}

	/**
	 * @return the auteurL
	 */
	public JLabel getAuteurL() {
		return auteurL;
	}

	/**
	 * @param auteurL
	 *            the auteurL to set
	 */
	public void setAuteurL(JLabel auteurL) {
		this.auteurL = auteurL;
	}

	/**
	 * @return the klas
	 */
	public JComboBox<String> getKlas() {
		return klas;
	}

	/**
	 * @param klas
	 *            the klas to set
	 */
	public void setKlas(JComboBox<String> klas) {
		this.klas = klas;
	}

	/**
	 * @return the auteur
	 */
	public JComboBox<Leraar> getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur
	 *            the auteur to set
	 */
	public void setAuteur(JComboBox<Leraar> auteur) {
		this.auteur = auteur;
	}

	/**
	 * @return the nieuweQuiz
	 */
	public JButton getNieuweQuiz() {
		return nieuweQuiz;
	}

	/**
	 * @param nieuweQuiz
	 *            the nieuweQuiz to set
	 */
	public void setNieuweQuiz(JButton nieuweQuiz) {
		this.nieuweQuiz = nieuweQuiz;
	}

	/**
	 * @return the onderwerpText
	 */
	public JTextField getOnderwerpText() {
		return onderwerpText;
	}

	/**
	 * @param onderwerpText
	 *            the onderwerpText to set
	 */
	public void setOnderwerpText(JTextField onderwerpText) {
		this.onderwerpText = onderwerpText;
	}

	/**
	 * @return the categorieL
	 */
	public JLabel getCategorieL() {
		return categorieL;
	}

	/**
	 * @param categorieL the categorieL to set
	 */
	public void setCategorieL(JLabel categorieL) {
		this.categorieL = categorieL;
	}

	/**
	 * @return the aantalToegevoegdeOpdrL
	 */
	public JLabel getAantalToegevoegdeOpdrL() {
		return aantalToegevoegdeOpdrL;
	}

	/**
	 * @param aantalToegevoegdeOpdrL the aantalToegevoegdeOpdrL to set
	 */
	public void setAantalToegevoegdeOpdrL(JLabel aantalToegevoegdeOpdrL) {
		this.aantalToegevoegdeOpdrL = aantalToegevoegdeOpdrL;
	}

	/**
	 * @return the sorteerOpdrL
	 */
	public JLabel getSorteerOpdrL() {
		return sorteerOpdrL;
	}

	/**
	 * @param sorteerOpdrL the sorteerOpdrL to set
	 */
	public void setSorteerOpdrL(JLabel sorteerOpdrL) {
		this.sorteerOpdrL = sorteerOpdrL;
	}

	/**
	 * @return the aantalToegevoegdeOpdr
	 */
	public JTextField getAantalToegevoegdeOpdr() {
		return aantalToegevoegdeOpdr;
	}

	/**
	 * @param aantalToegevoegdeOpdr the aantalToegevoegdeOpdr to set
	 */
	public void setAantalToegevoegdeOpdr(JTextField aantalToegevoegdeOpdr) {
		this.aantalToegevoegdeOpdr = aantalToegevoegdeOpdr;
	}

	/**
	 * @return the categorie
	 */
	public JComboBox<String> getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(JComboBox<String> categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the sorteerOpdr
	 */
	public JComboBox<String> getSorteerOpdr() {
		return sorteerOpdr;
	}

	/**
	 * @param sorteerOpdr the sorteerOpdr to set
	 */
	public void setSorteerOpdr(JComboBox<String> sorteerOpdr) {
		this.sorteerOpdr = sorteerOpdr;
	}

	/**
	 * @return the naarBoven
	 */
	public JButton getNaarBoven() {
		return naarBoven;
	}

	/**
	 * @param naarBoven the naarBoven to set
	 */
	public void setNaarBoven(JButton naarBoven) {
		this.naarBoven = naarBoven;
	}

	/**
	 * @return the naarLinks
	 */
	public JButton getNaarLinks() {
		return naarLinks;
	}

	/**
	 * @param naarLinks the naarLinks to set
	 */
	public void setNaarLinks(JButton naarLinks) {
		this.naarLinks = naarLinks;
	}

	/**
	 * @return the naarRechts
	 */
	public JButton getNaarRechts() {
		return naarRechts;
	}

	/**
	 * @param naarRechts the naarRechts to set
	 */
	public void setNaarRechts(JButton naarRechts) {
		this.naarRechts = naarRechts;
	}

	/**
	 * @return the upperPanel
	 */
	public JPanel getUpperPanel() {
		return upperPanel;
	}

	/**
	 * @param upperPanel the upperPanel to set
	 */
	public void setUpperPanel(JPanel upperPanel) {
		this.upperPanel = upperPanel;
	}

	/**
	 * @return the opdrachten
	 */
	public JTable getOpdrachten() {
		return opdrachten;
	}

	/**
	 * @param opdrachten the opdrachten to set
	 */
	public void setOpdrachten(JTable opdrachten) {
		this.opdrachten = opdrachten;
	}

	/**
	 * @return the toegevoegdeOpdr
	 */
	public JTable getToegevoegdeOpdr() {
		return toegevoegdeOpdr;
	}

	/**
	 * @param toegevoegdeOpdr the toegevoegdeOpdr to set
	 */
	public void setToegevoegdeOpdr(JTable toegevoegdeOpdr) {
		this.toegevoegdeOpdr = toegevoegdeOpdr;
	}

}
