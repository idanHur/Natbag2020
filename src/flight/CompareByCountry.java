package flight;


import java.util.Comparator;

public class CompareByCountry implements Comparator<Flight>{

	
	public int compare(Flight o1, Flight o2) {
		return o1.getCountry().compareTo(o2.getCountry());
	}
	
}
