package flight;

import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Airport {
	Vector<Flight> landings;
	Vector<Flight> departures;
	String airportName;
	
	public Airport () {
		landings = new Vector<Flight>();
		departures = new Vector<Flight>();
		airportName = "Natbag";
	}
	
	public Airport (Scanner scan) {
		airportName = "Natbag";
		landings = new Vector<Flight>();
		departures = new Vector<Flight>();
		int numOfDeparture = scan.nextInt();
		for (int i = 0; i < numOfDeparture; i++) {
			departures.add(new Flight(scan));
		}
		int numOFLandings = scan.nextInt();
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
	public boolean addDeparture(String airLine , int numFlight, int terminal,String depTime,String landTime, String destination) {
		departures.add(new Flight(airLine, numFlight, terminal, depTime, landTime, airportName, destination));
		return true;
	}
	public boolean addLanding(String airLine , int numFlight, int terminal,String depTime,String landTime,String orgin) {
		landings.add(new Flight(airLine, numFlight, terminal, depTime, landTime, orgin, airportName));
		return true;
	}
	public String toStringDeparturesByDepTime(String date) {
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
		str.append(airportName + "airport \n");
		str.append("landings: \n");
		if(landings.size() > 0)
			for (int i = 0; i < landings.size(); i++) {
				str.append(landings.get(i).toString()+"\n");
			}
		str.append("departures: ");
		if(departures.size() > 0)
			for (int i = 0; i < departures.size(); i++) {
				str.append(departures.get(i).toString()+"\n");
			}
		return str.toString();
	}

}
