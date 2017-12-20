package com.raut.swapnil.resume_builder;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sumit on 02-12-2017.
 */

class CustomArrayAdapter extends ArrayAdapter<Pdf_List>{
    int resource;
    Context context;
    ArrayList<Pdf_List> arrayList;
    private static LayoutInflater inflater=null;

    public CustomArrayAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Pdf_List> arrayList) {
        super(context, resource);
        this.context = context;
        this.arrayList = arrayList;
        this.resource = resource;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = inflater.inflate(R.layout.row,null);
        ImageView image = (ImageView)row.findViewById(R.id.imageview);
        TextView textView = (TextView)row.findViewById(R.id.textview);

        Pdf_List pdf_list = arrayList.get(position);
        String name = pdf_list.getPdfName();
        String path = pdf_list.getPdfPath();

        System.out.println("PDF Name :" + name);
        textView.setText(name);

        return super.getView(position, convertView, parent);
    }
}
