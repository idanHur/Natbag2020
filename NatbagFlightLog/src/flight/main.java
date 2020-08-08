package flight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		int choice = 1;
		Airport port = new Airport();
		HardCoded(port);
		System.out.println(port.departures.get(0).getDepartureDate().getDayOfWeek());
		while (choice != 0) {
			showMenu();
			choice = scan.nextInt();
			if(choice != 0 && options(port, choice, scan))
				System.out.println("action has been preformed");
			
		
		}
		System.out.println("have a good day");
		scan.close();
		
		

	}

public static void showMenu() {
	System.out.println("1:  add flight");
    System.out.println("2:  show departure in date");
    System.out.println("3:  show Landings in date");
    System.out.println("4:  show airport ");
    System.out.println("5:  show flights between two dates (dd/mm/yyyy)");
    System.out.println("6:  show by airline");
    System.out.println("7:  show departures by destanation");
    System.out.println("8: show landings by orgin");
    System.out.println("9: show flights in days");
    System.out.println("10.save to file");
    System.out.println("11.load from file");
    
	
	System.out.println("0: to exit");
}
	
	
public static boolean addFlight (Airport port,Scanner scan) {
	System.out.println("press:\n 1 to add a departure flight \n2 to add landing flight");
	int kindOfFlight = scan.nextInt(); 
	switch (kindOfFlight) {
	case 1:
		System.out.println("name of airline");
		String airLine = scan.next();
		System.out.println("flight number:");
		int numFlight = scan.nextInt();
		System.out.println("terminal number:");
		int terminal = scan.nextInt();
		scan.nextLine();
		System.out.println("departure time: (dd/MM/uuuu HH:mm)");
		String depTime = scan.nextLine();
		System.out.println("landing time: (dd/MM/uuuu HH:mm)");
		String landTime = scan.nextLine();
		System.out.println("destanation of flight: ");
		String destination = scan.nextLine();
		port.addDeparture(airLine, numFlight, terminal, depTime, landTime, destination);
		return true;
	case 2:
		System.out.println("name of airline");
		String airLineL = scan.next();
		System.out.println("flight number:");
		int numFlightL = scan.nextInt();
		System.out.println("terminal number:");
		int terminalL = scan.nextInt();
		scan.nextLine();
		System.out.println("departure time: (dd/MM/uuuu HH:mm)");
		String depTimeL = scan.nextLine();
		System.out.println("landing time: (dd/MM/uuuu HH:mm)");
		String landTimeL = scan.nextLine();
		System.out.println("orgine of flight: ");
		String orginL = scan.next();
		port.addLanding(airLineL, numFlightL, terminalL, depTimeL, landTimeL, orginL);
		return true;

	default:
		System.out.println("you presed a wrong key try agine");
		return false;
	}
		

	}

public static boolean options(Airport port,int action, Scanner scan) throws FileNotFoundException {
	
	String temp1;
	String temp2;
	switch (action) {
	case 1:
		return addFlight(port, scan);
		
	case 2:
		System.out.println("please enter date: ");
		temp1 = scan.nextLine();
		System.out.println(port.toStringDeparturesByDepTime(temp1));
		return true;
	case 3: 
		System.out.println("please enter date: ");
		temp1 = scan.nextLine();
		System.out.println(port.toStringLandingsByDepTime(temp1));
		return true;
	case 4:
		System.out.println(port.toString());
		return true;
	case 5:
		System.out.println("press 1 for landings or 2 for departures");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			System.out.println("please enter date from: ");
			temp1 = scan.nextLine();
			System.out.println("please enter date to: ");
			temp2 = scan.nextLine();
			System.out.println(port.landToStringFromDateToDate(temp1, temp2));
			return true;
		case 2:
			System.out.println("please enter date from: ");
			temp1 = scan.nextLine();
			System.out.println("please enter date to: ");
			temp2 = scan.nextLine();
			System.out.println(port.depToStringFromDateToDate(temp1, temp2));
			return true;

		default:
			break;
		}
		break;
	case 6:
		System.out.println("please enter airline name: ");
		String airline = scan.nextLine();
		System.out.println(port.toStringByAirline(airline));
		return true;
	case 7:
		System.out.println("please enter destanation: ");
		temp1 = scan.next();
		System.out.println(port.toStringDeparturesByDest(temp1));
		return true;
	case 8:
		System.out.println("please enter orgin: ");
		temp1 = scan.next();
		System.out.println(port.toStringLandingsByOrgine(temp1));
		return true;
	case 9:
		System.out.println("press 1.Departures 2.Landings");
		int choise1 = scan.nextInt();
		ShowByDayOfWeek(choise1, port, scan);
		return true;
	case 10:
		PrintWriter pw = new PrintWriter(new File("C:\\Example\\Natbag.txt"));
		port.save(pw);
		pw.close();
		return true;
	case 11:
		Scanner s = new Scanner(new File("C:\\Example\\Natbag.txt"));
		port = new Airport(s);
		s.close();
		return true;

	default:
		return false;
	}
	return false;
	
}
private static void ShowByDayOfWeek(int Choice,Airport port,Scanner scan) {
	switch (Choice) {
	case 1:
		System.out.println("please 1.Sunday \n2.Monday \n3.Tuesday \n4.Wednesday \n5.Thursday \n6.Friday \n7.Saturday");
		int day = scan.nextInt();
		System.out.println(port.toStringDepByDayOfWeek(DayOfWeek(day)));
		break;
	case 2:
		System.out.println("please 1.Sunday \n2.Monday \n3.Tuesday \n4.Wednesday \n5.Thursday \n6.Friday \n7.Saturday");
		int day1 = scan.nextInt();
		System.out.println(port.toStringLandByDayOfWeek(DayOfWeek(day1)));
		break;

	default:
		break;
	}
}
private static void HardCoded(Airport port) {
	port.addDeparture("ElAl", 1904, 3, "12/06/2020 14:00", "13/06/2020 08:00", "Rome");
	port.addLanding("KLM", 7856, 3, "21/05/2020 18:50", "22/05/2020 00:20", "London");

}
private static DayOfWeek DayOfWeek(int day) {
	switch (day) {
	case 1:
		return DayOfWeek.SUNDAY;
	case 2:
		return DayOfWeek.MONDAY;
	case 3:
		return DayOfWeek.TUESDAY;
	case 4:
		return DayOfWeek.WEDNESDAY;
	case 5:
		return DayOfWeek.THURSDAY;
	case 6:
		return DayOfWeek.FRIDAY;
	case 7:
		return DayOfWeek.SATURDAY;

	default:
		return null;
	}
	
}
	
}
