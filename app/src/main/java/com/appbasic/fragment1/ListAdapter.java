package com.appbasic.fragment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 2159 on 02-05-2018.
 */

public class ListAdapter extends BaseAdapter {
    Context mainActivity;
    List<Student> getlatlngs1;
    private static LayoutInflater inflater = null;
    /*   public ListAdapter(Context mainActivity, List<Student> getlatlngs1, int width, int height) {
           this.mainActivity=mainActivity;
           this.getlatlngs1=getlatlngs1;
           this.width=width;
           this.height=height;
           inflater = (LayoutInflater)mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       }
   */
    String string;
    String string1;
    String string2;
    String string3;
    int width;
    int height;

    public ListAdapter(Context mainActivity, String string, String string1, String string2, String string3, int width, int height) {
        this.mainActivity = mainActivity;
        this.string = string;
        this.string1 = string1;
        this.string = string;
        this.string2 = string2;
        this.string3 = string3;
        inflater = (LayoutInflater)mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return string1.length();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.item, null);

        TextView idtext = (TextView) vi.findViewById(R.id.idtext);
        TextView nametext = (TextView) vi.findViewById(R.id.nametext);
        TextView agetext = (TextView) vi.findViewById(R.id.agetext);
        TextView occupationtxt = (TextView) vi.findViewById(R.id.occupationtxt);

        Student getlatlng22 = getlatlngs1.get(i);

        idtext.setText("id:" + string);
        nametext.setText("name:  " + string1);
        agetext.setText("age:  " + string2);
        occupationtxt.setText("occupation: " + string3);


        return vi;
    }
}
