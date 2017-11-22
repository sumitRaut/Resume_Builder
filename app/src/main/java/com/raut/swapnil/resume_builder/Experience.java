package com.raut.swapnil.resume_builder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Experience extends AppCompatActivity implements View.OnClickListener {
    static int is_saveClicked;
    EditText company_1, company_2, company_3;
    EditText  year_1,year_2,year_3;
    Button save;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);


        ActionBar bar = getSupportActionBar();
        bar.setTitle("Professional Experience");

        company_1 = (EditText) findViewById(R.id.company_name_1);
        company_2 = (EditText) findViewById(R.id.company_name_2);
        company_3 = (EditText) findViewById(R.id.company_name_3);
        year_1 = (EditText) findViewById(R.id.experience_years_1);
        year_2 = (EditText) findViewById(R.id.experience_years_2);
        year_3 = (EditText) findViewById(R.id.experience_years_3);

        save = (Button) findViewById(R.id.save_button);
        pref = getSharedPreferences("MyPref", MODE_PRIVATE);

        save.setOnClickListener(this);

        if (is_saveClicked == 1) {
            //enable_false();
        }
        get_shared_pref();
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
          //      enable_true();
            default:
                finish();
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
            case R.id.save_button:
                set_shared_pref();
            //    enable_false();
                is_saveClicked = 1;

                /*i = new Intent(Experience.this, Skills_Awards.class);
                startActivity(i);*/
                break;
        }
    }

    private void set_shared_pref() {
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("company_1", company_1.getText().toString());  // Saving string
        editor.putString("company_2", company_2.getText().toString());  // Saving string
        editor.putString("company_3", company_3.getText().toString());  // Saving string
        editor.putString("experience_year_1", year_1.getText().toString());  // Saving string
        editor.putString("experience_year_2", year_2.getText().toString());  // Saving string
        editor.putString("experience_year_3", year_3.getText().toString());  // Saving string
        editor.commit(); // commit changes

        System.out.println(pref.getString("hobby", null));
        System.out.println(pref.getString("language", null));
        System.out.println(pref.getString("age", null));
    }


    private void get_shared_pref() {
        String company_pref_1 = pref.getString("company_1", "");
        String company_pref_2 = pref.getString("company_2", "");
        String company_pref_3 = pref.getString("company_3", "");
        String year_pref_1 = pref.getString("experience_year_1", "");
        String year_pref_2 = pref.getString("experience_year_2", "");
        String year_pref_3 = pref.getString("experience_year_3", "");

        company_1.setText(company_pref_1);
        company_2.setText(company_pref_2);
        company_3.setText(company_pref_3);
        year_1.setText(year_pref_1);
        year_2.setText(year_pref_2);
        year_3.setText(year_pref_3);
    }


    private void enable_true() {
        company_1.setEnabled(true);
        company_2.setEnabled(true);
        company_3.setEnabled(true);
        year_1.setEnabled(true);
        year_2.setEnabled(true);
        year_3.setEnabled(true);
    }

    private void enable_false() {
        company_1.setEnabled(false);
        company_2.setEnabled(false);
        company_3.setEnabled(false);
        year_1.setEnabled(false);
        year_2.setEnabled(false);
        year_3.setEnabled(false);
    }
}
