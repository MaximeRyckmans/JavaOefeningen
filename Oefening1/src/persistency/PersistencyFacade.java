package persistency;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class PersistencyFacade {

	private Persistable persistable;
	
	//facade constructor for the persistence of the quizzes and opdrachten.
	public PersistencyFacade() {
		if (getPersistencyMethode().equals("Tekst persistentie")) {
			persistable = new TekstPersistency();
		} else if (getPersistencyMethode().equals("MySQL persistentie")) {
			persistable = new MySQLPersistency();
		}
	}
	
	//Checks which persistency method is being used.
	private String getPersistencyMethode() {
		File file = new File("init.dat");
		String juist = null;
		if (file.exists()) {
			try {

				Scanner scanner = new Scanner(file);
				int tel = 0;
				while (scanner.hasNextLine()) {
					tel++;
					String fout = scanner.nextLine();
					if (tel == 2) {

						juist = scanner.nextLine();
					}
				}
				juist = juist.substring(20);

				if (scanner != null) {
					scanner.close();
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return juist;
	}
}
