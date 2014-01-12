package controller;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class QuizDeleteController implements ActionListener{
	
	private QuizDeleteView quizDeleteView;
	private QuizCatalogus quizCatalogus;
	private PersistencyFacade facade;
	private java.util.List<Quiz> verwijderdeQuizzen;

	public QuizDeleteController(){}
	public QuizDeleteController(QuizDeleteView quizDeleteView, QuizCatalogus quizCatalogus){
		this.quizCatalogus = quizCatalogus;
		this.quizDeleteView = quizDeleteView;
		quizDeleteView.setList(quizCatalogus.getQuizzen());
		quizDeleteView.buttonActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Verwijder quiz")) {
			deleteQuiz();
		}else if (e.getActionCommand().equals("Annuleer wijzigingen")) {
			cancelChanges();
		}else if (e.getActionCommand().equals("Wijzigingen opslaan")) {
			saveChanges();
		}
	}
	
	public void deleteQuiz(){
		for (Quiz quiz : quizCatalogus.getQuizzen()) {
			if (quiz.equals(quizDeleteView.getListQuizzen().getSelectedValue())) {
				verwijderdeQuizzen.add(quiz);
				quizDeleteView.getqModel().removeElement(quiz);
				quizCatalogus.getQuizzen().remove(quiz);
			}
		}
	}
	
	public void cancelChanges() {
		quizDeleteView.confirmationWindow("Ben je zeker dat je de wijzigingen wilt annuleren?",
				"Annuleer wijzigingen");
		if (quizDeleteView.isTrueIndicator()) {
			quizDeleteView.closeWindow();
		}
		
		System.out.println("check");
	}
	
	public void saveChanges() {
		quizDeleteView.confirmationWindow("Ben je zeker dat je de wijzigingen wilt opslaan?",
				"Wijzigingen opslaan");
		if (quizDeleteView.isTrueIndicator()) {
			for (Quiz quiz : verwijderdeQuizzen) {
				facade.getPersistable().verwijderQuiz(quiz, quizCatalogus);
			}
			quizDeleteView.closeWindow();
		}
	}
}
