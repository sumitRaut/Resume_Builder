package com.raut.swapnil.resume_builder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Curricular_Activities extends AppCompatActivity {

    EditText activity_1, activity_2;
    Button save_btn;
    SharedPreferences pref;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsetoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_activities);

        toolbar = (Toolbar) findViewById(R.id.toolbar_activities);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsetoolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_activities);
        collapsetoolbar.setTitle("Curricular Activities");
        collapsetoolbar.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));
        collapsetoolbar.setExpandedTitleColor(Color.parseColor("#ffffff"));

        pref = getSharedPreferences("MyPref", MODE_PRIVATE);

        activity_1 = (EditText) findViewById(R.id.extra_activity_1);
        activity_2 = (EditText) findViewById(R.id.extra_activity_2);

        save_btn = (Button) findViewById(R.id.save_activity);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_share_pref();
            }
        });
        get_shared_pref();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){
        Intent intent = new Intent(this, List.class);
        startActivity(intent);
    }


    private void get_shared_pref() {
        String activity_pref_1 = pref.getString("activity_1", "");
        String activity_pref_2 = pref.getString("activity_2", "");

        activity_1.setText(activity_pref_1);
        activity_2.setText(activity_pref_2);
    }

    private void set_share_pref() {
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("activity_1", activity_1.getText().toString());
        editor.putString("activity_2", activity_2.getText().toString());

        editor.commit();
    }
}