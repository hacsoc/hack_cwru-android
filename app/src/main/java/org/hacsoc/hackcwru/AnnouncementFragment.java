package org.hacsoc.hackcwru;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnnouncementFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnnouncementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnnouncementFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static AnnouncementFragment newInstance(String param1, String param2) {
        AnnouncementFragment fragment = new AnnouncementFragment();
        return fragment;
    }

    public AnnouncementFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        ListView listView = (ListView) view.findViewById(R.id.announcement_listview);
        ArrayList<Announcement> announcements = new ArrayList<>();
        // Test announcements
        announcements.add(new Announcement("Test announcement", "Such test, much wow.  This should be longer than one line I think", Calendar.getInstance(), null));
        announcements.add(new Announcement("Test announcement numer 2", "Such test, much wow.  This should be longer than one line I think but it won't display cause its not number 1", Calendar.getInstance(), null));
        listView.setAdapter(new AnnouncementArrayAdapter(inflater.getContext(), announcements));
        return inflater.inflate(R.layout.fragment_announcement, container, false);
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
