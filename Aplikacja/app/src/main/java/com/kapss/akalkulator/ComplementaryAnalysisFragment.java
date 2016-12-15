package com.kapss.akalkulator;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.andexert.expandablelayout.library.ExpandableLayoutListView;


public class ComplementaryAnalysisFragment extends Fragment {

    public MathConvertLibrary mathConvertLibrary;
    public MathSupportLibrary mathSupportLibrary;

    public ComplementaryAnalysisFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Załaduj MathConvertLibrary i MathSupportLibrary
        mathConvertLibrary = new MathConvertLibrary();
        mathSupportLibrary = new MathSupportLibrary();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_complementary_analysis, container, false);



        return view;
    }

}
