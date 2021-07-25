package com.e_pharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.prefs.Preferences;

public class TestResults extends AppCompatActivity {
    TextView ptname, ptresults, ptdot,pcfield;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);
        ptname = (TextView) findViewById(R.id.name_field);
        ptresults = (TextView) findViewById(R.id.result_field);
        ptdot = (TextView) findViewById(R.id.dot_field);

        String _pn= getIntent().getStringExtra("PcrNo");
        pcfield =(TextView) findViewById(R.id.pcr_field2);
        //  String _chkpcr = String.valueOf(pcfield.getEditableText());
        String _name = getIntent().getStringExtra("Name");
        String _results = getIntent().getStringExtra("Results");
        String _dot = getIntent().getStringExtra("Date_Of_Test");

        Button vButton = (Button) findViewById(R.id.searchbutton);
        vButton.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           pcfield.setText(_pn);


                                           ptname.setText(_name);
                                           ptresults.setText(_results);
                                           ptdot.setText(_dot);
                                           Button rButton = (Button) findViewById(R.id.Viewbutton);
                                           rButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   if (_results.contentEquals("Positive")) {

                                                       Intent s2 = (new Intent(TestResults.this,Prescription.class));
                                                       startActivity(s2);
                                                   }
                                                   else{
                                                       Toast.makeText(getApplicationContext(),"Prescription unavailable", Toast.LENGTH_SHORT).show();

                                                   }
                                               }

                                           });
                                       }

                                   }
        );

        Button nButton = (Button) findViewById(R.id.backbutton);
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestResults.this, login.class));
            }
        });


    }

}