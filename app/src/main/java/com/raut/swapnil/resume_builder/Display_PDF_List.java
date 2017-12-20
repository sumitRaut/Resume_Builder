package com.raut.swapnil.resume_builder;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Display_PDF_List extends AppCompatActivity {
    ListView listView;
    ArrayList<Pdf_List> arrayList;
    ArrayAdapter adapter;
    Pdf_format_1 pdf;

    RecyclerView recyclerView;
    Context context;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter recyclerViewAdapter;


    CustomArrayAdapter customArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__pdf__list);

        /****************************************************************************
        //This code works

        /*pdf = new Pdf_format_1();
        listView = (ListView)findViewById(R.id.listView);
        arrayList = pdf.pdf_List();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);*/

        //****************************************************************************

        //      Recyclerview

        pdf = new Pdf_format_1();
        arrayList = pdf.pdf_List();
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        context = getApplicationContext();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new CustomAdapter(context,arrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

//        *****************XML *********************************



        //      Arrayadapter

/*        pdf = new Pdf_format_1();
        listView = (ListView)findViewById(R.id.listview);
        arrayList = pdf.pdf_List();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&I am in display pdf List class");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&I am in display pdf List class");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&I am in display pdf List class");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&I am in display pdf List class");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&I am in display pdf List class");
        pdf.printList(arrayList);
        context = getApplicationContext();
        customArrayAdapter = new CustomArrayAdapter(this,R.layout.row,arrayList);
        listView.setAdapter(customArrayAdapter);*/
    }
}

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    Context context;
    ArrayList<Pdf_List> arrayList;
    View view;
    ViewHolder viewHolder;
    public CustomAdapter(Context context, ArrayList<Pdf_List> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        viewHolder=new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pdf_List pdf_list = arrayList.get(position);

        String name = pdf_list.getPdfName();
        String path = pdf_list.getPdfPath();

        holder.textView.setText(name);

        System.out.println("***************************BindViewHolder******************************");
        System.out.println("Pdf Name::::::"+name);
    }

    @Override
    public int getItemCount() {
        System.out.println("###########################       Size        ###############################");

        System.out.println("Pdf Name::::::"+arrayList.size());

        return arrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        ViewHolder(View itemView)
        {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.textview);
        }
    }

}

