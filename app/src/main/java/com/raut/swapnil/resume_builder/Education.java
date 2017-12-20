package com.raut.swapnil.resume_builder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Education extends AppCompatActivity implements View.OnClickListener {

    EditText college_name_1, degree_1, branch_1, marks_1, year_1;
    EditText college_name_2, degree_2, branch_2, marks_2, year_2;
    EditText college_name_3, degree_3, branch_3, marks_3, year_3;
    SharedPreferences pref;
    static int education_save;
    Toolbar toolbar;
    CollapsingToolbarLayout collapseToolbar;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_education);

        toolbar = (Toolbar)findViewById(R.id.toolbar_education);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapseToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapse_education);
        collapseToolbar.setTitle("Education");
        collapseToolbar.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));
        collapseToolbar.setExpandedTitleColor(Color.parseColor("#ffffff"));

        pref = getSharedPreferences("MyPref", MODE_PRIVATE);


        college_name_1 = (EditText) findViewById(R.id.college_10th);
        college_name_2 = (EditText) findViewById(R.id.college_12th);
        college_name_3 = (EditText) findViewById(R.id.college_graduation);
        degree_1 = (EditText) findViewById(R.id.degree);
        degree_2 = (EditText) findViewById(R.id.degree_2);
        degree_3 = (EditText) findViewById(R.id.degree_3);
        branch_1 = (EditText) findViewById(R.id.branch);
        branch_2 = (EditText) findViewById(R.id.branch_2);
        branch_3 = (EditText) findViewById(R.id.branch_3);
        marks_1 = (EditText) findViewById(R.id.marks);
        marks_2 = (EditText) findViewById(R.id.marks_2);
        marks_3 = (EditText) findViewById(R.id.marks_3);
        year_1 = (EditText) findViewById(R.id.year);
        year_2 = (EditText) findViewById(R.id.year_2);
        year_3 = (EditText) findViewById(R.id.year_3);

        next = (Button) findViewById(R.id.next_education);
        next.setOnClickListener(this);

        String colleg_name = pref.getString("name","");
        college_name_1.setText(colleg_name);

        get_shared_pref();

        if(education_save == 1)
        {
            //enable_false();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        //menuInflater.inflate(R.menu.edit, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_edit:
                //enable_true();
            default:
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

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.next_education:
              set_shared_pref();
                //enable_false();
                education_save=1;
                /*i = new Intent(Education.this, Experience.class);
                startActivity(i);*/
                break;


        }
    }

    private void set_shared_pref() {
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("college_1", college_name_1.getText().toString());  // Saving string
        editor.putString("college_2", college_name_2.getText().toString());  // Saving string
        editor.putString("college_3", college_name_3.getText().toString());  // Saving string
        editor.putString("degree_1", degree_1.getText().toString());  // Saving string
        editor.putString("degree_2", degree_2.getText().toString());  // Saving string
        editor.putString("degree_3", degree_3.getText().toString());  // Saving string
        editor.putString("branch_2", branch_2.getText().toString());  // Saving string
        editor.putString("branch_3", branch_3.getText().toString());  // Saving string
        editor.putString("marks_1", marks_1.getText().toString());  // Saving string
        editor.putString("marks_2", marks_2.getText().toString());  // Saving string
        editor.putString("marks_3", marks_3.getText().toString());  // Saving string
        editor.putString("year_1", year_1.getText().toString());  // Saving string
        editor.putString("year_2", year_2.getText().toString());  // Saving string
        editor.putString("year_3", year_3.getText().toString());  // Saving string

        editor.commit(); // commit changes

        System.out.println(pref.getString("hobby", null));
        System.out.println(pref.getString("language", null));
        System.out.println(pref.getString("age", null));
    }


    private void get_shared_pref() {
        String college_1_pref = pref.getString("college_1", "");
        String college_2_pref = pref.getString("college_2", "");
        String college_3_pref = pref.getString("college_3", "");
        String degree_1_pref = pref.getString("degree_1", "");
        String degree_2_pref = pref.getString("degree_2", "");
        String degree_3_pref = pref.getString("degree_3", "");
        String branch_2_pref = pref.getString("branch_2", "");
        String branch_3_pref = pref.getString("branch_3", "");
        String marks_1_pref = pref.getString("marks_1", "");
        String marks_2_pref = pref.getString("marks_2", "");
        String marks_3_pref = pref.getString("marks_3", "");
        String year_1_pref = pref.getString("year_1", "");
        String year_2_pref = pref.getString("year_2", "");
        String year_3_pref = pref.getString("year_3", "");

        college_name_1.setText(college_1_pref);
        college_name_2.setText(college_2_pref);
        college_name_3.setText(college_3_pref);
        degree_1.setText(degree_1_pref);
        degree_2.setText(degree_2_pref);
        degree_3.setText(degree_3_pref);
        branch_2.setText(branch_2_pref);
        branch_3.setText(branch_3_pref);
        marks_1.setText(marks_1_pref);
        marks_2.setText(marks_2_pref);
        marks_3.setText(marks_3_pref);
        year_1.setText(year_1_pref);
        year_2.setText(year_2_pref);
        year_3.setText(year_3_pref);
    }



    private void enable_true() {
        college_name_1.setEnabled(true);
        college_name_2.setEnabled(true);
        college_name_3.setEnabled(true);
        degree_1.setEnabled(true);
        degree_2.setEnabled(true);
        degree_3.setEnabled(true);
        branch_2.setEnabled(true);
        branch_3.setEnabled(true);
        marks_1.setEnabled(true);
        marks_2.setEnabled(true);
        marks_3.setEnabled(true);
        year_1.setEnabled(true);
        year_2.setEnabled(true);
        year_3.setEnabled(true);
    }


    private void enable_false() {
            college_name_1.setEnabled(false);
            college_name_2.setEnabled(false);
            college_name_3.setEnabled(false);
            degree_1.setEnabled(false);
            degree_2.setEnabled(false);
            degree_3.setEnabled(false);
            branch_2.setEnabled(false);
            branch_3.setEnabled(false);
            marks_1.setEnabled(false);
            marks_2.setEnabled(false);
            marks_3.setEnabled(false);
            year_1.setEnabled(false);
            year_2.setEnabled(false);
            year_3.setEnabled(false);
    }
}
