package com.appbasic.fragment1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FourthFragment extends Fragment implements
        AdapterView.OnItemSelectedListener {

    View view;
    Button btn_save;
    TextView previousvalues;
    String[] designation={"Java","Android",".Net","Php","C++"};
static String designationvalue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fourth, container, false);
        btn_save = (Button) view.findViewById(R.id.btn_save);
        previousvalues = (TextView) view.findViewById(R.id.previousvalues);
       // previousvalues.setText(FirstFragment.namevalue + "/" + SecondFragment.sllaryvalue + "/" + ThirdFragment.sexvalue);
previousvalues.setText(MainActivity.totaldata);
        Spinner spinner=(Spinner)view.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,designation);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),designation[position] , Toast.LENGTH_LONG).show();
        designationvalue=designation[position];
        MainActivity.totaldata=MainActivity.totaldata+"\n"+designationvalue;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
