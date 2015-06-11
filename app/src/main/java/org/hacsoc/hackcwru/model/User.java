package org.hacsoc.hackcwru.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

/**
 * Abstraction of the User model.
 *
 * Created by andrew on 6/9/15.
 */
public class User {
    private Integer id;
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

    private String password;
    private String passwordConfirmation;

    /**
     * Set the id of this user.
     *
     * @param id
     */
    public void setID(Integer id) {
        this.id = id;
    }

    /**
     * Set the name of this user.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the email of this user.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the institution of this user.
     *
     * @param institution
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * Set the staff parameter of this user.
     *
     * @param staff
     */
    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    /**
     * Set the mentor parameter of this user.
     *
     * @param mentor
     */
    public void setMentor(boolean mentor) {
        this.mentor = mentor;
    }

    /**
     * Set the created_at time of this user.
     *
     * @param created_at
     */
    public void setCreatedAt(Calendar created_at) {
        this.created_at = created_at;
    }

    /**
     * Set the updated_at time of this user.
     *
     * @param updated_at
     */
    public void setUpdatedAt(Calendar updated_at) {
        this.updated_at = updated_at;
    }

    /**
     * Set the password of this user.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set the password confirmation of this user.
     *
     * @param passwordConfirmation
     */
    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    /**
     * Convert this user to a JSONObject for serialization.
     * TODO: add more of the fields to this, or figure out a better way to do it.
     *
     * @return
     */
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        try {
            if (id != null) {
                json.put("id", id);
            }
        } catch (JSONException e) {}
        try {
            if (name != null) {
                json.put("name", name);
            }
        } catch (JSONException e) {}

        return json;
    }
}
