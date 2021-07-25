package com.e_pharma;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class EWallet extends Fragment {

    public EWallet() {
        // Required empty public constructor
    }

    EditText ew, pass;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.fragment_e_wallet, container, false);
        ew = (EditText) view.findViewById(R.id.exp_field1);
        pass = (EditText) view.findViewById(R.id.p_field);
        //Editable passfield=pass.getText();

       /* Bundle bundle = new Bundle();
        //String name = "Transporter";
        bundle.putString("passfield", passfield.toString());
        Payment pay = new Payment();
        pay.setArguments(bundle);*/

        String ewid = null;
        //String ph=null;

        String ewt = mp(ewid);
        //onStart();
        ew.setText(ewt);
        // ew.setText("pls set");

        //return inflater.inflate(R.layout.fragment_e_wallet, container, false);
        EditText pa = (EditText) view.findViewById(R.id.p_field);

        pa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                //startActivity(new Intent(Payment.this, pharmacy.class));
              /*  if((cn1==null && cv1==null  && ex1==null) || e1==null){//card
                    Toast.makeText(getApplicationContext(),"Please fill in details", Toast.LENGTH_SHORT).show();}

                else{*/

                // if(pf.length()>8) {
                Toast.makeText(view.getContext(), "E-Wallet choosen as mode of payment", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(Payment.this, signout.class));
                // }
                //}
            }

        });
        return view;
    }

   /* public void onStart() {
        super.onStart();
        ew.setText(null);
    }*/


        // String __medpckg = null;

        public String mp (String ewid){
            String e = ewid;
            //String p=ph;
            Random rand = new Random();
            int a = rand.nextInt(3);
            if (a == 0) {
// __medpckg="MP108";
                e = "EW12452574";
                // p="0501242452";
            } else if (a == 1) {
                e = "EW42452370";
                // p="0504325265";
            } else if (a == 2) {
                e = "EW52149340";
                //  p="0563432624";
            }
            return e;
        }
    }

