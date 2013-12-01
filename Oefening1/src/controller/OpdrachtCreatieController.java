package controller;

import model.Categorie;
import model.Meerkeuze;
import model.Opdracht;
import model.Reproductie;
import view.OpdrachtCreatieView;
import view.QuizCreatieView;

/**
 * @author Goossens Nicolas
 * @version 1.0
 */

public class OpdrachtCreatieController {
	private Opdracht opdracht;
	private Reproductie reproductie;
	private OpdrachtCreatieView opdrCreatieView;

	public OpdrachtCreatieController(OpdrachtCreatieView opdrCreatieView){
		this.opdrCreatieView = opdrCreatieView; 
	}
	
	public void createOpdracht(){
		if (opdrCreatieView.getCategorie().toString() == Categorie.Reproductie.toString()){
			reproductie = new Reproductie(opdrCreatieView.getVraagT().toString(), opdrCreatieView.getAntwoordT().toString(), Integer.parseInt(opdrCreatieView.getMaxAantalPogingenC().toString()),
					opdrCreatieView.getAntwoordHintT().toString(), Integer.parseInt(opdrCreatieView.getMaxAntwoordTijdC().toString()));
		}
		
	}
}
