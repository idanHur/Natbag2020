package flight;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Flight {
	private int numFlight;
	private String airlineName;
	private int terminalNum;
	private LocalDateTime departureDate;
	private LocalDateTime landTime;
	private String orgin;
	private String destanation;
	
	
	
	public Flight (String airLine , int numFlight, int terminal, String depTime, String landTime,String orgin, String destanation) {
		setAirlineName(airLine);
		setTerminalNum(terminal);
		this.numFlight = numFlight;
		setLandTime(landTime);
		setDepartureDate(depTime);
		setOrgin(orgin);
		setDestanation(destanation);
	}
	
	public Flight (Scanner scan) {
		setAirlineName(scan.next());
		setTerminalNum(scan.nextInt());
		this.numFlight = scan.nextInt();
		setLandTime(scan.nextLine());
		setDepartureDate(scan.nextLine());
		setOrgin(scan.nextLine());
		setDestanation(scan.nextLine());
	}
	public void save(PrintWriter pw) {
		pw.println(airlineName);
		pw.println(terminalNum);
		pw.println(numFlight);
		String landH = ""+ landTime.getHour();
		if (landTime.getHour() < 10) 
			landH = "0"+ landTime.getHour();
		
		String landM = ""+ landTime.getMinute();
		if (landTime.getMinute() < 10) 
			landM = "0"+ landTime.getMinute();
		String landDay = ""+ landTime.getDayOfMonth();
		if (landTime.getDayOfMonth() < 10)
			landDay = "0" +landTime.getDayOfMonth();
		String landMonth = "" +landTime.getMonthValue();
		if (landTime.getMonthValue() < 10 )
			landMonth = "0"+landTime.getMonthValue();
		pw.println(landDay +"\\"+landMonth+"\\"+landTime.getYear()+" "+ landH+":"+landM);
		String depH = ""+ departureDate.getHour();
		if (departureDate.getHour() < 10) 
			depH = "0"+ departureDate.getHour();
		
		String depM = ""+ departureDate.getMinute();
		if (departureDate.getMinute() < 10) 
			depM = "0"+ departureDate.getMinute();
		
		String depDay = ""+ departureDate.getDayOfMonth();
		if (departureDate.getDayOfMonth() < 10)
			depDay = "0" +departureDate.getDayOfMonth();
		String depMonth = "" +departureDate.getMonthValue();
		if (departureDate.getMonthValue() < 10 )
			depMonth = "0"+departureDate.getMonthValue();
		pw.println(depDay +"\\"+depMonth+"\\"+departureDate.getYear()+" "+ depH+":"+depM);
		pw.println(orgin);
		pw.println(destanation);
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

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}
	public LocalDateTime getLandTime() {
		return landTime;
	}
	public String getOrgin() {
		return orgin;
	}
	public void setOrgin(String orgin) {
		this.orgin = orgin;
	}
	public String getDestanation() {
		return destanation;
	}
	public void setDestanation(String destanation) {
		this.destanation = destanation;
	}
	public int getNumFlight() {
		return numFlight;
	}
	
	public void setLandTime(String landTime) {
		if (landTime.length() == 0) {
			return;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm"); // add exeption??
		this.landTime = LocalDateTime.parse(landTime.trim(), formatter);
	}
	public void setDepartureDate(String depTime) {
		if (depTime.length() == 0) {
			return;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm"); // add exeption??
		this.departureDate = LocalDateTime.parse(depTime, formatter);
	}
	
	public String toString() {
		return "Airline Name: " +airlineName+" flight number: "+numFlight+" terminal: "+terminalNum;
	}

}
