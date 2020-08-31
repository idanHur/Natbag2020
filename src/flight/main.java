package flight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		Airport port = new Airport();
		HardCoded(port);
		if (args.length > 0) {
		String dateStart = "";
		String dateEnd = "";
		if(args[6].isEmpty() || args[7].isEmpty() || args[8].isEmpty()) {
			dateStart = null;
		}
		else {
			dateStart = makeDate(args[6], args[7], args[8]);
		}
		if(args[9].isEmpty() || args[10].isEmpty() || args[11].isEmpty()) {
			dateEnd = null;
		}
		else {
			dateEnd = makeDate(args[9], args[10], args[11]);
		}
		boolean sunday = Boolean.parseBoolean(args[12]);
		boolean monday = Boolean.parseBoolean(args[13]);
		boolean tuesday = Boolean.parseBoolean(args[14]);
		boolean wednesday = Boolean.parseBoolean(args[15]);
		boolean thursday = Boolean.parseBoolean(args[16]);
		boolean friday = Boolean.parseBoolean(args[17]);
		boolean saturday = Boolean.parseBoolean(args[18]);
		
		port.byRequierment(args[1], args[3], args[4], args[5], args[2], dateStart, dateEnd, sunday, monday, tuesday, wednesday, thursday, friday, saturday);
		boolean isHtml = args[0].equalsIgnoreCase("html");
		if (isHtml) {
			System.out.println(port.htmlFormate(args[1]));
		}else {
			System.out.println(port.textFormate(args[1]));
		}
		}else {
			options(port);
		}
		
		
		
	}

	private static void HardCoded(Airport port) {
		port.addDeparture("ElAl", "LY895", 3, "14/05/2020 12:00", "Germany", "Frankfurt", "FRA");
		port.addLanding("KLM", "KL6754", 3, "12/05/2020 10:00", "Netherlands", "Amsterdam", "AMS");
		port.addLanding("Ameraits", "AM7657", 3, "20/08/2020 09:00", "United Arab Emirates", "Dubai", "DXB");
		port.addLanding("Arkia", "AR8762", 1, "20/06/2020 18:00", "Israel", "Eilat", "ETH");
		port.addDeparture("US Airlines", "UA8109", 3, "12/06/2020 23:00", "United States", "New york", "LGA");
		port.addDeparture("Arkia", "AR9072", 1, "15/09/2020 10:00", "Israel", "Eilat", "ETH");
	}
	
	private static String makeDate (String days,String month,String year) {
		String str = "";
		if (days.length() < 2) {
			str += "0"+days +"/";
		}else {
			str += days+"/";
		}
		if (month.length() < 2) {
			str += "0"+month +"/";
		}else {
			str += month+"/";
		}
		str += year;
		return str;
	}
	public static void showMenu() {
		System.out.println("1:  add flight");
	    System.out.println("2:  show departure in date");
	    System.out.println("3:  show Landings in date");
	    System.out.println("4:  show airport ");
	    System.out.println("5:  show flights between two dates (dd/mm/yyyy)");
	    System.out.println("6:  show by airline");
	    System.out.println("7:  show departures by countey");
	    System.out.println("8: show landings by countey");
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
			scan.next();
			String numFlight = scan.nextLine();
			System.out.println("terminal number:");
			int terminal = scan.nextInt();
			scan.nextLine();
			System.out.println("departure time: (dd/MM/uuuu HH:mm)");
			String depTime = scan.nextLine();
			System.out.println("country of flight:");
			String country = scan.nextLine();
			System.out.println("city of flight: ");
			String city = scan.next();
			System.out.println("airport code: ");
			scan.next();
			String airport = scan.nextLine();
			port.addDeparture(airLine, numFlight, terminal, depTime, country, city, airport);
			return true;
		case 2:
			System.out.println("name of airline");
			String airLineL = scan.next();
			System.out.println("flight number:");
			scan.next();
			String numFlightL = scan.nextLine();
			System.out.println("terminal number:");
			int terminalL = scan.nextInt();
			scan.nextLine();
			System.out.println("departure time: (dd/MM/uuuu HH:mm)");
			String depTimeL = scan.nextLine();
			System.out.println("country of flight:");
			String countryL = scan.nextLine();
			System.out.println("city of flight: ");
			String cityL = scan.next();
			System.out.println("airport code: ");
			scan.next();
			String airportL = scan.nextLine();
			port.addLanding(airLineL, numFlightL, terminalL, depTimeL, countryL, cityL, airportL);
			return true;

		default:
			System.out.println("you presed a wrong key try agine");
			return false;
		}
			

		}

	public static boolean options(Airport port) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		String temp1;
		String temp2;
		int choiceMain;
		do{
			showMenu();
			choiceMain = scan.nextInt();
			switch (choiceMain) {
			case 1:
				addFlight(port, scan);
				break;
				
			case 2:
				System.out.println("please enter date: ");
				scan.next();
				temp1 = scan.nextLine();
				System.out.println(port.toStringDeparturesByScedualTime(temp1));
				break;
			case 3: 
				System.out.println("please enter date: ");
				scan.next();
				temp1 = scan.nextLine();
				System.out.println(port.toStringLandingsByScedualTime(temp1));
				break;
			case 4:
				System.out.println(port.toString());
				break;
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
					break;
				case 2:
					System.out.println("please enter date from: ");
					temp1 = scan.nextLine();
					System.out.println("please enter date to: ");
					temp2 = scan.nextLine();
					System.out.println(port.depToStringFromDateToDate(temp1, temp2));
					break;

				default:
					break;
				}
				break;
			case 6:
				System.out.println("please enter airline name: ");
				String airline = scan.nextLine();
				System.out.println(port.toStringByAirline(airline));
				break;
			case 7:
				System.out.println("please enter country: ");
				temp1 = scan.next();
				System.out.println(port.toStringDeparturesByCountry(temp1));
				break;
			case 8:
				System.out.println("please enter country: ");
				temp1 = scan.next();
				System.out.println(port.toStringLandingsByCountry(temp1));
				break;
			case 9:
				System.out.println("press 1.Departures 2.Landings");
				int choise1 = scan.nextInt();
				ShowByDayOfWeek(choise1, port, scan);
				break;
			case 10:
				PrintWriter pw = new PrintWriter(new File("Natbag"));
				port.save(pw);
				pw.close();
				break;
			case 11:
				Scanner s = new Scanner(new File("Natbag"));
				port.setFromFile(s);
				s.close();
				break;

			default:
				break;
			}
		
		}while (choiceMain != 0); 
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