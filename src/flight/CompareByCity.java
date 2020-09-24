package flight;

import java.util.Comparator;

public class CompareByCity implements Comparator<Flight>{

	
	public int compare(Flight o1, Flight o2) {
		return o1.getCity().compareTo(o2.getCity());
	}
	

}
