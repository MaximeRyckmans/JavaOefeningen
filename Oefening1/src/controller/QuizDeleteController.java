package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import persistency.PersistencyFacade;
import model.Quiz;
import model.QuizCatalogus;
import view.QuizDeleteView;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 * 
 */

public class QuizDeleteController implements ActionListener {

	private QuizDeleteView quizDeleteView;
	private QuizCatalogus quizCatalogus;
	private PersistencyFacade facade;
	private List<Quiz> verwijderdeQuizzen;

	public QuizDeleteController() {
	}

	public QuizDeleteController(QuizDeleteView quizDeleteView,
			QuizCatalogus quizCatalogus, PersistencyFacade facade) {
		this.quizCatalogus = quizCatalogus;
		this.quizDeleteView = quizDeleteView;
		this.facade=facade;
		verwijderdeQuizzen = new ArrayList<Quiz>();
		
		quizDeleteView.setList(quizCatalogus.getQuizzen());
		quizDeleteView.buttonActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Quiz verwijderen")) {
			deleteQuiz();
		} else if (e.getActionCommand().equals("Annuleer wijzigingen")) {
			cancelChanges();
		} else if (e.getActionCommand().equals("Wijzigingen opslaan")) {
			saveChanges();
		}
	}

	public void deleteQuiz() {

		Iterator<Quiz> qit = quizCatalogus.getQuizzen().iterator();
		while (qit.hasNext()) {
			
			Quiz quiz=qit.next();
			if (quiz == quizDeleteView.getListQuizzen().getSelectedValue()) {

				verwijderdeQuizzen.add(quiz);
				quizDeleteView.getqModel().removeElement(quiz);
				//qit.remove();
				quizCatalogus.removeQuizFromList(quiz);
			}
		}
	}

	public void cancelChanges() {
		quizDeleteView.confirmationWindow(
				"Ben je zeker dat je de wijzigingen wilt annuleren?",
				"Annuleer wijzigingen");
		if (quizDeleteView.isTrueIndicator()) {
			for (Quiz quiz : verwijderdeQuizzen) {
				quizCatalogus.addQuizToList(quiz);
			}
			quizDeleteView.closeWindow();
		}

	}

	public void saveChanges() {
		quizDeleteView.confirmationWindow(
				"Ben je zeker dat je de wijzigingen wilt opslaan?",
				"Wijzigingen opslaan");
		if (quizDeleteView.isTrueIndicator()) {
			for (Quiz quiz : verwijderdeQuizzen) {
				
				facade.getPersistable().verwijderQuiz(quiz, quizCatalogus);
			}
			quizDeleteView.closeWindow();
		}
	}
}
