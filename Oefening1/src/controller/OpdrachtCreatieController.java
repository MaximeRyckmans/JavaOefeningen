package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class OpdrachtCreatieController implements ActionListener {
	private Opdracht opdracht;
	private OpdrachtCatalogus opdrachtCatalogus;
	private OpdrachtCreatieView opdrCreatieView;

	public OpdrachtCreatieController(OpdrachtCreatieView opdrCreatieView, OpdrachtCatalogus opdrachtCatalogus) {
		this.opdrCreatieView = opdrCreatieView;
		this.opdrachtCatalogus = opdrachtCatalogus;
		this.opdrCreatieView.buttonActionListener(this);
	}

	public void createOpdracht() {
		try {
			System.out.println(opdrCreatieView.getCategorie().getSelectedItem()
					.toString());
			System.out.println(Categorie.Meerkeuze.toString());
			if (Categorie.Reproductie.toString() == opdrCreatieView
					.getCategorie().getSelectedItem().toString()) {
				opdracht = new Reproductie(opdrCreatieView.getVraagT()
						.toString(), opdrCreatieView.getAntwoordT().toString(),
						Integer.parseInt(opdrCreatieView
								.getMaxAantalPogingenC().toString()),
						opdrCreatieView.getAntwoordHintT().toString(),
						Integer.parseInt(opdrCreatieView.getMaxAntwoordTijdC()
								.toString()),
						(OpdrachtCategorie) opdrCreatieView
								.getOpdrachtCategorie().getSelectedItem());
			} else if (Categorie.Meerkeuze.toString() == opdrCreatieView
					.getCategorie().getSelectedItem().toString()) {
				OpdrachtCategorie categorie = (OpdrachtCategorie)opdrCreatieView.getOpdrachtCategorie().getSelectedItem();
				int aantalPogingen = Integer.parseInt(opdrCreatieView
						.getMaxAantalPogingenC().getSelectedItem().toString());
				opdracht = new Meerkeuze(
						opdrCreatieView.getVraagT().getText(), opdrCreatieView
								.getAntwoordT().getText(),
						aantalPogingen, "één;twee;drie;vier",
						categorie);
				

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Toevoegen")) {
			System.out.println("here");
			createOpdracht();
			opdrachtCatalogus.addOpdrachtToList(opdracht);
			opdrachtCatalogus.schrijfOpdrachtenNaarBestand();
		}

	}
}
