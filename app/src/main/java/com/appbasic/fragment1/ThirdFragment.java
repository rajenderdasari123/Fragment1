package com.appbasic.fragment1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdFragment extends Fragment {

    View view;
    RadioGroup radiosexgroup;
    private RadioButton radioSexButton;
    Button btn_save;
static String sexvalue;
TextView previousvalues;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_third, container, false);
        radiosexgroup = (RadioGroup) view.findViewById(R.id.radioSex);
        btn_save=(Button)view.findViewById(R.id.btn_save);
        previousvalues=(TextView)view.findViewById(R.id.previousvalues);
        previousvalues.setText(MainActivity.totaldata);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radiosexgroup.getCheckedRadioButtonId();
                radioSexButton = (RadioButton) view.findViewById(selectedId);
                sexvalue= (String) radioSexButton.getText();
                MainActivity.totaldata=MainActivity.totaldata+"\n"+sexvalue;
                Toast.makeText(getActivity(),
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
