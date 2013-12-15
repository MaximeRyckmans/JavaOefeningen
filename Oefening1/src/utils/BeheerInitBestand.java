package utils;

import java.util.Properties;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BeheerInitBestand {
	private Properties tabel;
	
	public BeheerInitBestand(){
		tabel = new Properties();
	}
	
	public void keuzePersistentieMethode(){
		Object[] mogelijkePersistenties = { "Tekst persistentie", "MySQL persistentie" };
		Object selectie = null;
		selectie = JOptionPane.showInputDialog(null,"Selecteer persistentie methode",
                                       "Persistentie", JOptionPane.INFORMATION_MESSAGE, null, 
                                       mogelijkePersistenties, mogelijkePersistenties[0]);
		if (selectie !=null)
			setPersistentieMethode((String)selectie);
	}
	
	public void setPersistentieMethode(String persistentieMethode){
		try{
			FileOutputStream out = new FileOutputStream("init.dat");
			tabel.setProperty("persistentieMethode", persistentieMethode);
			tabel.store(out,"init quizen waarden");
			out.close();
		}
		catch (IOException ex){ex.printStackTrace();}
	}
	
	public String getPersistentieMethode(){
		try{
			FileInputStream in = new FileInputStream("init.dat");
			tabel.load(in);
			in.close();
			Object waarde = tabel.getProperty("persistentieMethode");
			if (waarde != null)
				return (String)waarde;
	
		}
		catch (IOException ex){ex.printStackTrace();}
		return null;
	}
	/*
	BeheerInitBestand bi = new BeheerInitBestand();
	bi.keuzePersistentieMethode();*/
}
