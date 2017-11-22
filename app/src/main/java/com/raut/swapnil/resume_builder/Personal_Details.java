package com.raut.swapnil.resume_builder;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Date;

public class Personal_Details extends AppCompatActivity implements View.OnClickListener {

    static int save_btn;
    EditText name, mobile_no, email_id, dob, age, address, language, hobby;
    Button save;
    Database_Personal demo;
    String nameValue, mobileValue, emailValue, dobValue, ageValue, addressValue, languageValue, hobbiesValue;
    SharedPreferences pref;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_personal__details);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Personal Details");

        bar.setDisplayShowHomeEnabled(true);
        //bar.setLogo(R.drawable.ic_account_circle_black_24dp);
        //bar.setDisplayUseLogoEnabled(true);

        pref = getSharedPreferences("MyPref", MODE_PRIVATE);

        name = (EditText) findViewById(R.id.name);
        mobile_no = (EditText) findViewById(R.id.mobile_no);
        email_id = (EditText) findViewById(R.id.email_id);
        dob = (EditText) findViewById(R.id.dob);
        age = (EditText) findViewById(R.id.age);
        address = (EditText) findViewById(R.id.address);
        language = (EditText) findViewById(R.id.language);
        hobby = (EditText) findViewById(R.id.hobbies);
        save = (Button) findViewById(R.id.next_personal);
        linearLayout = (LinearLayout) findViewById(R.id.linear);

        dob.setOnClickListener(this);
        save.setOnClickListener(this);

        demo = new Database_Personal(this, "library", null, 100);

        if (save_btn == 1) {
           // enable_false();
        }
        get_shared_pref();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
       // menuInflater.inflate(R.menu.edit, menu);

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
                break;
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
        switch (view.getId()) {
            case R.id.next_personal:
                set_shared_pref();
//                add_to_database();
                //enable_false();
                save_btn = 1;
                break;
            case R.id.dob:
                Date date = new Date();

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dob.setText(datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear());
                    }
                }, date.getYear(), date.getMonth(),date.getDay());
                datePickerDialog.create();
                datePickerDialog.show();
                break;
        }
    }


    private void set_shared_pref() {
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("name", name.getText().toString());  // Saving string
        editor.putString("mobile", mobile_no.getText().toString());  // Saving string
        editor.putString("email_id", email_id.getText().toString());  // Saving string
        editor.putString("dob", dob.getText().toString());  // Saving string
        editor.putString("age", age.getText().toString());  // Saving string
        editor.putString("address", address.getText().toString());  // Saving string
        editor.putString("language", language.getText().toString());  // Saving string
        editor.putString("hobby", hobby.getText().toString());  // Saving string

        editor.commit(); // commit changes

        System.out.println(pref.getString("hobby", null));
        System.out.println(pref.getString("language", null));
        System.out.println(pref.getString("age", null));
    }


    private void get_shared_pref() {
        String name_pref = pref.getString("name", "");
        String mobile_pref = pref.getString("mobile", "");
        String email_pref = pref.getString("email_id", "");
        String age_pref = pref.getString("age", "");
        String dob_pref = pref.getString("dob", "");
        String adress_pref = pref.getString("address", "");
        String language_pref = pref.getString("language", "");
        String hobby_pref = pref.getString("hobby", "");

        name.setText(name_pref);
        mobile_no.setText(mobile_pref);
        email_id.setText(email_pref);
        age.setText(age_pref);
        dob.setText(dob_pref);
        address.setText(adress_pref);
        language.setText(language_pref);
        hobby.setText(hobby_pref);
    }



    private void enable_true() {
        name.setEnabled(true);
        mobile_no.setEnabled(true);
        email_id.setEnabled(true);
        dob.setEnabled(true);
        age.setEnabled(true);
        address.setEnabled(true);
        language.setEnabled(true);
        hobby.setEnabled(true);
    }


    private void enable_false() {
        name.setEnabled(false);
        mobile_no.setEnabled(false);
        email_id.setEnabled(false);
        dob.setEnabled(false);
        age.setEnabled(false);
        address.setEnabled(false);
        language.setEnabled(false);
        hobby.setEnabled(false);
    }



    private void add_to_database() {
        nameValue = name.getText().toString();
        mobileValue = mobile_no.getText().toString();
        emailValue = email_id.getText().toString();
        dobValue = dob.getText().toString();
        ageValue = age.getText().toString();
        addressValue = address.getText().toString();
        languageValue = language.getText().toString();
        hobbiesValue = hobby.getText().toString();

        demo.addValue(56, nameValue, mobileValue, emailValue, dobValue, ageValue, addressValue, languageValue, hobbiesValue);
        demo.readValues();
    }


}
