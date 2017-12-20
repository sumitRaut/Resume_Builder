package com.raut.swapnil.resume_builder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Skills_Awards extends AppCompatActivity implements View.OnClickListener {

    EditText skill_1, skill_2, skill_3;
    EditText award_1, award_2, award_3;
    Button save_button;
    ArrayList<String> skill_array, personal_array, education_array, experience_array;
    Pdf_format_1 pdf;
    Database_Personal data_personl;
    EditText name, mobile, email_id, dob, age, address, language, hobbies;
    static int is_saveClicked;
    SharedPreferences pref;

    Toolbar toolbar;
    CollapsingToolbarLayout collapsetoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_skills);

        toolbar = (Toolbar)findViewById(R.id.toolbar_skills);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsetoolbar = (CollapsingToolbarLayout)findViewById(R.id.collapse_skills);
        collapsetoolbar.setTitle("Skills And Achievements");
        collapsetoolbar.setExpandedTitleColor(Color.parseColor("#ffffff"));
        collapsetoolbar.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));

        data_personl = new Database_Personal(this, "library", null, 100);
        skill_1 = (EditText) findViewById(R.id.skill_1);
        skill_2 = (EditText) findViewById(R.id.skill_2);
        skill_3 = (EditText) findViewById(R.id.skill_3);
        award_1 = (EditText) findViewById(R.id.award_1);
        award_2 = (EditText) findViewById(R.id.award_2);
        award_3 = (EditText) findViewById(R.id.award_3);

        save_button = (Button) findViewById(R.id.next_skill);

        skill_array = new ArrayList<String>();
        personal_array = new ArrayList<String>();
        education_array = new ArrayList<String>();
        experience_array = new ArrayList<String>();

        save_button.setOnClickListener(this);

////////////////////////////////////////////////////////////////////////////////////////
        /*LayoutInflater inflater = getLayoutInflater();
        View personal_view = inflater.inflate(R.layout.activity_personal__details, null);

        name = (EditText) personal_view.findViewById(R.id.name);
        mobile = (EditText) personal_view.findViewById(R.id.mobile_no);
        email_id = (EditText) personal_view.findViewById(R.id.email_id);
        dob = (EditText) personal_view.findViewById(R.id.dob);
        age = (EditText) personal_view.findViewById(R.id.age);
        address = (EditText) personal_view.findViewById(R.id.address);
        language = (EditText) personal_view.findViewById(R.id.language);
        hobbies = (EditText) personal_view.findViewById(R.id.hobbies);*/

        pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        if (is_saveClicked == 1) {
            //enable_false();
        }
        get_shared_pref();
    }

    @Override
    public void onClick(View view) {
        //System.out.println("printing id"+view.getId());
        switch (view.getId()) {

            case R.id.next_skill:
                set_shared_pref();
              //  enable_false();
                /*skill_array.add(0, skill_1.getText().toString());
                skill_array.add(1, skill_2.getText().toString());
                skill_array.add(2, skill_3.getText().toString());
                skill_array.add(3, award_1.getText().toString());
                skill_array.add(4, award_2.getText().toString());
                skill_array.add(5, award_3.getText().toString());

                System.out.println("Printing array in Skill:" + skill_array.get(0));

                personal_array.add(0, name.getText().toString());
                personal_array.add(1, mobile.getText().toString());
                personal_array.add(2, email_id.getText().toString());
                personal_array.add(3, dob.getText().toString());
                personal_array.add(4, age.getText().toString());
                personal_array.add(5, address.getText().toString());
                personal_array.add(6, language.getText().toString());
                personal_array.add(7, hobbies.getText().toString());


                System.out.println("//////////////////////////////////////////////////////////////////////");
                data_personl.readValues();

                pdf = new Pdf_format_1(skill_array, personal_array);
                pdf.create_pdf();
*/
                //Intent i =new Intent(Skills_Awards.this, Personal_Details.class);
                //startActivity(i);
                break;
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
          //      enable_true();
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

    private void set_shared_pref() {
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("skill_1", skill_1.getText().toString());  // Saving string
        editor.putString("skill_2", skill_2.getText().toString());  // Saving string
        editor.putString("skill_3", skill_3.getText().toString());  // Saving string
        editor.putString("award_1", award_1.getText().toString());  // Saving string
        editor.putString("award_2", award_2.getText().toString());  // Saving string
        editor.putString("award_3", award_3.getText().toString());  // Saving string
        editor.commit(); // commit changes

        System.out.println(pref.getString("hobby", null));
        System.out.println(pref.getString("language", null));
        System.out.println(pref.getString("age", null));
    }


    private void get_shared_pref() {
        String skill_1_pref= pref.getString("skill_1", "");
        String skill_2_pref = pref.getString("skill_2", "");
        String skill_3_pref = pref.getString("skill_3", "");
        String award_pref_1 = pref.getString("award_1", "");
        String award_pref_2 = pref.getString("award_2", "");
        String award_pref_3 = pref.getString("award_3", "");

        skill_1.setText(skill_1_pref);
        skill_2.setText(skill_2_pref);
        skill_3.setText(skill_3_pref);
        award_1.setText(award_pref_1);
        award_2.setText(award_pref_2);
        award_3.setText(award_pref_3);
    }


    private void enable_true() {
        skill_1.setEnabled(true);
        skill_2.setEnabled(true);
        skill_3.setEnabled(true);
        award_1.setEnabled(true);
        award_2.setEnabled(true);
        award_3.setEnabled(true);
    }

    private void enable_false() {
        skill_1.setEnabled(false);
        skill_2.setEnabled(false);
        skill_3.setEnabled(false);
        award_1.setEnabled(false);
        award_2.setEnabled(false);
        award_3.setEnabled(false);
    }
}