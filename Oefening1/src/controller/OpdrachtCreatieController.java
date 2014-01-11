package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistency.PersistencyFacade;
import model.Categorie;
import model.Meerkeuze;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.Opsomming;
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
	private PersistencyFacade facade;

	public OpdrachtCreatieController(OpdrachtCreatieView opdrCreatieView,
			OpdrachtCatalogus opdrachtCatalogus, PersistencyFacade facade) {
		this.opdrCreatieView = opdrCreatieView;
		this.opdrachtCatalogus = opdrachtCatalogus;
		this.opdrCreatieView.buttonActionListener(this);
		this.facade = facade;
	}

	public void createOpdracht() {
		try {
			String vraag = opdrCreatieView.getVraagT().getText();
			String antwoord = opdrCreatieView.getAntwoordT().getText();
			int maxAantalPogingen = Integer.valueOf((String) opdrCreatieView
					.getMaxAantalPogingenC().getSelectedItem());
			String antwoordHint = opdrCreatieView.getAntwoordHintT().getText();
			int maxAntwoordTijd = Integer.valueOf((String) opdrCreatieView
					.getMaxAntwoordTijdC().getSelectedItem());
			String opdrachtCategorieString = opdrCreatieView
					.getOpdrachtCategorie().getSelectedItem().toString();
			OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie
					.valueOf(opdrachtCategorieString);
			String soortOpdrachtString = opdrCreatieView.getCategorie()
					.getSelectedItem().toString();
			Categorie categorie = Categorie.valueOf(soortOpdrachtString);

			if (Categorie.Reproductie.equals(categorie)) {
				String trefwoorden = opdrCreatieView.getTrefwoordenT()
						.getText();
				int minAantalJuisteTrefwoorden = Integer
						.valueOf((String) opdrCreatieView
								.getMinAantalJuisteTrefwoordenC()
								.getSelectedItem());
			
				opdracht = new Reproductie(vraag, antwoordHint,
						maxAantalPogingen, antwoordHint, maxAntwoordTijd,
						trefwoorden, minAantalJuisteTrefwoorden,
						opdrachtCategorie);

			} else if (Categorie.Meerkeuze.equals(categorie)) {

				String alleKeuzes = opdrCreatieView.getAlleKeuzesT().getText();

				opdracht = new Meerkeuze(vraag, antwoord, maxAantalPogingen,
						alleKeuzes, antwoordHint, maxAntwoordTijd,
						opdrachtCategorie);

			} else if (Categorie.Opsomming.equals(categorie)) {

				opdracht = new Opsomming(vraag, antwoord, maxAantalPogingen,
						antwoordHint, maxAntwoordTijd, opdrachtCategorie);

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (opdrCreatieView.getCategorie().getSelectedItem().toString() == "Opsomming") {
			opdrCreatieView.getOpsommingPanel().setVisible(true);
			opdrCreatieView.getMeerKeuzePanel().setVisible(false);
			opdrCreatieView.getReproductiePanel().setVisible(false);

		}
		if (opdrCreatieView.getCategorie().getSelectedItem().toString() == "Meerkeuze") {
			opdrCreatieView.getOpsommingPanel().setVisible(false);
			opdrCreatieView.getMeerKeuzePanel().setVisible(true);
			opdrCreatieView.getReproductiePanel().setVisible(false);

		}
		if (opdrCreatieView.getCategorie().getSelectedItem().toString() == "Reproductie") {
			opdrCreatieView.getOpsommingPanel().setVisible(false);
			opdrCreatieView.getMeerKeuzePanel().setVisible(false);
			opdrCreatieView.getReproductiePanel().setVisible(true);

		}
		if (action.equals("Toevoegen")) {
			createOpdracht();
			facade.getPersistable().slaOpdrachtOp(opdrachtCatalogus, opdracht);

			opdrCreatieView.getAntwoordHintT().setText("");
			opdrCreatieView.getAntwoordT().setText("");
			opdrCreatieView.getVraagT().setText("");
			opdrCreatieView.getAlleKeuzesT().setText("");
			opdrCreatieView.getMaxAntwoordTijdC().setSelectedIndex(0);
			opdrCreatieView.getMaxAantalPogingenC().setSelectedIndex(0);
		}

	}
}
