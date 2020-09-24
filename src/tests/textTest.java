package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import flight.Airport;

public class textTest {

	@Test
	public void test() {
		StringBuffer str = new StringBuffer();
		Airport temp = createPort();
		temp.byRequiermentAll();
		str.append("Airline: " + "elal");
		str.append(", Flight number: "+"LY1208");
		str.append(", Departing to: "+"Rome");
		str.append(", Departure time: "+"12/06/2020 12:00");
		str.append(", Terminal: " +"3" +"\n");
		assertEquals(str.toString(), temp.textFormate("departures"));
	}

	private Airport createPort() {
		Airport temp = new Airport();
		temp.addDeparture("elal", "LY1208", 3, "12/06/2020 12:00", "italy", "Rome", "FCO");
		return temp;
}
}
