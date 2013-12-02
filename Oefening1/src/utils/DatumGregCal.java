package utils;

/**
 * @author Pulinx Davy
 * @version 2.0
 */

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatumGregCal implements Comparable<DatumGregCal> {
	
	private String[] namenMaand = {"januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december"};
	private GregorianCalendar calender;

	//Default Constructor
	public DatumGregCal(){
		calender = new GregorianCalendar();
	}
	
	//Constructor met object als parameter
	public DatumGregCal(Date date){
		try{
			calender = new GregorianCalendar();
			calender.setTime(date);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//Constructor met parameters dag, maand en jaar
	public DatumGregCal(int dag, int maand, int jaar){
		try{
			calender = new GregorianCalendar(jaar, maand-1, dag);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//Constructor met string als parameter
	public DatumGregCal(String string){
		try {
			String[] deelVanDatum = string.split("/");
			int jaar = Integer.parseInt(deelVanDatum[2]);
			int maand = Integer.parseInt(deelVanDatum[1]) - 1;
			int dag = Integer.parseInt(deelVanDatum[0]);
			
			if (controleerDag(dag, maand, jaar) == false) throw new IllegalArgumentException("Dag is fout ingevoerd");
			if (controleerMaand(maand) == false) throw new IllegalArgumentException("Maand is fout ingevoerd");
			if (controleerJaar(jaar) == false) throw new IllegalArgumentException("Jaar is fout ingevoerd");
			
			calender = new GregorianCalendar(jaar, maand-1, dag);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public GregorianCalendar getCalender() {
		return calender;
	}

	public void setCalender(GregorianCalendar calender) {
		this.calender = calender;
	}
	
	//setDatum methode
	public boolean setDatumGregCal(int dag, int maand, int jaar) throws Exception{
		calender = new GregorianCalendar(dag, maand, jaar);
		return true;
	}
	
	//Controleer up juiste invoer dag
	private boolean controleerDag(int dag, int maand, int jaar){
		int[] dagenPerMaand = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		if (dag > 0 && dag <= dagenPerMaand[maand] ) {
			if (calender.isLeapYear(jaar)) {
				return true;
			}
			return true;
		}
		return false;
	}
	
	//Controleer op juiste invoer maand
	private boolean controleerMaand(int maand){
		if(String.valueOf(maand).length() == 2){
			return true;
		}
		
		if(maand-- >= 0 && maand-- < 12){
			return true;
		}
		
		return false;
	}
	
	//Conroleer op juiste invoer jaar
	private boolean controleerJaar(int jaar) {
		if (String.valueOf(jaar).length() == 4) {
			return true;
		}
		
		return false;
	}
	
	//Get methode Amerikaanse formaat
	public String getDatumInAmerikaansFormaat(){
		return String.format("%d/%d/%d", 
				calender.get(Calendar.MONTH)+1, calender.get(Calendar.DAY_OF_MONTH), calender.get(Calendar.YEAR));
	}
	
	//Get methode Europese formaat
	public String getDatumInEuropeesFormaat(){
		return String.format("%d/%d/%d", 
				calender.get(Calendar.DAY_OF_MONTH), calender.get(Calendar.MONTH)+1, calender.get(Calendar.YEAR));
	}
	
	// kleinerDan methode
	public boolean kleinerDan(DatumGregCal d) {
		if (d.getCalender().getTimeInMillis() < this.getCalender().getTimeInMillis()) {
			return true;
		}
		return false;
	}
	
	// verschil In Jaren methode
	public int verschilInJaren(DatumGregCal d) {
		double MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		double MILLIS_IN_YEAR = 1000 * 60 * 60 * 24 * 365.25;
		int verschilInJaren = 0;
		double dagenInMilis;

		dagenInMilis = (verschilInDagen(d) * MILLIS_IN_DAY);
		verschilInJaren = (int) (dagenInMilis / MILLIS_IN_YEAR);
				
		return verschilInJaren;
	}
	
	// verschil in maanden methode
	public int verschilInMaanden(DatumGregCal d) {
		int verschilInMaanden = 0;
		
		verschilInMaanden = verschilInJaren(d) * 12;
		
		return verschilInMaanden;
	}
	
	// verschil in dagen methode
	public int verschilInDagen(DatumGregCal d) {  
		 int MILLIS_IN_DAY = 1000 * 60 * 60 * 24; 
		 DatumGregCal startDate;
		 DatumGregCal endDate;
		 
		 if (this.kleinerDan(d)) {
			startDate = d;
			endDate = this;
		 }else {
			startDate = this;
			endDate = d;
		 }
		 
		 long endInstant = endDate.getCalender().getTimeInMillis();
		 int presumedDays = (int) ((endInstant - startDate.getCalender().getTimeInMillis()) / MILLIS_IN_DAY);
		 Calendar cursor = (Calendar) startDate.getCalender().clone();
		 cursor.add(Calendar.DAY_OF_YEAR, presumedDays);
		 long instant = cursor.getTimeInMillis();
		 if (instant == endInstant)  
			  return presumedDays;  
		 final int step = instant < endInstant ? 1 : -1;  
		 do {  
			 cursor.add(Calendar.DAY_OF_MONTH, step);  
			 presumedDays += step;  
			} while (cursor.getTimeInMillis() != endInstant);  
		 return presumedDays;
	}
	
	// verander datum methode
	public void veranderDatum(int aantalDagen){
		calender.add(Calendar.DAY_OF_MONTH, aantalDagen);
	}
	
	// verander datum methode met een DatumGregCal als return waarde
	public DatumGregCal veranderDatum2(int aantalDagen) {
		DatumGregCal tempDatumGregCal = new DatumGregCal();
		tempDatumGregCal.calender.add(Calendar.DAY_OF_MONTH, aantalDagen);
		
		return tempDatumGregCal;
	}
	
	@Override
	public int compareTo(DatumGregCal o) {
		final int BEFORE = -1;
		final int  EQUAL = 0;
		final int AFTER = 1;
		
		if(this == o) return EQUAL;
		
		if (this.kleinerDan(o)) return BEFORE;
		return AFTER;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((calender == null) ? 0 : calender.hashCode());
		result = prime * result + Arrays.hashCode(namenMaand);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatumGregCal other = (DatumGregCal) obj;
		if (calender == null) {
			if (other.calender != null)
				return false;
		} else if (!calender.equals(other.calender))
			return false;
		if (!Arrays.equals(namenMaand, other.namenMaand))
			return false;
		return true;
	}
	
	//toString methode
		@Override
		public String toString(){
			return String.format("%d %s %d", 
					calender.get(Calendar.DAY_OF_MONTH), namenMaand[calender.get(Calendar.MONTH)], calender.get(Calendar.YEAR));
		}
	
}
