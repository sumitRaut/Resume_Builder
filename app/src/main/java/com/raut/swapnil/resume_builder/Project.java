package com.raut.swapnil.resume_builder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Project extends AppCompatActivity {

    EditText project_1, project_2, project_3, description_1, description_2, description_3;
    Button save_btn;
    SharedPreferences pref;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsetoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_project);

        toolbar = (Toolbar)findViewById(R.id.toolbar_project);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsetoolbar = (CollapsingToolbarLayout)findViewById(R.id.collapse_project);
        collapsetoolbar.setTitle("Project");
        collapsetoolbar.setExpandedTitleColor(Color.parseColor("#ffffff"));
        collapsetoolbar.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));

        pref = getSharedPreferences("MyPref", MODE_PRIVATE);

        project_1 = (EditText)findViewById(R.id.project_1);
        project_2 = (EditText)findViewById(R.id.project_2);
        project_3 = (EditText)findViewById(R.id.project_3);
        description_1 = (EditText)findViewById(R.id.description_1);
        description_2 = (EditText)findViewById(R.id.description_2);
        description_3 = (EditText)findViewById(R.id.description_3);
        save_btn = (Button)findViewById(R.id.save_project);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_shared_pref();
            }
        });
        get_shared_pref();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), List.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }




    private void set_shared_pref() {
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("project_1", project_1.getText().toString());  // Saving string
        editor.putString("project_2", project_2.getText().toString());  // Saving string
        editor.putString("project_3", project_3.getText().toString());  // Saving string
        editor.putString("description_1", description_1.getText().toString());  // Saving string
        editor.putString("description_2", description_2.getText().toString());  // Saving string
        editor.putString("description_3", description_3.getText().toString());  // Saving string

        editor.commit(); // commit changes
    }


    private void get_shared_pref() {
        String project_pref_1 = pref.getString("project_1", "");
        String project_pref_2 = pref.getString("project_2", "");
        String project_pref_3 = pref.getString("project_3", "");
        String description_pref_1 = pref.getString("description_1", "");
        String description_pref_2 = pref.getString("description_2", "");
        String description_pref_3 = pref.getString("description_3", "");

        project_1.setText(project_pref_1);
        project_2.setText(project_pref_2);
        project_3.setText(project_pref_3);
        description_1.setText(description_pref_1);
        description_2.setText(description_pref_2);
        description_3.setText(description_pref_3);
    }


}
