package flight;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Flight {
	private String numFlight;
	private String airlineName;
	private int terminalNum;
	private LocalDateTime scheduledDate;
	private String country;
	private String airport;
	private String city;
	
	
	
	public Flight (String airLine , String flightNum, int terminal, String depTime, String country, String city, String airport) {
		setAirlineName(airLine);
		setTerminalNum(terminal);
		this.numFlight = flightNum;
		setScheduledDate(depTime);
		setCity(city);
		setCountry(country);
		setAirport(airport);
	}
	
	public Flight (Scanner scan) {
        setAirlineName(scan.nextLine());
        String temp = scan.nextLine();
        int tempInt = Integer.parseInt(temp);
		setTerminalNum(tempInt);
	    temp = scan.nextLine();
		this.numFlight = temp;
		setScheduledDate(scan.nextLine());
		setCity(scan.nextLine());
		setCountry(scan.nextLine());
	}
	
	public void save(PrintWriter pw) {
		pw.println(airlineName);
		pw.println(terminalNum);
		pw.println(numFlight);
		String depH = ""+ scheduledDate.getHour();
		if (scheduledDate.getHour() < 10) 
			depH = "0"+ scheduledDate.getHour();
		
		String depM = ""+ scheduledDate.getMinute();
		if (scheduledDate.getMinute() < 10) 
			depM = "0"+ scheduledDate.getMinute();
		
		String depDay = ""+ scheduledDate.getDayOfMonth();
		if (scheduledDate.getDayOfMonth() < 10)
			depDay = "0" +scheduledDate.getDayOfMonth();
		String depMonth = "" +scheduledDate.getMonthValue();
		if (scheduledDate.getMonthValue() < 10 )
			depMonth = "0"+scheduledDate.getMonthValue();
		pw.println(depDay +"/"+depMonth+"/"+scheduledDate.getYear()+" "+ depH+":"+depM);
		pw.println(city);
		pw.println(country);
	}


	public String getAirlineName() {
		return airlineName;
	}


	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public int getTerminalNum() {
		return terminalNum;
	}

	public void setTerminalNum(int terminalNum) {
		this.terminalNum = terminalNum;
	}
	public String getScheduledDateInString() {
		StringBuffer str = new StringBuffer();
	
		if (scheduledDate.getDayOfMonth() < 10) {
			str.append("0" +scheduledDate.getDayOfMonth());
		}else {
			str.append(""+ scheduledDate.getDayOfMonth());
		}
		str.append("/");
		if (scheduledDate.getMonthValue() < 10 ) {
			str.append("0"+scheduledDate.getMonthValue());
		}else {
			str.append("" +scheduledDate.getMonthValue());
		}
		str.append("/");
		str.append(scheduledDate.getYear() + " ");
		if (scheduledDate.getHour() < 10) { 
			str.append("0"+ scheduledDate.getHour());
		}else {
			str.append(""+ scheduledDate.getHour());
		}
		str.append(":");
	
		if (scheduledDate.getMinute() < 10) {
			str.append("0"+ scheduledDate.getMinute());
		}else {
			str.append(""+ scheduledDate.getMinute());
		}
		return str.toString();
	
	}
	

	

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

	public LocalDateTime getScheduledDate() {
		return scheduledDate;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNumFlight() {
		return numFlight;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public void setScheduledDate(String Date) {
		if (Date.length() == 0) {
			return;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm"); // add exeption??
		this.scheduledDate = LocalDateTime.parse(Date, formatter);
	}
	
	public String toString() {
		return "Airline Name: " +airlineName+" flight number: "+numFlight+" terminal: "+terminalNum;
	}

}
