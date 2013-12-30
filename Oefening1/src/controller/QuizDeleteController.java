package controller;

import model.QuizCatalogus;
import view.QuizDeleteView;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class QuizDeleteController {
	
	QuizDeleteView quizDeleteView;
	QuizCatalogus quizCatalogus;

	public QuizDeleteController(){}
	public QuizDeleteController(QuizDeleteView quizDeleteView, QuizCatalogus quizCatalogus){
		this.quizCatalogus = quizCatalogus;
		this.quizDeleteView = quizDeleteView;
	}
}
