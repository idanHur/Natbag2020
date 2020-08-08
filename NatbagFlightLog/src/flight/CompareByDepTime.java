package flight;

import java.util.Comparator;

public class CompareByDepTime implements Comparator<Flight>{

	@Override
	public int compare(Flight o1, Flight o2) {
		if(o1.getDepartureDate().isBefore(o2.getDepartureDate()))
			return 1;
		if(o2.getDepartureDate().isBefore(o1.getDepartureDate()))
			return -1;
		return 0;
	}
	

}
