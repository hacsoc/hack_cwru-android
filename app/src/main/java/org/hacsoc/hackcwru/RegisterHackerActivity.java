package org.hacsoc.hackcwru;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.hacsoc.hackcwru.api.ResponseHandler;
import org.hacsoc.hackcwru.api.UserAPI;
import org.hacsoc.hackcwru.model.User;

public class RegisterHackerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_hacker);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hacker Register");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_hacker, menu);
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

    public void registerHacker(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_text_field_hacker);
        EditText schoolField = (EditText) findViewById(R.id.school_text_field_hacker);
        EditText emailField = (EditText) findViewById(R.id.email_text_field_hacker);
        EditText passwordField = (EditText) findViewById(R.id.password_text_field_hacker);
        EditText confirmPasswordField = (EditText) findViewById(R.id.confirm_password_text_field_hacker);

        User user = new User();
        user.setName(nameField.getText().toString());
        user.setInstitution(schoolField.getText().toString());
        user.setEmail(emailField.getText().toString());
        user.setPassword(passwordField.getText().toString());
        user.setPasswordConfirmation(confirmPasswordField.getText().toString());
        user.setMentor(false);
        user.setStaff(false);

        UserAPI.create(user, view.getContext(), new ResponseHandler<User>() {
            @Override
            public void responseReceived(User result) {
                Log.d("User", result.toString());
            }
        });
    }
}
