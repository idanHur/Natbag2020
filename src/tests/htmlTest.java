package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import flight.Airport;

public class htmlTest {

	@Test
	public void test() {
		Airport bilbo = createPort();
		bilbo.byRequiermentAll();
		StringBuffer test = new StringBuffer();
		test.append("<table style=\"height: 87px; width: 576px; border-color: black; background-color: turquoise;\" border=\"2\" cellspacing=\"0\" cellpadding=\"5\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr>\r\n" + 
				"<td style=\"width: 97px;\">Airline</td>\r\n" + 
				"<td style=\"width: 108px;\">Flight number</td>\r\n" + 
				"<td style=\"width: 106.8px;\">Coming from</td>\r\n" + 
				"<td style=\"width: 117.2px;\">Scheduled Time</td>\r\n" + 
				"<td style=\"width: 112px;\">Terminal</td>\r\n" + 
				"</tr>\n");
		test.append("<tr> \n");
		test.append("<td style=\"width: 97px;\">" + "elal" + "</td>\n");
		test.append("<td style=\"width: 108px;\">" + "LY1208" +"</td>\n");
		test.append("<td style=\"width: 106.8px;\">" + "Rome" +" "+"italy" + "</td>\n");
		test.append("<td style=\"width: 117.2px;\">" + "12/06/2020 12:00" + "</td>\n");
		test.append("<td style=\"width: 112px;\">" + "3" + "</td>\n");
		test.append("</tr>\n");
		
		test.append("</tbody>\r\n" + 
				"</table>");
		assertEquals(test.toString(), bilbo.htmlFormate("departures"));
	}
	
	private Airport createPort() {
		Airport bilbo = new Airport();
		bilbo.addDeparture("elal", "LY1208", 3, "12/06/2020 12:00", "italy", "Rome", "FCO");
		return bilbo;
	}

}
