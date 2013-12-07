package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import controller.QuizCreatieController;
import model.Leraar;
import model.Opdracht;
import model.OpdrachtCatalogus;
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
	@SuppressWarnings("rawtypes")
	private JComboBox quizStatus;
	private JComboBox<Leraar> auteur;
	private JButton nieuweQuiz, naarBoven, naarLinks, naarRechts;
	private JPanel upperPanel, lowerPanel;
	

	private JList<Opdracht> opdrachten;
	private String[] klassen = { "1A", "1B", "1C", "2A", "2B", "2C", "3A",
			"3B", "4A", "5A", "6A" };
	private String[] sorterenOp = { "geen", "categorie", "vraag" };
//	private QuizCreatieController controller = new QuizCreatieController();

//	private OpdrachtCatalogus opdrachtCatalogus = new OpdrachtCatalogus();
//	private List<Opdracht> opdrachtenLijst;
	String[] klassenjaar = { "", "1", "2", "3", "4", "5", "6" };
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizCreatieView() {
		JFrame frame = new JFrame("Aanmaken nieuwe Quiz");
		frame.setSize(900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout());
		upperPanel = createUpperPanel();
		lowerPanel = createLowerPanel();
		frame.add(upperPanel, BorderLayout.NORTH);
		frame.add(lowerPanel);
		frame.setVisible(true);
	}

	// Create the content pane which displays the buttons and widgets on-screen.
	@SuppressWarnings("unchecked")
	private JPanel createUpperPanel() {

		JPanel upperPanel = new JPanel();
		upperPanel.setBorder(new EmptyBorder(10, 10, 50, 10));

		upperPanel.setSize(400, 400);
		onderwerpL = new JLabel("Onderwerp:");
		onderwerpText = new JTextField(20);
		klasL = new JLabel("Klas:");
		klas = new JComboBox<String>();
		klas.setModel(new DefaultComboBoxModel<>(klassen));
		klas = new JComboBox(klassenjaar);
		auteurL = new JLabel();
		auteur = new JComboBox<Leraar>();
		auteur.setModel(new DefaultComboBoxModel<>(Leraar.values()));
		quizStatus = new JComboBox(QuizStatus.values());
		auteur = new JComboBox(Leraar.values());
		nieuweQuiz = new JButton("Registreer nieuwe quiz");

		upperPanel.add(onderwerpL);
		upperPanel.add(onderwerpText);
		upperPanel.add(klasL);
		upperPanel.add(klas);
		upperPanel.add(auteurL);
		upperPanel.add(auteur);
		upperPanel.add(quizStatus);
		upperPanel.add(nieuweQuiz);
		upperPanel.setVisible(true);
		return upperPanel;
	}

	private JPanel createLowerPanel() {
		JPanel lowerPanel = new JPanel();
		lowerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		lowerPanel.setSize(450, 450);
		categorieL = new JLabel("Toon opdrachten van:");
		categorie = new JComboBox<OpdrachtCategorie>();
		categorie.setModel(new DefaultComboBoxModel<>(OpdrachtCategorie
				.values()));
		aantalToegevoegdeOpdrL = new JLabel("Aantal toegevoegde opdrachten:");
		aantalToegevoegdeOpdr = new JLabel("0");
		sorteerOpdrL = new JLabel("Sorteer opdrachten op:");
		sorteerOpdr = new JComboBox<String>();
		sorteerOpdr.setModel(new DefaultComboBoxModel<>(sorterenOp));
		naarBoven = new JButton("^^^^");
	//	opdrachtenLijst = opdrachtCatalogus.getOpdrachten();
		DefaultListModel<Opdracht> model = new DefaultListModel<Opdracht>();
//		controller.populeerListModel(model);
		opdrachten = new JList<Opdracht>(model);
		
		naarRechts = new JButton(">>>>");
		naarLinks = new JButton("<<<<");

		opdrachten = new JList<Opdracht>();
		lowerPanel.add(categorieL);
		lowerPanel.add(categorie);
		lowerPanel.add(aantalToegevoegdeOpdrL);
		lowerPanel.add(aantalToegevoegdeOpdr);
		lowerPanel.add(sorteerOpdrL);
		lowerPanel.add(sorteerOpdr);
		lowerPanel.add(opdrachten);
		lowerPanel.add(naarBoven);

		lowerPanel.add(naarRechts);
		lowerPanel.add(naarLinks);
		// lowerPanel.add(toegevoegdeOpdr);

		return lowerPanel;

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
	 * @return the opdrachten
	 */
	/*
	 * public JTable getOpdrachten() { return opdrachten; }
	 * 
	 * /**
	 * 
	 * @param opdrachten the opdrachten to set
	 */
	/*
	 * public void setOpdrachten(JTable opdrachten) { this.opdrachten =
	 * opdrachten; }
	 */
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
	public JComboBox<String> getQuizStatus() {
		return quizStatus;
	}

	/**
	 * @param quizStatus
	 *            the quizStatus to set
	 */
	public void setQuizStatus(JComboBox<String> quizStatus) {
		this.quizStatus = quizStatus;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
