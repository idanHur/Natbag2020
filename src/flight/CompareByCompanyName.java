package flight;

import java.util.Comparator;

public class CompareByCompanyName implements Comparator<Flight>{

	
	public int compare(Flight o1, Flight o2) {
		return o1.getAirlineName().compareTo(o2.getAirlineName());
	}
	

	
}
