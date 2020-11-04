package com.example.iq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Password = "passKey";
    SharedPreferences sharedpreferences;
    EditText et1, et2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn = (Button) findViewById(R.id.button2);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String val = sharedpreferences.getString(Name, null);
        if (val != null) {
            Intent i = new Intent(getApplicationContext(), HomeScreen.class);
            i.putExtra("Name", val);
           startActivity(i);
        }
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String name = et1.getText().toString();
                String pass = et2.getText().toString();
                if (name.equals("") || pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "login details Empty.!", Toast.LENGTH_LONG).show();
                    return;
                }
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, name);
                editor.putString(Password, pass);
                editor.commit();
                Intent i = new Intent(getApplicationContext(), HomeScreen.class);
                i.putExtra("Name", name);
                startActivity(i);
            }
        });
    }
}




