package utils;

import java.util.List;

import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;
import controller.QuizCreatieController;
import controller.QuizWijzigenController;
import view.OpdrachtCreatieView;
import view.QuizCreatieView;
import view.QuizListView;
import view.QuizWijzigenView;

public class Start {

	public static void main(String[] args) {
		QuizCreatieView view = new QuizCreatieView();
		OpdrachtCreatieView viewOp = new OpdrachtCreatieView();
		QuizWijzigenView qW = new QuizWijzigenView();
		
		OpdrachtCatalogus cat = new OpdrachtCatalogus();
		QuizCatalogus qcat = new QuizCatalogus();
		
		cat.leesOpdrachtenVanBestand();
		qcat.leesQuizzenVanBestand();
		
		QuizListView qlv = new QuizListView(qcat);
		QuizWijzigenController qC = new QuizWijzigenController(qW, qcat, cat);
		QuizCreatieController c = new QuizCreatieController(cat, qcat, view);
		
	}

}
