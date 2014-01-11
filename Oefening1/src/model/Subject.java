/**
 * 
 */
package model;

/**
 * @author Maxime Ryckmans
 *
 *Interface to make a class a subject (observer pattern)
 */
public interface Subject {
	public void registreerObserver(Observer o);
	public void verwijderObserver(Observer o);
	public void notifieerObservers();
}
