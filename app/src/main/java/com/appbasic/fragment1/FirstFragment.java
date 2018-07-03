package com.appbasic.fragment1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment {
    View view;
    Button btn_save;
    private EditText edit_name;
static String namevalue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        edit_name = (EditText) view.findViewById(R.id.edit_name);
        btn_save = (Button) view.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 namevalue = edit_name.getText().toString();
                MainActivity.totaldata=edit_name.getText().toString();
            }
        });

        return view;
    }
}