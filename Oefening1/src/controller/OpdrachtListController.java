package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistency.PersistencyFacade;
import model.Observer;
import model.OpdrachtCatalogus;
import model.Subject;
import view.OpdrachtCreatieView;
import view.OpdrachtListView;
import view.QuizCreatieView;
import view.QuizWijzigenView;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class OpdrachtListController implements ActionListener, Observer{

	private OpdrachtListView opdrachtListView;
	private OpdrachtCatalogus opdrachtCatalogus;
	private PersistencyFacade facade;
	
	public OpdrachtListController() {}
	
	public OpdrachtListController(OpdrachtListView opdrachtListView, OpdrachtCatalogus opdrachtCatalogus, PersistencyFacade facade) {
		this.opdrachtListView = opdrachtListView;
		this.opdrachtCatalogus = opdrachtCatalogus;
		this.opdrachtCatalogus.registreerObserver(this);
		opdrachtListView.createNodes(opdrachtCatalogus);
		opdrachtListView.buttonActionListener(this);
		
		this.facade=facade;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Creëer nieuwe opdracht")) {
			OpdrachtCreatieView opdrachtCreatieView = new OpdrachtCreatieView();
			OpdrachtCreatieController opdrachtCreatieController = new OpdrachtCreatieController(opdrachtCreatieView, opdrachtCatalogus,facade);
		}else if (e.getActionCommand().equals("Wijzigen van een opdracht")) {
			
		}
		
	}

	@Override
	public void update(Subject subject) {
		this.opdrachtCatalogus = (OpdrachtCatalogus)subject;
		opdrachtListView.createNodes(this.opdrachtCatalogus);
		opdrachtListView.getTree().updateUI();	
	}

}
