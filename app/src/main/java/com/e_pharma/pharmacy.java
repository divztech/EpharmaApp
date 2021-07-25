package com.e_pharma;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.Random;
import static java.lang.Integer.parseInt;
public class pharmacy extends AppCompatActivity {
    TextView prsf;
    TextView mnf,mnf1,mnf2,mq1,mq2,mq3,mc1,mc2,mc3,af;
    FirebaseDatabase rootNode2;
    DatabaseReference ref2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);
        prsf = (TextView) findViewById(R.id.prescrip_field);
        mnf= (TextView) findViewById(R.id. medi_field);
        String __medpckg = null;
//tButton = (Button) findViewById(R.id.nextbutton4);
        mnf2= (TextView) findViewById(R.id. medi_field3);
        mnf1= (TextView) findViewById(R.id. medi_field2);
        String _medpckg = mp(__medpckg);
        mq1=(TextView)findViewById(R.id.qty1_field);
        mq2=(TextView)findViewById(R.id.qty2_field2);
        mq3=(TextView)findViewById(R.id.qty3_field3);
        mc1=(TextView)findViewById(R.id.cost1_field);
        mc2=(TextView)findViewById(R.id.cost2_field2);
        mc3=(TextView)findViewById(R.id.cost3_field3);
        af=(TextView)findViewById(R.id.amount_field);
        rootNode2 = FirebaseDatabase.getInstance();
        ref2 = rootNode2.getReference("Pharmacy/ETable");
        Query checkUser2 = ref2.orderByChild("MedPckgNo").equalTo(_medpckg);
        checkUser2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot sd) {
                if (sd.exists()) {
                    String _medn1 = sd.child(_medpckg).child("MEDN1").getValue(String.class);
                    mnf.setText(_medn1);
                    String _medn2 = sd.child(_medpckg).child("MEDN2").getValue(String.class);
                    mnf1.setText(_medn2);
                    String _medn3 = sd.child(_medpckg).child("MEDN3").getValue(String.class);
                    mnf2.setText(_medn3);
                    String _medq1=sd.child(_medpckg).child("MEDQ1").getValue(String.class);
                    mq1.setText(_medq1);
                    String _medq2=sd.child(_medpckg).child("MEDQ2").getValue(String.class);
                    mq2.setText(_medq2);
                    String _medq3=sd.child(_medpckg).child("MEDQ3").getValue(String.class);
                    mq3.setText(_medq3);
                    String _medc1=sd.child(_medpckg).child("MEDC1").getValue(String.class);
                    mc1.setText(_medc1);
                    String _medc2=sd.child(_medpckg).child("MEDC2").getValue(String.class);
                    mc2.setText(_medc2);
                    String _medc3=sd.child(_medpckg).child("MEDC3").getValue(String.class);
                    mc3.setText(_medc3);
                   String _medTC=sd.child(_medpckg).child("MEDTC").getValue(String.class);
                    af.setText(_medTC);
                    Toast.makeText(getApplicationContext(), "Details Matched , Prescription Loading", Toast.LENGTH_SHORT).show();
                    String _presno = sd.child(_medpckg).child("PresNo").getValue(String.class);
                    prsf.setText(_presno);
// af.setText("45 AED");
//startActivity(ps2);
                } else {
                    Toast.makeText(getApplicationContext(), "check again", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "wrong ", Toast.LENGTH_SHORT).show();
            }
        });
        Button mButton = (Button) findViewById(R.id.nextbutton4);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pharmacy.this, Payment.class));
            }});
 /*   Button tButton = (Button) findViewById(R.id.genbutton5);
        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//startActivity(new Intent(pharmacy.this, Payment.class));
                String m1= mq1.getText().toString().trim();
                int i= Integer.parseInt(m1);
                String m2= mq2.getText().toString().trim();
                int i2=Integer.parseInt(m2);
                String m3= mq3.getText().toString().trim();
                int i3= Integer.parseInt(m3);
                String c1= mc1.getText().toString().trim();
                String c2= mc1.getText().toString().trim();
                String c3= mc1.getText().toString().trim();
                int j=Integer.parseInt(c1);
                int j1=Integer.parseInt(c2);;
                int j2=Integer.parseInt(c3);;
// int i1 = Integer.parseInt(m1);
                int ij1=i*j;
                int ij2=i2*j1;
                int ij3=i3*j2;
//int z =(i* j)+(i2*j1)+(i3*j2);
// int z2=z;
                int z =ij1+ij2+ij3;
//String z1= String.valueOf(z);
//af.setText(_medTC);
            }
        });
        Button vButton = (Button) findViewById(R.id.backbutton3);
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pharmacy.this, login.class));
            }
        });
// i=Integer.parseInt(m1.replaceAll("[\\D]",""));
/*try {
int i = Integer.parseInt(mq1.getText().toString());
int z = i;//*j+i1*j1+i2*j2;
// int i = 5;
String z1= String.valueOf(z);
// String z1 = Integer.toString(z);
af.setText(z1);
} catch(NumberFormatException e) {
System.out.println("parse value is not valid : " + e);
}*/
/* int i1=Integer.parseInt(mq2.getEditableText().toString().trim());
int i2=Integer.parseInt(mq3.getEditableText().toString().trim());
int j=Integer.parseInt(mc1.getEditableText().toString().trim());
int j1=Integer.parseInt(mc2.getEditableText().toString().trim());
int j2=Integer.parseInt(mc3.getEditableText().toString().trim());*/
    }
    private String mp(String medpckg) {
        String m=medpckg;
        Random rand=new Random();
        int a=rand.nextInt(3);
        if(a==0)
        {
            m="MP109";
        }
        else if(a==1)
        {
            m="MP108";
        }
        else if(a==2)
        {
            m="MP107";
        }
        return m;
    }
}
/* }
});
}
*/