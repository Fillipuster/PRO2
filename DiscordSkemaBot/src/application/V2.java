package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;

public class V2 {
	
	private static ArrayList<HashMap<String, String>> calendarEntries = new ArrayList<>();

	public static void ReadCalendarFiles(String filePath) throws IOException, ParserException {
		HashMap<String, String> calendarEntry = null;
		FileInputStream fin = new FileInputStream(filePath);
		CalendarBuilder builder = new CalendarBuilder();
		net.fortuna.ical4j.model.Calendar calendar = builder.build(fin);
		for (Iterator i = calendar.getComponents().iterator(); i.hasNext();) {
			Component component = (Component) i.next();
			if (component.getName().equalsIgnoreCase("VEVENT")) {
				calendarEntry = new HashMap<>();
				for (Iterator j = component.getProperties().iterator(); j.hasNext();) {
					net.fortuna.ical4j.model.Property property = (Property) j.next();
					calendarEntry.put(property.getName(), property.getValue());
				}
				calendarEntries.add(calendarEntry);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ReadCalendarFiles("timetable.php");
		
		for (HashMap<String, String> map : calendarEntries) {
			for (String key : map.keySet()) {
				System.out.println(key + " : " + map.get(key));
			}
		}
	}

}
