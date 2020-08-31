package flight;

import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

public class Airport {
	Vector<Flight> landings;
	Vector<Flight> departures;
	Vector<Flight> requestedFlights;
	String airportName;
	
	public Airport () {
		landings = new Vector<Flight>();
		departures = new Vector<Flight>();
		requestedFlights = new Vector<>();
		airportName = "Natbag";
	}
	
	public Airport (Scanner scan) {
		landings = new Vector<Flight>();
		departures = new Vector<Flight>();
		airportName = "Natbag";
		int numOfDeparture = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < numOfDeparture; i++) {
			departures.add(new Flight(scan));
		}
		int numOFLandings = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < numOFLandings; i++) {
			landings.add(new Flight(scan));
		}
	}
	
	public void save(PrintWriter pw) {
		pw.println(departures.size());
		for (int i = 0; i < departures.size(); i++) {
			departures.get(i).save(pw); 
		}
		pw.println(landings.size());
		for (int j = 0; j < landings.size(); j++) {
			landings.get(j).save(pw);
		}
		
	}
	public boolean addDeparture(String airLine , String flightNum, int terminal, String depTime, String country, String city, String airport) {
		departures.add(new Flight(airLine, flightNum, terminal, depTime, country, city, airport));
		return true;
	}
	public boolean addLanding(String airLine , String numFlight, int terminal, String depTime, String country, String city, String airport) {
		landings.add(new Flight(airLine, numFlight, terminal, depTime, country, city, airport));
		return true;
	}
public void byRequierment(String direction,String country,String city,String airport,String airline,String dateStart,String dateEnd ,boolean sunday,boolean monday,boolean tuesday,boolean wednesday,boolean thursday,boolean friday,boolean saturday) {
	requestedFlights.clear();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu"); 
	LocalDate startDate = LocalDate.parse(dateStart, formatter);
	LocalDate endDate = LocalDate.parse(dateEnd, formatter);
	if (direction.equalsIgnoreCase("departures")) {
		for (Flight flight : departures ) {
			if ((country == null || flight.getCountry().equalsIgnoreCase(country)) && (city == null ||flight.getCity().equalsIgnoreCase(city))) {
				if ((airport == null || flight.getAirport().equalsIgnoreCase(airport)) && (airline == null || flight.getAirlineName().equalsIgnoreCase(airline))) {
					if ((dateStart == null && endDate == null) || (flight.getScheduledDate().toLocalDate().isBefore(endDate) && flight.getScheduledDate().toLocalDate().isAfter(startDate))) {
						if (!sunday && !monday && !tuesday && !wednesday && !thursday && !friday && !saturday) 
							requestedFlights.add(flight);
						if (sunday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.SUNDAY))
							requestedFlights.add(flight);
						if(monday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.MONDAY))
							requestedFlights.add(flight);
						if(thursday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.THURSDAY))
							requestedFlights.add(flight);
						if (wednesday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) 
							requestedFlights.add(flight);
						if(tuesday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.TUESDAY))
							requestedFlights.add(flight);
						if(friday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.FRIDAY))
							requestedFlights.add(flight);
						if(saturday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.SATURDAY))
							requestedFlights.add(flight);
					}
				}
			}
		}
	}
	if (direction.equalsIgnoreCase("landings")) {
		for (Flight flight : landings ) {
			if ((country == null || flight.getCountry().equalsIgnoreCase(country)) && (city == null ||flight.getCity().equalsIgnoreCase(city))) {
				if ((airport == null || flight.getAirport().equalsIgnoreCase(airport)) && (airline == null || flight.getAirlineName().equalsIgnoreCase(airline))) {
					if ((dateStart == null && endDate == null) || (flight.getScheduledDate().toLocalDate().isBefore(endDate) && flight.getScheduledDate().toLocalDate().isAfter(startDate))) {
						if (!sunday && !monday && !tuesday && !wednesday && !thursday && !friday && !saturday) 
							requestedFlights.add(flight);
						if (sunday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.SUNDAY))
							requestedFlights.add(flight);
						if(monday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.MONDAY))
							requestedFlights.add(flight);
						if(thursday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.THURSDAY))
							requestedFlights.add(flight);
						if (wednesday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) 
							requestedFlights.add(flight);
						if(tuesday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.TUESDAY))
							requestedFlights.add(flight);
						if(friday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.FRIDAY))
							requestedFlights.add(flight);
						if(saturday && flight.getScheduledDate().getDayOfWeek().equals(DayOfWeek.SATURDAY))
							requestedFlights.add(flight);
					}
				}
			}
		}
	}
	
	}
