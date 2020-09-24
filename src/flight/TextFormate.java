package flight;

public class TextFormate extends Formate{


	@Override
	protected String headerSTring() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	protected String eachFlightString(Flight each,String direction) {
		StringBuffer str = new StringBuffer();
		str.append("Airline: " +each.getAirlineName());
		str.append(", Flight number: "+each.getNumFlight());
		if (direction.equalsIgnoreCase("departures")) {
			str.append(", Departing to: "+each.getCity());
			str.append(", Departure time: "+each.getScheduledDateInString());
		}
		if (direction.equalsIgnoreCase("landings")) {
			str.append(", Coming from: "+each.getCity());
			str.append(", Arrival time: "+each.getScheduledDateInString());
		}
		str.append(", Terminal: " +each.getTerminalNum() +"\n");
		return str.toString();
	}

	@Override
	protected String footerString() {
		// TODO Auto-generated method stub
		return "";
	}

}
