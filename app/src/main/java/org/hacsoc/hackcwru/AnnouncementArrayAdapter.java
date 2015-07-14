package org.hacsoc.hackcwru;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Anno on 6/22/2015.
 */
public class AnnouncementArrayAdapter extends ArrayAdapter<Announcement> {

    private final Context context;
    private final ArrayList<Announcement> announcements;

    public AnnouncementArrayAdapter(Context context, ArrayList<Announcement> announcements) {
        super(context, -1, announcements);
        this.context = context;
        this.announcements = announcements;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = null;
        if(position == 0) {
            item = inflater.inflate(R.layout.announcement_first_highlighted_element, parent, false);
        } else {
            item = inflater.inflate(R.layout.announcement_generic_list_element, parent, false);
        }
        ((TextView) item.findViewById(R.id.announcement_title)).setText(announcements.get(position).title);
        ((TextView) item.findViewById(R.id.announcement_description)).setText(announcements.get(position).description);
        ((TextView) item.findViewById(R.id.announcement_times)).setText(announcements.get(position).description);
        return item;
    }
}
