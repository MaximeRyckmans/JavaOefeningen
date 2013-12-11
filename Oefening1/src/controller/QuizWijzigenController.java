package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
	private Quiz quiz, copyQuizOld;
	
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
		if (e.getActionCommand().equals("Voeg opdracht toe aan quiz")) {
			voegOpdrachtToeAanQuiz();
		} else if (e.getActionCommand().equals(" Verwijder opdracht in quiz ")) {
			verwijderOpdrachtInQuiz();
		} else if (e.getActionCommand().equals("Alle wijzigingen opslaan")) {
			wijzigingQuizOpslaan();
		} else if (e.getActionCommand().equals("Wijzig quiz")) {
			wijzigQuiz();
			quizWijzigenView.setOpdrachtenInQuiz(quiz.getOpdrachten());
		} else if (e.getActionCommand().equals("Annuleer")) {
			annuleer();
		} else {

		}
		
	}

	private void annuleer() {
		quizCatalogus.getQuizzen().remove(quiz);
		quizCatalogus.getQuizzen().add(copyQuizOld);
		
		quizWijzigenView.windowClosing("Ben je zeker dat je de wijzigingen wilt annuleren?", "Annuleer wijzigingen");
		
	}

	private void wijzigQuiz() {		
		for (Quiz q : quizCatalogus.getQuizzen()) {
			if (q.getOnderwerp().equals(quizWijzigenView.getListQuizzen().getSelectedValue())) {
				quiz = q;
				copyQuizOld = quiz;
			}
		}
	}

	private void wijzigingQuizOpslaan() {
		quizWijzigenView.windowClosing("Ben je zeker dat je deze wijzigingen wilt opslaan?", "Opslaan wijzigingen");
	}

	private void verwijderOpdrachtInQuiz() {
		try {
			for (Opdracht opdracht : quiz.getOpdrachten()) {
				if (opdracht.getVraag().equals(quizWijzigenView.getListOpdrachtenInQuiz().getSelectedValue())) {
					quiz.getOpdrachten().remove(opdracht);
					quizWijzigenView.setOpdrachtenInQuiz(quiz.getOpdrachten());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
	}

	private void voegOpdrachtToeAanQuiz() {
		try {
			for (Opdracht opdracht : opdrachtCatalogus.getOpdrachten()) {
				if (opdracht.getVraag().equals(quizWijzigenView.getListOpdrachten().getSelectedValue())) {
					quiz.getOpdrachten().add(opdracht);
					quizWijzigenView.setOpdrachtenInQuiz(quiz.getOpdrachten());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
