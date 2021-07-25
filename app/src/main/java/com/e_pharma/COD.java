package com.e_pharma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class COD extends Fragment {


    public COD() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater codlf = getActivity().getLayoutInflater();
        View codview = codlf.inflate(R.layout.fragment_cod, container, false);
        return codview;
    }
}