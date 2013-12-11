package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;
import view.QuizWijzigenView;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class QuizWijzigenController implements ActionListener {

	private QuizWijzigenView quizWijzigenView;
	private QuizCatalogus quizCatalogus;
	private OpdrachtCatalogus opdrachtCatalogus;
	private Quiz quiz;
	private Opdracht opdracht;
	
	public QuizWijzigenController(){}
	
	public QuizWijzigenController(QuizWijzigenView quizWijzigenView, QuizCatalogus quizCatalogus,
			OpdrachtCatalogus opdrachtCatalogus){
		this.quizWijzigenView = quizWijzigenView;
		this.quizCatalogus = quizCatalogus;
		this.opdrachtCatalogus = opdrachtCatalogus;
		
		quizWijzigenView.setInitiëleWaarden(quizCatalogus.getQuizzen(), opdrachtCatalogus.getOpdrachten());
		quizWijzigenView.buttonActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Quiz object = null;
		if (e.getActionCommand().equals("Voeg opdracht toe aan quiz")) {
			voegOpdrachtToeAanQuiz();
		} else if (e.getActionCommand().equals(" Verwijder opdracht in quiz ")) {
			verwijderOpdrachtInQuiz(object);
		} else if (e.getActionCommand().equals("Wijziging opslaan")) {
			wijzigingQuizOpslaan();
		} else if (e.getActionCommand().equals("Wijzig quiz")) {
			object = wijzigQuiz();
			quizWijzigenView.setOpdrachtenInQuiz(object.getOpdrachten());
		}
		
	}

	private Quiz wijzigQuiz() {
		Quiz wQ = null;
		
		for (Quiz q : quizCatalogus.getQuizzen()) {
			if (q.getOnderwerp().equals(quizWijzigenView.getListQuizzen().getSelectedValue())) {
				wQ = q;
			}
		}
		return wQ;
	}

	private void wijzigingQuizOpslaan() {
		// TODO Auto-generated method stub
		
	}

	private void verwijderOpdrachtInQuiz(Quiz quiz) {
		
	}

	private void voegOpdrachtToeAanQuiz() {
		// TODO Auto-generated method stub
		
	}
}
