package controller;

import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;
import view.QuizCreatieView;

public class QuizCreatieController {

	private QuizCreatieView quizCreatieView;
	private Quiz quiz;
	private OpdrachtCatalogus opdrachtCatalogusModel;
	private QuizCatalogus quizCatalogusModel;

	public QuizCreatieController(QuizCreatieView quizCreatieView,
			OpdrachtCatalogus opdrachtCatalogusModel,
			QuizCatalogus quizCatalogusModel) {
			
		this.quizCreatieView = quizCreatieView;
		this.opdrachtCatalogusModel = opdrachtCatalogusModel;
		this.quizCatalogusModel = quizCatalogusModel;
		
		this.opdrachtCatalogusModel.leesOpdrachtenVanBestand();
		this.quizCatalogusModel.leesQuizzenVanBestand();
		
	//	this.quizCreatieView.setOpdrachten(opdrachtCatalogusModel.getOpdrachten());
	}

}
