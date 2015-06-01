package org.hacsoc.hackcwru;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Anno on 6/1/2015.
 */
public class AnnouncementArrayAdapter extends ArrayAdapter<Announcement> {

    private final ArrayList<Announcement> announcements;
    private final Context context;

    public AnnouncementArrayAdapter(Context context, ArrayList<Announcement> announcements) {
        super(context, -1, announcements);
        this.context = context;
        this.announcements = announcements;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = inflater.inflate(R.layout.announcement, parent, false);
        TextView title = (TextView) item.findViewById(R.id.announcement_title);
        TextView text = (TextView) item.findViewById(R.id.announcement_content);
        ImageView icon = (ImageView) item.findViewById(R.id.announcement_icon);
        title.setText(announcements.get(position).getTitle());
        text.setText(announcements.get(position).getAnnouncement());
        return item;
    }

}
