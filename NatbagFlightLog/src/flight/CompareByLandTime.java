package flight;

import java.util.Comparator;

public class CompareByLandTime implements Comparator<Flight>{

	@Override
	public int compare(Flight o1, Flight o2) {
		if(o1.getLandTime().isBefore(o2.getLandTime()))
			return 1;
		if(o2.getLandTime().isBefore(o1.getLandTime()))
			return -1;
		return 0;
	}

}
