package org.hacsoc.hackcwru.gson.adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Adapter to serialize and deserialize JSON Strings to Calendar objects.
 *
 * Created by andrew on 6/8/15.
 */
public class CalendarAdapter extends TypeAdapter<Calendar>
                             implements JsonSerializer<Calendar>,
                                        JsonDeserializer<Calendar> {

    private static final Gson gsonHandle = new GsonBuilder().create();
    private static final TypeAdapter<Date> dateTypeAdapter = gsonHandle.getAdapter(Date.class);
    // Dates are being sent in iso8601 format.
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);

    /**
     * {@inheritDoc}
     */
    @Override
    public Calendar deserialize(JsonElement json,
                                Type type,
                                JsonDeserializationContext context) throws JsonParseException {
        Date date;
        try {
            date = format.parse(json.getAsString());
        } catch (ParseException e) {
            return null;
        }
        return calendarFromDate(date);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonElement serialize(Calendar calendar,
                                 Type type,
                                 JsonSerializationContext context) {
        if (calendar == null) {
            return null;
        }

        JsonObject jsonObject = new JsonObject();
        // TODO: Not sure about $date being the property name.
        jsonObject.addProperty("$date", format.format(calendar));
        return jsonObject;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(JsonWriter out, Calendar value) throws IOException {
        dateTypeAdapter.write(out, value.getTime());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calendar read(JsonReader in) throws IOException {
        Date date;
        try {
            date = format.parse(in.nextString());
        } catch (ParseException e) {
            return null;
        }
        return calendarFromDate(date);
    }

    /**
     * Convert a Date to a Calendar object.
     *
     * @param date The input date.
     * @return The Calendar object representing date.
     */
    private Calendar calendarFromDate(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }
}
