package map.google.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText name;
    EditText email;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        //MODE_WORLD_READABLE, MODE_WORLD_WRITEABLE, MODE_MULTI_PROCESS, MODE_APPEND

//        if (sharedpreferences.contains(Name)) {
//            name.setText(sharedpreferences.getString(Name, ""));
//        }
//        if (sharedpreferences.contains(Email)) {
//            email.setText(sharedpreferences.getString(Email, ""));
//
//        }
//
    }

    public void Save(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(Name, n);
        editor.putString(Email, e);

        editor.commit();
    }

    public void clear(View view) {
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);

        name.setText("");
        email.setText("");

    }

    public void Get(View view) {
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
    }

}


