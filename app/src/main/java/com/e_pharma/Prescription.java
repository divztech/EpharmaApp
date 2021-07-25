package com.e_pharma;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.Random;



public class Prescription extends AppCompatActivity {
    EditText ptid;
    FirebaseDatabase rootNode1;
    DatabaseReference ref1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        Spinner mySpinner= (Spinner)findViewById(R.id.spinner);
        ArrayAdapter myAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.names,
                R.layout.my_spinner);
        //ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(Prescription.this,
             //   android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.names));
        //myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter(myAdapter);


       // hspid = (EditText) findViewById(R.id.hid_field);
        ptid = (EditText) findViewById(R.id.no_field);
        Button pButton = (Button) findViewById(R.id.nextbutton);
        Button vButton = (Button) findViewById(R.id.backbutton2);
        String __medpckg = null;
// String _medpckg;
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ps1 = (new Intent(Prescription.this, pharmacy.class));
              //  Intent ps2 = (new Intent(Prescription.this, pharmacy.class));

                String _medpckg= mp(__medpckg);
               // String __hspid = hspid.getEditableText().toString().trim();
                String __ptid= ptid.getEditableText().toString().trim();
                rootNode1 = FirebaseDatabase.getInstance();
                ref1 = rootNode1.getReference("Pharmacy/ETable");
                Query checkUser1 = ref1.orderByChild("MedPckg").equalTo(_medpckg);
                checkUser1.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot sd) {
                        if(sd.exists()){
                            ptid.setError(null);
                            String systempt = sd.child(_medpckg).child("PTID").getValue(String.class);
                            if (systempt.equals(__ptid) ){

                                Toast.makeText(getApplicationContext(), "Details Matched", Toast.LENGTH_SHORT).show();
                                    startActivity(ps1);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Check input", Toast.LENGTH_SHORT).show();
                            }
                        }}
                    @Override
                    public void onCancelled( DatabaseError error) {
                        Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            private String mp(String medpckg) {
                String m=medpckg;
                Random rand=new Random();
                int a=rand.nextInt(3);
                if(a==0)
                {
// __medpckg="MP108";
                    m="MP102";
                }
                else if(a==1)
                {
                    m="MP102";
                }
                else if(a==2)
                {
                    m="MP102";
                }
                return m;
            }



        });
    }
}
