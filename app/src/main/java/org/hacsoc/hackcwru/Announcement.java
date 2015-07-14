package org.hacsoc.hackcwru;

import java.util.Calendar;

/**
 * Created by Anno on 6/22/2015.
 */
public class Announcement {

    public final String title;
    public final String description;
    private String timeString;
    private final Calendar start;
    private final Calendar end;

    public Announcement(String title, String description, Calendar start, Calendar end) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        timeString = "";
        if(start != null) {
            timeString = timeString + start.getTime().toString();
        }
        if(end != null) {
            timeString = timeString + " - " + end.getTime().toString();
        }
    }

    public String getTimeString() {
        return timeString;
    }
}
