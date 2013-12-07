package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtTableModel;
import model.Quiz;
import model.QuizCatalogus;
import view.QuizCreatieView;

public class QuizCreatieController implements ActionListener {

	private QuizCreatieView quizCreatieView;
	private Quiz quiz;
	private OpdrachtCatalogus opdrachtCatalogusModel;
	private QuizCatalogus quizCatalogusModel;
	private List<Opdracht> opdrachten;
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
		quizCreatieView.getAuteurL().setText("Auteur:");
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
