package utils;

/**
 * @author Pulinx Davy
 * @version 2.0
 */

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatumGregCal {
	
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
	
	//toString methode
	@Override
	public String toString(){
		return String.format("%d %s %d", 
				calender.get(Calendar.DAY_OF_MONTH), namenMaand[calender.get(Calendar.MONTH)], calender.get(Calendar.YEAR));
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
	
	public boolean kleinerDan(DatumGregCal d) {
		return true;
	}
	
}
