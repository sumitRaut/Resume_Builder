package com.raut.swapnil.resume_builder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Curricular_Activities extends AppCompatActivity {

    EditText activity_1, activity_2;
    Button save_btn;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curricular__activities);

        pref = getSharedPreferences("MyPref", MODE_PRIVATE);

        ActionBar bar = getSupportActionBar();
        bar.setTitle("Extra Curricular Actvities");

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

