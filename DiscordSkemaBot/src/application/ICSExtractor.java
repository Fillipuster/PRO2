package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ICSExtractor {

    private String icsPath;
    private ArrayList<Module> modules;
    private DateTimeFormatter icsDateFormat = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");

    public ArrayList<Module> getModules() {
        return modules;
    }

    public String getICSPath() {
        return icsPath;
    }

    public boolean hasICSPath() {
        if (icsPath != null && icsPath != "") {
            return true;
        } else {
            return false;
        }
    }

    public void setICSPath(String path) {
        icsPath = path;
    }

    public void extract() throws Exception {
        modules = new ArrayList<Module>();

        URL url = new URL(icsPath);

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        int block = -1;
        Module module = new Module(-1);
        while ((inputLine = in.readLine()) != null) {

            if (inputLine.equals("BEGIN:VEVENT")) {
                block++;
                if (module.getID() > -1) {
                    modules.add(module);
                }
                module = new Module(block);
            }

            if (inputLine.substring(0, 7).equalsIgnoreCase("summary")) {

                module.setSummary(inputLine.substring(8, inputLine.length() - 1));

            } else if (inputLine.substring(0, 7).equalsIgnoreCase("dtstart")) {

                String stamp = inputLine.substring(8, inputLine.length() - 1);
                module.setStart(LocalDateTime.parse(stamp, icsDateFormat).plusHours(2));

            } else if (inputLine.substring(0, 5).equalsIgnoreCase("dtend")) {

                String stamp = inputLine.substring(6, inputLine.length() - 1);
                module.setEnd(LocalDateTime.parse(stamp, icsDateFormat).plusHours(2));

            }

        }
        in.close();
    }

}
