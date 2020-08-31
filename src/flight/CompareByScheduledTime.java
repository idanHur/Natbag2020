package flight;

import java.util.Comparator;

public class CompareByScheduledTime implements Comparator<Flight>{

	@Override
	public int compare(Flight o1, Flight o2) {
		if(o1.getScheduledDate().isBefore(o2.getScheduledDate()))
			return 1;
		if(o2.getScheduledDate().isBefore(o1.getScheduledDate()))
			return -1;
		return 0;
	}
	

}
