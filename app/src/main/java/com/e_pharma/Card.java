package com.e_pharma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class Card extends Fragment {


    public Card() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater clf = getActivity().getLayoutInflater();
        View cview = clf.inflate(R.layout.fragment_card, container, false);

        EditText c = (EditText) cview.findViewById(R.id.cvv_field2);

        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View cview) {


                Toast.makeText(cview.getContext(), "Card choosen as mode of payment", Toast.LENGTH_SHORT).show();

            }

        });
        return cview;
    }
}