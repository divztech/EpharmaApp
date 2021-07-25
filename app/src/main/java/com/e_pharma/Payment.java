package com.e_pharma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Random;

public class Payment extends AppCompatActivity {
    EditText adrs,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        adrs = (EditText) findViewById(R.id.address_field);

;

        TabLayout tabLayout=findViewById(R.id.tablayout);
        TabItem tabEWallet=findViewById(R.id.ewallet);
        TabItem tabCard=findViewById(R.id.card);
        TabItem tabCod=findViewById(R.id.cod);
        ViewPager viewPager=findViewById(R.id.viewPager);

      //  Bundle bundle = this.getArguments();
       // String pf = bundle.getString("passfield");
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(myAdapter);
        String addr = null;
        String address= adr(addr);
        adrs.setText(address);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            private TabLayout.Tab tab;

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        Button vButton = (Button) findViewById(R.id.confirmbutton2);
        vButton.setOnClickListener(new View.OnClickListener() {
           /* EditText e=findViewById(R.id.ph_field);
            EditText cn=findViewById(R.id.cn_field);
            EditText ex=findViewById(R.id.exp_field1);
            EditText cv=findViewById(R.id.cvv_field2);
            String cn1= String.valueOf(cn.getText());
            String cv1= String.valueOf(cv.getText());
            String ex1= String.valueOf(ex.getText());
            String e1= String.valueOf(e.getText());*/
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(Payment.this, pharmacy.class));
              /*  if((cn1==null && cv1==null  && ex1==null) || e1==null){//card
                    Toast.makeText(getApplicationContext(),"Please fill in details", Toast.LENGTH_SHORT).show();}

                else{*/

                // if(pf.length()>8) {
                     Toast.makeText(getApplicationContext(), "Payment successful", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(Payment.this, signout.class));
                     // }
                 //}
            }
        });
        Button uButton = (Button) findViewById(R.id.backbutton4);
        uButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Payment.this, login.class));
            }
        });


    }

    private String adr(String addr) {
        String ad = addr;
        //String p=ph;
        Random rand = new Random();
        int a = rand.nextInt(3);
        if (a == 0) {
// __medpckg="MP108";
            ad = "Flat no.319,Jazira Building, Deira, Dubai";
            // p="0501242452";
        } else if (a == 1) {
            ad = "House no.34C,Uptown Mirdiff, Mirdiff, Dubai";
            // p="0504325265";
        } else if (a == 2) {
            ad = "Flat No. 801,Al Hamara Bldg,Al Khan,Sharjah";
            //  p="0563432624";
        }
        return ad;
    }
}