public String htmlFormate(String direction) {
	requestedFlights.sort(new CompareByScheduledTime());
	return new HtmlFormate().stringValue(this, direction);
}
public String textFormate(String direction) {
	requestedFlights.sort(new CompareByScheduledTime());
	return new TextFormate().stringValue(this, direction);
}
	
	
	
	
/*	public String toStringDeparturesByDepTime(String date) {
		StringBuffer str = new StringBuffer();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDateTime dateGiven = LocalDateTime.parse(date, formatter);
		SortByDepTime();
		for (Flight flight : departures) {
			if (flight.getDepartureDate().equals(dateGiven)) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String toStringLandingsByDepTime(String date) {
		StringBuffer str = new StringBuffer();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu"); // add exeption??
		LocalDateTime dateGiven = LocalDateTime.parse(date, formatter);
		SortByDepTime();
		for (Flight flight : landings) {
			if (flight.getDepartureDate().equals(dateGiven)) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String toStringDeparturesBylandTime(String date) {
		StringBuffer str = new StringBuffer();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu"); // add exeption??
		LocalDateTime dateGiven = LocalDateTime.parse(date, formatter);
		SortByLandTime();
		for (Flight flight : departures) {
			if (flight.getDepartureDate().equals(dateGiven)) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String toStringLandingsBylandTime(String date) {
		StringBuffer str = new StringBuffer();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu"); // add exeption??
		LocalDateTime dateGiven = LocalDateTime.parse(date, formatter);
		SortByLandTime();
		for (Flight flight : landings) {
			if (flight.getDepartureDate().equals(dateGiven)) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String toStringByAirline(String airline) {
		StringBuffer str = new StringBuffer();
		for (Flight flight : departures) {
			if (flight.getAirlineName().equalsIgnoreCase(airline)) {
				str.append(flight.toString()+"\n");
			}
		}
		for (Flight flight : landings) {
			if (flight.getAirlineName().equalsIgnoreCase(airline)) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}

	public String toStringLandingsByOrgine(String orgine) {
		StringBuffer str = new StringBuffer();
		for (Flight flight : landings) {
			if (flight.getOrgin().equalsIgnoreCase(orgine)) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String toStringDeparturesByDest(String destanation) {
		StringBuffer str = new StringBuffer();
		for (Flight flight : departures) {
			if (flight.getOrgin().equalsIgnoreCase(destanation)) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	
	public String flightId(int flightNum) {
		StringBuffer str = new StringBuffer();
		for (Flight flight : departures) {
			if (flight.getNumFlight() == flightNum) {
				str.append(flight.toString()+"\n");
			}
		}
		for (Flight flight : landings) {
			if (flight.getNumFlight() == flightNum) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String depToStringFromDateToDate(String From, String To) {
		StringBuffer str = new StringBuffer();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu"); // add exeption??
		LocalDateTime dateFrom = LocalDateTime.parse(From, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(To, formatter);
		departures.sort(new CompareByLandTime());
		for (Flight flight : departures) {
			if (flight.getDepartureDate().isAfter(dateFrom) && flight.getDepartureDate().isBefore(dateTo)) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String landToStringFromDateToDate(String From, String To) {
		StringBuffer str = new StringBuffer();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu"); // add exeption??
		LocalDateTime dateFrom = LocalDateTime.parse(From, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(To, formatter);
		landings.sort(new CompareByLandTime());
		for (Flight flight : landings) {
			if (flight.getDepartureDate().isAfter(dateFrom) && flight.getDepartureDate().isBefore(dateTo)) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String toStringInDays(DayOfWeek day1, DayOfWeek day2, DayOfWeek day3, DayOfWeek day4, DayOfWeek day5, DayOfWeek day6, DayOfWeek day7) {
		StringBuffer str = new StringBuffer();
		for (Flight flight : departures) {
			if (flight.getDepartureDate().getDayOfWeek().compareTo(day1) == 0 || flight.getDepartureDate().getDayOfWeek().compareTo(day2) == 0 || flight.getDepartureDate().getDayOfWeek().compareTo(day3) == 0 ||
					flight.getDepartureDate().getDayOfWeek().compareTo(day4) == 0 || flight.getDepartureDate().getDayOfWeek().compareTo(day5) == 0 ||flight.getDepartureDate().getDayOfWeek().compareTo(day6) == 0 ||
					flight.getDepartureDate().getDayOfWeek().compareTo(day7) == 0) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String toStringLandByDayOfWeek(DayOfWeek day) {
		StringBuffer str = new StringBuffer();
		landings.sort(new CompareByDayOfWeek());
		for (Flight flight : landings) {
			if (flight.getDepartureDate().getDayOfWeek().compareTo(day) == 0) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	}
	public String toStringDepByDayOfWeek(DayOfWeek day) {
		StringBuffer str = new StringBuffer();
		departures.sort(new CompareByDayOfWeek());
		for (Flight flight : departures) {
			if (flight.getDepartureDate().getDayOfWeek().compareTo(day) == 0) {
				str.append(flight.toString()+"\n");
			}
		}
		return str.toString();
	
	}
	public void SortByCompanyName() {
		landings.sort(new CompareByCompanyName());
		departures.sort(new CompareByCompanyName());
	}
	public void SortByDepTime() {
		landings.sort(new CompareByDepTime());
		departures.sort(new CompareByDepTime());
	}
	public void SortByLandTime() {
		landings.sort(new CompareByLandTime());
		departures.sort(new CompareByLandTime());
	}
	public void SortByOrgin() {
		landings.sort(new CompareByOrgin());
		departures.sort(new CompareByOrgin());
	}
	public void SortByDestanation() {
		landings.sort(new CompareByDestanation());
		departures.sort(new CompareByDestanation());
	}
	
	
	
	
	
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(airportName + " airport \n");
		str.append("landings: \n");
		if(landings.size() > 0)
			for (int i = 0; i < landings.size(); i++) {
				str.append(landings.get(i).toString()+"\n");
			}
		str.append("departures: \n");
		if(departures.size() > 0)
			for (int i = 0; i < departures.size(); i++) {
				str.append(departures.get(i).toString()+"\n");
			}
		return str.toString();
	}*/

}
