package model;

import java.util.LinkedList;
import java.util.List;

public class QuizCatalogus {

	private List<Quiz> quizCatalogus = new LinkedList<Quiz>();

	public QuizCatalogus() {

	}

	public void addQuiz(Quiz quiz) {
		try {
			quizCatalogus.add(quiz);
		} catch (NullPointerException ex) {
			System.out.println(ex);
		}
	}
	
	public void removeQuiz(Quiz quiz){
		try {
			quizCatalogus.remove(quiz);
		} catch (NullPointerException ex) {
			System.out.println(ex);
		}
	}
}
