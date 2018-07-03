package com.appbasic.fragment1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment {

    View view;
    Button btn_save;
    EditText edit_sal;
    static String sllaryvalue;
TextView previousvalues;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);
        btn_save = (Button) view.findViewById(R.id.btn_save);
        edit_sal = (EditText) view.findViewById(R.id.edit_sal);
        previousvalues=(TextView)view.findViewById(R.id.previousvalues);
        previousvalues.setText(MainActivity.totaldata);



        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 sllaryvalue = edit_sal.getText().toString();
                 MainActivity.totaldata=MainActivity.totaldata+"\n"+edit_sal.getText().toString();
            }
        });
        return view;
    }
}