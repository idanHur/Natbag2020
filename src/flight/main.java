package flight;

import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		Airport port = new Airport();
		HardCoded(port);
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

}