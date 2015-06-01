package org.hacsoc.hackcwru;

import java.util.Date;

/**
 * Created by Anno on 6/1/2015.
 */
public class Announcement {

    public static enum Type {
        FOOD, TECHTALK, GENERAL, EMERGENCY;
    }

    private int id;
    private String title;
    private String announcement;
    private Date postTime;
    private Type type;

    public Announcement(int id, String title, String announcement, Date postTime, Type type) {
        this.id = id;
        this.title = title;
        this.announcement = announcement;
        this.postTime = postTime;
        this.type = type;
    }

    public Date getPostTime() {
        return postTime;
    }

    public String getTitle() {
        return title;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

}
