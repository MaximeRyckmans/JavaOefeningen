package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 * 
 */
public class OpdrachtCatalogus implements Cloneable,
		Comparable<OpdrachtCatalogus>, Iterable<Opdracht>, Subject {

	private List<Opdracht> opdrachten;
	private int id;
	private ArrayList<Observer> observers;
//	private File file = new File("bestanden/opdrachten");

	public OpdrachtCatalogus() {
		opdrachten = new ArrayList<Opdracht>();
		observers = new ArrayList<Observer>();
	}

	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}

	public void setOpdrachten(List<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addOpdrachtToList(Opdracht opdracht) {
		try {
			if (opdrachten.size() != 0) {
				if (!opdracht.equals(null) || !opdrachten.contains(opdracht)) {
					Opdracht o = opdrachten.get(opdrachten.size() - 1);
					opdracht.setId(o.getId() + 1);
				}
			} else {
				opdracht.setId(opdrachten.size() + 1);
			}
			this.opdrachten.add(opdracht);
			notifieerObservers();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void removeOpdrachtFromList(Opdracht opdracht) {
		if (opdrachten.contains(opdracht)) {
			this.opdrachten.remove(opdracht);
			notifieerObservers();
		}
	}

	@Override
	public int compareTo(OpdrachtCatalogus o) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this == o)
			return EQUAL;

		if (this.id < o.id)
			return BEFORE;
		return AFTER;
	}

	@Override
	public String toString() {
		return "OpdrachtCatalogus [opdrachten=" + opdrachten + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((opdrachten == null) ? 0 : opdrachten.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpdrachtCatalogus other = (OpdrachtCatalogus) obj;
		if (opdrachten == null) {
			if (other.opdrachten != null)
				return false;
		} else if (!opdrachten.equals(other.opdrachten))
			return false;
		return true;
	}

	@Override
	public Iterator<Opdracht> iterator() {
		return opdrachten.iterator();
	}

	@Override
	public void registreerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void verwijderObserver(Observer o) {
		int i= observers.indexOf(o);
		if(i>=0){
			observers.remove(i);
		}	
	}

	@Override
	public void notifieerObservers() {
		for(Observer obs : observers){
			obs.update(this);
		}	
	}
}
