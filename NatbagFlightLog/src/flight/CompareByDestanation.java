package flight;

import java.util.Comparator;

public class CompareByDestanation implements Comparator<Flight>{

	@Override
	public int compare(Flight o1, Flight o2) {
		return o1.getDestanation().compareTo(o2.getDestanation());
	}
	
}
