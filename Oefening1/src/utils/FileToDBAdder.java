package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Meerkeuze;
import model.Opdracht;
import model.OpdrachtCategorie;
import model.Opsomming;
import model.Reproductie;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class FileToDBAdder {
	Connection con = null;
	PreparedStatement pst = null;

	public void addOpdrachtenFromFileToDB() {
		con = createConnection();
		ResultSet rs = null;
		try {

			List<Opdracht> opdrachtenLijst = leesOpdrachtenVanBestand();

			for (Opdracht opdr : opdrachtenLijst) {
				pst = con
						.prepareStatement("select idOpdrachtSoorten from opdrachtsoorten where OpdrachtSoortenNaam=?");
				pst.setString(1, opdr.getClass().getSimpleName());
				rs = pst.executeQuery();
				int opdrachtSoortID = 0;
				if (rs.next()) {
					opdrachtSoortID = rs.getInt(1);
				}

				pst = con
						.prepareStatement("select idOpdrachtCategorieën from opdrachtcategorieën where OpdrachtCategorieNaam=?");
				pst.setString(1, opdr.getOpdrachtCategorie().toString());
				rs = pst.executeQuery();
				int opdrachtCategorieID = 0;
				if (rs.next()) {
					opdrachtCategorieID = rs.getInt(1);
				}

				pst = con
						.prepareStatement("insert into opdrachten(vraag,antwoord,maxAantalpogingen,antwoordHint,maxAntwoordTijd,opdrachtenCategorie,soortOpdracht) values(?,?,?,?,?,?,?)");
				pst.setString(1, opdr.getVraag());
				pst.setString(2, opdr.getAntwoord());
				pst.setInt(3, opdr.getMaxAantalPogingen());
				pst.setString(4, opdr.getAntwoordHint());
				pst.setInt(5, opdr.getmaxAntwoordTijd());
				pst.setInt(6, opdrachtCategorieID);
				pst.setInt(7, opdrachtSoortID);
				pst.executeUpdate();

				pst = con
						.prepareStatement("select idopdrachten from opdrachten where vraag=?");
				pst.setString(1, opdr.getVraag());
				rs = pst.executeQuery();
				int opdrachtID = 0;
				if (rs.next()) {
					opdrachtID = rs.getInt(1);
				}

				if (opdr.getClass().getSimpleName().equals("Meerkeuze")) {
					String alleKeuzes = ((Meerkeuze) opdr).getAlleKeuzes();
					pst = con
							.prepareStatement("insert into meerkeuzeopdrachten(idmeerkeuzeOpdrachten,alleKeuzes) values(?,?)");
					pst.setInt(1, opdrachtID);
					pst.setString(2, alleKeuzes);
					pst.executeUpdate();
				} else if (opdr.getClass().getSimpleName()
						.equals("Reproductie")) {
					String trefwoorden = ((Reproductie) opdr).getTrefwoorden();
					int minTrefwoorden = ((Reproductie) opdr)
							.getMinAantalJuisteTrefwoorden();
					pst = con
							.prepareStatement("insert into reproductieopdrachten(idreproductieOpdrachten,trefwoorden,minAantalTrefwoorden) values(?,?,?)");
					pst.setInt(1, opdrachtID);
					pst.setString(2, trefwoorden);
					pst.setInt(3, minTrefwoorden);
					pst.executeUpdate();
				} else if (opdr.getClass().getSimpleName().equals("Opsomming")) {
					pst = con
							.prepareStatement("insert into opsommingsopdrachten(idopsommingsOpdrachten) values(?)");
					pst.setInt(1, opdrachtID);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		// apparently this isn't needed anymore in java 7?
		// finally {
		// try {
		// if (rs != null) {
		//
		// rs.close();
		// }
		// if (pst != null) {
		// pst.close();
		// }
		// closeConnection();
	}

	private List<Opdracht> leesOpdrachtenVanBestand() {
		File file = new File("bestanden/opdrachten");
		List<Opdracht> list = new ArrayList<Opdracht>();
		if (file.exists()) {
			try {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNext()) {
					String lijn = scanner.nextLine();
					String[] velden = lijn.split(",");
					int id = Integer.parseInt(velden[0]);
					String vraag = velden[1];
					String antwoord = velden[2];
					int maxAantalPogingen = Integer.parseInt(velden[3]);
					String antwoordHint = velden[4];
					int maxAntwoordTijd = Integer.parseInt(velden[5]);
					String soortOpdracht = velden[6];
					String opdrachtCategorieString = velden[7];
					OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie
							.valueOf(opdrachtCategorieString);
					Opdracht opdracht = null;
					if (soortOpdracht.equals("Meerkeuze")) {
						String alleKeuzes = velden[8];
						opdracht = new Meerkeuze(vraag, antwoord,
								maxAantalPogingen, alleKeuzes, antwoordHint,
								maxAntwoordTijd, opdrachtCategorie);
						opdracht.setId(id);
					} else if (soortOpdracht.equals("Reproductie")) {
						String trefwoorden = velden[8];
						int minAantalJuisteTrefwoorden = Integer
								.parseInt(velden[9]);
						opdracht = new Reproductie(vraag, antwoordHint,
								maxAantalPogingen, antwoordHint,
								maxAntwoordTijd, trefwoorden,
								minAantalJuisteTrefwoorden, opdrachtCategorie);
					} else if (soortOpdracht.equals("Opsomming")) {
						opdracht = new Opsomming(vraag, antwoord,
								maxAantalPogingen, antwoordHint,
								maxAntwoordTijd, opdrachtCategorie);
					}
					list.add(opdracht);
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (FileNotFoundException ex) {
				System.out.println("bestand niet gevonden");
			} catch (NullPointerException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				System.out.println("here");
				System.out.println(ex.getMessage());
			}
		}
		return list;
	}

	private Connection createConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/quizdb2";
			String user = "root";
			String password = "root";

			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	private void closeConnection() {
		try {
			this.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//	public static void main(String[] args) {
//		FileToDBAdder ftdb = new FileToDBAdder();
//		ftdb.addOpdrachtenFromFileToDB();
//	}
}
