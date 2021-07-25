package com.e_pharma;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
public class login extends AppCompatActivity {
    EditText eid, mrn;
    Button loginbutton;
    FirebaseDatabase rootNode;
    DatabaseReference ref;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
///h
        eid = (EditText) findViewById(R.id.editTextTextPersonName);
        mrn = (EditText) findViewById(R.id.editTextTextPersonName2);
        loginbutton = ((Button) findViewById(R.id.loginbuttonid));
        loginbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent s1 = (new Intent(login.this, TestResults.class));




                String _eid = eid.getEditableText().toString().trim();
                String _mrn = mrn.getEditableText().toString().trim();
//d
                rootNode = FirebaseDatabase.getInstance();
                ref = rootNode.getReference("Pharmacy/ETable");
                Query checkUser = ref.orderByChild("EID").equalTo(_eid);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NotNull DataSnapshot ds) {
                        if (ds.exists()) {
                            eid.setError(null);
                            String sysmmrn = ds.child(_eid).child("MrnNo").getValue(String.class);
                            if (sysmmrn.equals(_mrn)) {
                                mrn.setError(null);


                                //name
                                String _name = ds.child(_eid).child("Name").getValue(String.class);
                                s1.putExtra("Name", _name);
                                String _pn=ds.child(_eid).child("PcrNo").getValue(String.class);
                                s1.putExtra("PcrNo",_pn);


//Age
// String _age= ds.child(_eid).child("Age").getValue(String.class);
// s1.putExtra("Age", _age);
//Area
// String _area= ds.child(_eid).child("Area").getValue(String.class);
// s1.putExtra("Area", _area);
//Building
// String _building= ds.child(_eid).child("Building").getValue(String.class);
// s1.putExtra("Building", _building);
//Dob
// String _dob= ds.child(_eid).child("DOB").getValue(String.class);
// s1.putExtra("DOB", _dob);
//dot
                                String _dot=ds.child(_eid).child("Date_Of_Test").getValue(String.class);
                                s1.putExtra("Date_Of_Test",_dot);
//Emirate
// String _emirate= ds.child(_eid).child("Emirate").getValue(String.class);
//s1.putExtra("Emirate", _emirate);
//hfno
//String _hfno=ds.child(_eid).child("HFNo").getValue(String.class);
// s1.putExtra("HFNo", _hfno);
//hospname
// String _hsn=ds.child(_eid).child("HospitalName").getValue(String.class);
// s1.putExtra("HospitalName", _hsn);
//hospid
                                // String _hspid=ds.child(_eid).child("HspID").getValue(String.class);
                                //s1.putExtra("HspID", _hspid);
//PatientID
                                // String _ptid=ds.child(_eid).child("PTID").getValue(String.class);
                                //s1.putExtra("PTID", _ptid);
//phoneno
//String _phone= ds.child(_eid).child("Phone").getValue(String.class);
// s1.putExtra("Phone",_phone);
//prescriptionno
// String _prsno= ds.child(_eid).child("PresNo").getValue(String.class);
// s1.putExtra("PresNo",_prsno);
//results
                                String _results = ds.child(_eid).child("Results").getValue(String.class);
                                s1.putExtra("Results", _results);
//street
// String _street= ds.child(_eid).child("Street").getValue(String.class);
//s1.putExtra("Street", _street);
//medpckg
                                Toast.makeText(getApplicationContext(), "Details Matched , Test Results Loading", Toast.LENGTH_SHORT).show();
                                startActivity(s1);
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "check input details again", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NotNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}