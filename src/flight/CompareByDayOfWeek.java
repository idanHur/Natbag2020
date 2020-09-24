package flight;

import java.util.Comparator;

public class CompareByDayOfWeek implements Comparator<Flight>{


	
	public int compare(Flight o1, Flight o2) {
		if(o1.getScheduledDate().getDayOfWeek().ordinal() > o2.getScheduledDate().getDayOfWeek().ordinal())
			return 1;
		if(o1.getScheduledDate().getDayOfWeek().ordinal() < o2.getScheduledDate().getDayOfWeek().ordinal())
			return -1;
		return 0;
	}

}
