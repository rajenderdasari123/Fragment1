package com.appbasic.fragment1;

import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SqliteActivity extends AppCompatActivity {

    EditText id, name, age, occupation;
    Button insert, update, delete, viewall;
    Sqlitedatabase sqlitdb;
    private ListView listview;
    private ListAdapter adapter;
   static int width,height;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        DisplayMetrics dmm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dmm);
        width=dmm.widthPixels;
        height=dmm.heightPixels;

        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.name);
        occupation = (EditText) findViewById(R.id.name);

        insert = (Button) findViewById(R.id.insert);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        viewall = (Button) findViewById(R.id.viewall);
        sqlitdb = new Sqlitedatabase(this);
        listview=(ListView)findViewById(R.id.listview);



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean insertbool = sqlitdb.insert(id.getText().toString(), name.getText().toString(), age.getText().toString(), occupation.getText().toString());

                if (insertbool == true)
                    Toast.makeText(getApplicationContext(), "inserted succesfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "inserted fail ", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean updatebool = sqlitdb.update(id.getText().toString(), name.getText().toString(), age.getText().toString(), occupation.getText().toString());

                if (updatebool == true)
                    Toast.makeText(getApplicationContext(), "updated succesfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "updated fail ", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletebool = sqlitdb.delete(id.getText().toString());

                if (deletebool > 0)
                    Toast.makeText(getApplicationContext(), "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Data not Deleted", Toast.LENGTH_LONG).show();
            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur = sqlitdb.getAlldata();
                StringBuffer sb=new StringBuffer();
                while (cur.moveToNext()){
                    sb.append("id:" + cur.getString(0) + "\n");
                    sb.append("name: " + cur.getString(1) + "\n");
                    sb.append("age: " + cur.getString(2) + "\n");
                    sb.append("occupation: " + cur.getString(3) + "\n");
                    Log.d("data"," "+cur.getString(0));

                    adapter = new ListAdapter(getApplicationContext(),cur.getString(0),cur.getString(1),cur.getString(2),cur.getString(3),width, height);
                    listview.setAdapter(adapter);
                }




             /*   Student student = new Student();
                student.setId(cur.getString(0));
                student.setName(cur.getString(1));
                student.setAge(cur.getString(2));
                student.setOccupation(cur.getString(3));
                Util.getlatlngs1.add(student);
                adapter = new ListAdapter(getApplicationContext(), Util.getlatlngs1, width, height);
                listview.setAdapter(adapter);*/
            }
        });


    }
}
