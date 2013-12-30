package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistency.PersistencyFacade;
import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import view.QuizCreatieView;
import view.QuizDeleteView;
import view.QuizListView;
import view.QuizWijzigenView;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class QuizListController implements ActionListener{
	
	private QuizListView quizListView;
	private QuizCatalogus quizCatalogus;
	private OpdrachtCatalogus opdrachtCatalogus;
	private PersistencyFacade facade;

	public QuizListController() {}
	
	public QuizListController(QuizListView quizListView, QuizCatalogus quizCatalogus, OpdrachtCatalogus opdrachtCatalogus, PersistencyFacade facade) {
		this.quizListView = quizListView;
		this.quizCatalogus = quizCatalogus;
		this.opdrachtCatalogus = opdrachtCatalogus;
		this.facade = facade;
		
		quizListView.createNodes(quizCatalogus);
		quizListView.buttonActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Creëer nieuwe quiz")) {
			QuizCreatieView quizCreatieView = new QuizCreatieView();
			QuizCreatieController quizCreatieController = new QuizCreatieController(opdrachtCatalogus, quizCatalogus, quizCreatieView, facade);
		}else if (e.getActionCommand().equals("Wijzigen van een quiz")) {
			QuizWijzigenView quizWijzigenView = new QuizWijzigenView("Wijzig quiz");
			QuizWijzigenController quizWijzigenController = new QuizWijzigenController(quizWijzigenView, quizCatalogus, opdrachtCatalogus);
		}else if (e.getActionCommand().equals("Verwijder quiz")) {
			QuizDeleteView quizDeleteView = new QuizDeleteView();
		}
	}
}