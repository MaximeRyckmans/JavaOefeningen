package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import model.Opdracht;

public abstract class QuizController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isToegevoegdeOpdracht(List<Opdracht> opdrachtenLijst,
			Opdracht opdracht) {
		boolean isToegevoegd = false;
		if (opdrachtenLijst.contains(opdracht)) {
			isToegevoegd=true;
			JOptionPane.showMessageDialog(null, "Opdracht is al toegevoegd. Selecteer een andere opdracht.");
		}
		return isToegevoegd;

		
	}

}
