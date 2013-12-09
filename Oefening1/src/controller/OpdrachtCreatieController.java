package controller;

import model.Categorie;
import model.Meerkeuze;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.Reproductie;
import view.OpdrachtCreatieView;
import view.QuizCreatieView;

/**
 * @author Goossens Nicolas
 * @version 1.0
 */

public class OpdrachtCreatieController {
	private Opdracht opdracht;
	OpdrachtCatalogus oc = new OpdrachtCatalogus();
	private OpdrachtCreatieView opdrCreatieView;

	public OpdrachtCreatieController(OpdrachtCreatieView opdrCreatieView) {
		this.opdrCreatieView = opdrCreatieView;
	}

	public void createOpdracht() {
		if (Categorie.Reproductie.toString() == opdrCreatieView.getCategorie()
				.toString()) {
			opdracht = new Reproductie(opdrCreatieView.getVraagT()
					.toString(), opdrCreatieView.getAntwoordT().toString(),
					Integer.parseInt(opdrCreatieView.getMaxAantalPogingenC()
							.toString()), opdrCreatieView.getAntwoordHintT()
							.toString(), Integer.parseInt(opdrCreatieView
							.getMaxAntwoordTijdC().toString()),
					(OpdrachtCategorie) opdrCreatieView.getOpdrachtCategorie()
							.getSelectedItem());
			oc.addOpdrachtToList(opdracht);
			oc.schrijfOpdrachtenNaarBestand();
		} else if (Categorie.Meerkeuze.toString() == opdrCreatieView
				.getCategorie().toString()) {
			opdracht = new Meerkeuze(opdrCreatieView.getVraagT().toString(),
					opdrCreatieView.getAntwoordT().toString(),
					Integer.parseInt(opdrCreatieView.getMaxAantalPogingenC()
							.toString()), null,
					(OpdrachtCategorie) opdrCreatieView.getOpdrachtCategorie()
							.getSelectedItem());
			oc.addOpdrachtToList(opdracht);
			oc.schrijfOpdrachtenNaarBestand();
		}

	}
}
