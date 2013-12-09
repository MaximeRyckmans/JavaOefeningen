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
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
