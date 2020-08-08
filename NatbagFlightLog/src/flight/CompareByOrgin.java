package flight;

import java.util.Comparator;

public class CompareByOrgin implements Comparator<Flight>{

	@Override
	public int compare(Flight o1, Flight o2) {
		return o1.getOrgin().compareTo(o2.getOrgin());
	}
	

}
