package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import model.Leraar;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.OpdrachtTableModel;
import model.Quiz;
import model.QuizCatalogus;
import model.QuizStatus;
import view.QuizCreatieView;

public class QuizCreatieController implements ActionListener {

	private QuizCreatieView quizCreatieView;
	private Quiz quiz;
	private OpdrachtCatalogus opdrachtCatalogusModel;
	private QuizCatalogus quizCatalogusModel;
	private List<Opdracht> opdrachten;
	private String[] klassen = { "1A", "1B", "1C", "2A", "2B", "2C", "3A",
			"3B", "4A", "5A", "6A" };
	private String[] sorterenOp = { "geen", "categorie", "vraag" };
	//private OpdrachtTableModel opdrachtTableModel;
	
	public QuizCreatieController(){
		
	}
	
	public QuizCreatieController(OpdrachtCatalogus opdrachtCatalogusModel,
			QuizCatalogus quizCatalogusModel, QuizCreatieView quizCreatieView) {

		this.opdrachtCatalogusModel = opdrachtCatalogusModel;
		this.quizCatalogusModel = quizCatalogusModel;
		this.opdrachtCatalogusModel.leesOpdrachtenVanBestand();
		this.quizCatalogusModel.leesQuizzenVanBestand();
		opdrachten = opdrachtCatalogusModel.getOpdrachten();
	//	opdrachtTableModel = new OpdrachtTableModel();
	//	opdrachtTableModel.setOpdrachtLijst(opdrachten);
		
		this.quizCreatieView = quizCreatieView;
		setInitiëleWaardenQuizCreatieView();
	
		quizCreatieView.buttonActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println("this is: " + action);

		if (action.equals(">>>>")) {

			verplaatsOpdrachtNaarRechts();

		} else if (action.equals("<<<<")) {

			verplaatsOpdrachtNaarLinks();

		} else if (action.equals("^^^^")) {

			verplaatsOpdrachtNaarBoven();

		} else if (action.equals("Registreer nieuwe quiz")) {

			registreerNieuweQuiz();

		}
	}

	private void verplaatsOpdrachtNaarRechts() {

	}

	private void verplaatsOpdrachtNaarLinks() {

	}

	private void verplaatsOpdrachtNaarBoven() {

	}

	private void registreerNieuweQuiz() {

	}
	public void populeerListModel(DefaultListModel<Opdracht> model){
		
		for(Opdracht opdr: this.opdrachten){
			model.addElement(opdr);
		}
		
	}
	private void setInitiëleWaardenQuizCreatieView(){
		//Set the text of all labels in the quizCreatieView
		quizCreatieView.getOnderwerpL().setText("Onderwerp:");
		quizCreatieView.getKlasL().setText("Klas:");
		quizCreatieView.getAuteurL().setText("Auteur:");
		quizCreatieView.getCategorieL().setText("Toon opdrachten van:");
		quizCreatieView.getAantalToegevoegdeOpdrL().setText("Aantal toegevoegde opdrachten:");
		quizCreatieView.getSorteerOpdrL().setText("Sorteer opdrachten op:");
		quizCreatieView.getAantalToegevoegdeOpdr().setText("0");
		
		//Set all the comboboxes
		quizCreatieView.getKlas().setModel(new DefaultComboBoxModel<>(klassen));
		quizCreatieView.getSorteerOpdr().setModel(new DefaultComboBoxModel<>(sorterenOp));
		quizCreatieView.getCategorie().setModel(new DefaultComboBoxModel<>(OpdrachtCategorie
				.values()));
		quizCreatieView.getQuizStatus().setModel(new DefaultComboBoxModel<>(QuizStatus.values()));
		quizCreatieView.getAuteur().setModel(new DefaultComboBoxModel<>(Leraar.values()));
		
		//Set all the buttons
		quizCreatieView.getNieuweQuiz().setText("Registreer nieuwe quiz");
		quizCreatieView.getNaarBoven().setText("^^^^");
		quizCreatieView.getNaarRechts().setText(">>>>");
		quizCreatieView.getNaarLinks().setText("<<<<");
		
	}

	/**
	 * @return the opdrachtTableModel
	 */
/*	public OpdrachtTableModel getOpdrachtTableModel() {
		return opdrachtTableModel;
	}

	/**
	 * @param opdrachtTableModel the opdrachtTableModel to set
	 */
/*	public void setOpdrachtTableModel(OpdrachtTableModel opdrachtTableModel) {
		this.opdrachtTableModel = opdrachtTableModel;
	}*/

}
