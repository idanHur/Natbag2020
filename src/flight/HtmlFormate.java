package flight;

public class HtmlFormate extends Formate{

	

	@Override
	protected String headerSTring() {
		
		return "<table style=\"height: 87px; width: 576px; border-color: black; background-color: turquoise;\" border=\"2\" cellspacing=\"0\" cellpadding=\"5\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr>\r\n" + 
				"<td style=\"width: 97px;\">Airline</td>\r\n" + 
				"<td style=\"width: 108px;\">Flight number</td>\r\n" + 
				"<td style=\"width: 106.8px;\">Coming from</td>\r\n" + 
				"<td style=\"width: 117.2px;\">Scheduled Time</td>\r\n" + 
				"<td style=\"width: 112px;\">Terminal</td>\r\n" + 
				"</tr>\n";
	}

	@Override
	protected String eachFlightString(Flight each, String direction) {
		StringBuffer str = new StringBuffer();
		str.append("<tr> \n");
		str.append("<td style=\"width: 97px;\">" + each.getAirlineName() + "</td>\n");
		str.append("<td style=\"width: 108px;\">" + each.getNumFlight() +"</td>\n");
		str.append("<td style=\"width: 106.8px;\">" + each.getCity() +" "+each.getCountry() + "</td>\n");
		str.append("<td style=\"width: 117.2px;\">" + each.getScheduledDateInString() + "</td>\n");
		str.append("<td style=\"width: 112px;\">" + each.getTerminalNum() + "</td>\n");
		str.append("</tr>\n");
		
		return str.toString();
	}

	@Override
	protected String footerString() {
		return "</tbody>\r\n" + 
				"</table>";
	}
	

}
