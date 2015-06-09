package org.hacsoc.hackcwru.model;

import java.util.Calendar;

/**
 * Abstraction of the User model.
 *
 * Created by andrew on 6/9/15.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String institution;
    private boolean mentor;
    private boolean staff;
    /*
     * even though this is Java, the JSON Rails sends uses snake_case, and the
     * variable names need to match exactly for GSON to extract them.
     */
    private Calendar created_at;
    private Calendar updated_at;
}
