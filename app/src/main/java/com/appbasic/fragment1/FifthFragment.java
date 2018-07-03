package com.appbasic.fragment1;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.appbasic.fragment1.FirstFragment;
import com.appbasic.fragment1.R;

import java.util.Calendar;

public class FifthFragment extends Fragment {

    View view;
    Button btn_save;
    TextView previousvalues;
    String datevalue;
    private int mYear, mMonth, mDay, mHour, mMinute;
private Button selectdate;
    int years;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fifth, container, false);
        btn_save = (Button) view.findViewById(R.id.btn_save);
        previousvalues = (TextView) view.findViewById(R.id.previousvalues);
        previousvalues.setText(MainActivity.totaldata);
        selectdate=(Button)view.findViewById(R.id.selectdate);

        selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                Log.d("nnn",""+"c.y"+mYear+"c.m"+mMonth+"c.d"+mDay);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                               // datevalue=dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                                 years=mYear-year;
                                datevalue=""+years;
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousvalues.setText(MainActivity.totaldata+"\n"+datevalue);
            }
        });
        return view;
    }

}
