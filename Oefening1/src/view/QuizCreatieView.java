package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Leraar;
import model.Opdracht;
import model.OpdrachtCategorie;
import model.QuizStatus;

/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 * 
 */
public class QuizCreatieView extends JFrame implements ActionListener {
	private JLabel onderwerpL, klasL, auteurL, categorieL,
			aantalToegevoegdeOpdrL, sorteerOpdrL, aantalToegevoegdeOpdr;
	
	private JTextField onderwerpText;
	
	private JComboBox<String> klas, sorteerOpdr;
	private JComboBox<OpdrachtCategorie> categorie;
	private JComboBox<QuizStatus> quizStatus;
	private JComboBox<Leraar> auteur;
	
	private JButton nieuweQuiz, naarBoven, naarLinks, naarRechts;
	
	private JPanel upperPanel, lowerPanel;
	
	private JList<Opdracht> opdrachten;
	
	private JTable geselecteerdeOpdrachten;
	
	JScrollPane pane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizCreatieView() {
		super("Aanmaken nieuwe Quiz");
		this.setSize(900,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createUpperPanel();
		createLowerPanel();
		
		this.add(upperPanel, BorderLayout.NORTH);
		this.add(lowerPanel);
		this.setVisible(true);
	}
	
	// Create the content pane which displays the buttons and widgets on-screen.
	private void createUpperPanel() {

		upperPanel = new JPanel();
		upperPanel.setBorder(new EmptyBorder(10, 10, 50, 10));
		upperPanel.setSize(400, 400);
		
		onderwerpL = new JLabel();
		onderwerpText = new JTextField(20);
		klasL = new JLabel();
		klas = new JComboBox<String>();
		auteurL = new JLabel();
		auteur = new JComboBox<Leraar>();
		auteur.setModel(new DefaultComboBoxModel<>(Leraar.values()));
		quizStatus = new JComboBox<QuizStatus>();
		auteur = new JComboBox<Leraar>();
		nieuweQuiz = new JButton();
		
		upperPanel.add(onderwerpL);
		upperPanel.add(onderwerpText);
		upperPanel.add(klasL);
		upperPanel.add(klas);
		upperPanel.add(auteurL);
		upperPanel.add(auteur);
		upperPanel.add(quizStatus);
		upperPanel.add(nieuweQuiz);
		upperPanel.setVisible(true);
		
	}

	private void createLowerPanel() {
		lowerPanel = new JPanel();
		lowerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		lowerPanel.setSize(450, 450);
		
		categorieL = new JLabel();
		categorie = new JComboBox<OpdrachtCategorie>();
		aantalToegevoegdeOpdrL = new JLabel();
		aantalToegevoegdeOpdr = new JLabel();
		sorteerOpdrL = new JLabel();
		sorteerOpdr = new JComboBox<String>();
		
		naarBoven = new JButton();
	
		opdrachten = new JList<Opdracht>();
		
		naarRechts = new JButton();
		naarLinks = new JButton();

		geselecteerdeOpdrachten = new JTable();
		pane = new JScrollPane(geselecteerdeOpdrachten);
		
		lowerPanel.add(categorieL);
		lowerPanel.add(categorie);
		lowerPanel.add(aantalToegevoegdeOpdrL);
		lowerPanel.add(aantalToegevoegdeOpdr);
		lowerPanel.add(sorteerOpdrL);
		lowerPanel.add(sorteerOpdr);
		lowerPanel.add(opdrachten);
		lowerPanel.add(opdrachten);	
		lowerPanel.add(naarRechts);
		lowerPanel.add(naarLinks);
		lowerPanel.add(naarBoven);
		lowerPanel.add(pane);

	}
		
	public void buttonActionListener(ActionListener al) {

		nieuweQuiz.setActionCommand(nieuweQuiz.getName());
		nieuweQuiz.addActionListener(al);

		naarBoven.setActionCommand(naarBoven.getName());
		naarBoven.addActionListener(al);

		naarLinks.setActionCommand(naarLinks.getName());
		naarLinks.addActionListener(al);

		naarRechts.setActionCommand(naarRechts.getName());
		naarRechts.addActionListener(al);
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
	 * @param categorieL
	 *            the categorieL to set
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
	 * @param aantalToegevoegdeOpdrL
	 *            the aantalToegevoegdeOpdrL to set
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
	 * @param sorteerOpdrL
	 *            the sorteerOpdrL to set
	 */
	public void setSorteerOpdrL(JLabel sorteerOpdrL) {
		this.sorteerOpdrL = sorteerOpdrL;
	}

	/**
	 * @return the aantalToegevoegdeOpdr
	 */
	public JLabel getAantalToegevoegdeOpdr() {
		return aantalToegevoegdeOpdr;
	}

	/**
	 * @param aantalToegevoegdeOpdr
	 *            the aantalToegevoegdeOpdr to set
	 */
	public void setAantalToegevoegdeOpdr(JLabel aantalToegevoegdeOpdr) {
		this.aantalToegevoegdeOpdr = aantalToegevoegdeOpdr;
	}

	/**
	 * @return the categorie
	 */
	public JComboBox<OpdrachtCategorie> getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(JComboBox<OpdrachtCategorie> categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the sorteerOpdr
	 */
	public JComboBox<String> getSorteerOpdr() {
		return sorteerOpdr;
	}

	/**
	 * @param sorteerOpdr
	 *            the sorteerOpdr to set
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
	 * @param naarBoven
	 *            the naarBoven to set
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
	 * @param naarLinks
	 *            the naarLinks to set
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
	 * @param naarRechts
	 *            the naarRechts to set
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
	 * @param upperPanel
	 *            the upperPanel to set
	 */
	public void setUpperPanel(JPanel upperPanel) {
		this.upperPanel = upperPanel;
	}


	/**
	 * @return the toegevoegdeOpdr
	 */
	public JList<Opdracht> getToegevoegdeOpdr() {
		return opdrachten;
	}

	/**
	 * @param toegevoegdeOpdr
	 *            the toegevoegdeOpdr to set
	 */
	public void setToegevoegdeOpdr(JList<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
	}

	/**
	 * @return the quizStatus
	 */
	public JComboBox<QuizStatus> getQuizStatus() {
		return quizStatus;
	}

	/**
	 * @param quizStatus
	 *            the quizStatus to set
	 */
	public void setQuizStatus(JComboBox<QuizStatus> quizStatus) {
		this.quizStatus = quizStatus;
	}

	public JList<Opdracht> getOpdrachten() {
		return opdrachten;
	}

	public void setOpdrachten(JList<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
	}

	public JTable getGeselecteerdeOpdrachten() {
		return geselecteerdeOpdrachten;
	}

	public void setGeselecteerdeOpdrachten(JTable geselecteerdeOpdrachten) {
		this.geselecteerdeOpdrachten = geselecteerdeOpdrachten;
	}

	public JScrollPane getPane() {
		return pane;
	}

	public void setPane(JScrollPane pane) {
		this.pane = pane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
