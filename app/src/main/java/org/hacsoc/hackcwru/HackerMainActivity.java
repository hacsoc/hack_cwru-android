package org.hacsoc.hackcwru;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.Date;

import java.util.ArrayList;


public class HackerMainActivity extends ActionBarActivity {

    private ArrayList<String> announcements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacker_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hacker Home");
        ListView listView = (ListView) findViewById(R.id.annoucements_hacker_listview);
        ArrayList<Announcement> announcements = new ArrayList<>();
        announcements.add(new Announcement(1, "Test Announcement", "Free food everywhere", new Date(), Announcement.Type.FOOD));
        AnnouncementArrayAdapter adapter = new AnnouncementArrayAdapter(this, announcements);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hacker_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
