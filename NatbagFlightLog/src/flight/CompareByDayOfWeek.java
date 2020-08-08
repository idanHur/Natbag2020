package flight;

import java.util.Comparator;

public class CompareByDayOfWeek implements Comparator<Flight>{


	@Override
	public int compare(Flight o1, Flight o2) {
		if(o1.getDepartureDate().getDayOfWeek().ordinal() > o2.getDepartureDate().getDayOfWeek().ordinal())
			return 1;
		if(o1.getDepartureDate().getDayOfWeek().ordinal() < o2.getDepartureDate().getDayOfWeek().ordinal())
			return -1;
		return 0;
	}

}
