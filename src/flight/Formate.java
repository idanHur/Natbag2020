package flight;

public abstract class Formate {

	protected abstract String headerSTring();
	protected abstract String eachFlightString(Flight each , String direction);
	protected abstract String footerString();
	
	public String stringValue(Airport port, String direction) {
		StringBuffer result = new StringBuffer(headerSTring());
		
		for (Flight each : port.requestedFlights) {
			result.append(eachFlightString(each,direction));
			System.out.println();
			}
		
		
		result.append(footerString());
		return result.toString();
		
	}

}
