package com.raut.swapnil.resume_builder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ArrayBlockingQueue;

public class List extends AppCompatActivity {
    private WebView mWebView;
    String[] mobileArray = {"Personal Details", "Education Details", "Professional Experience", "Skills and Achievements","Project","Extra Activities"};
    //    ArrayList data;
    ListView list;
    ArrayAdapter adapter;
    Button btnPrint;
    Pdf_format_1 pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //ActionBar bar = getSupportActionBar();
        //bar.setTitle("Resume Builder");
        pdf = new Pdf_format_1();

        list = (ListView) findViewById(R.id.list);

        adapter = new ArrayAdapter<String>(this, R.layout.list_items, mobileArray);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(getApplicationContext(), Personal_Details.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), Education.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), Experience.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), Skills_Awards.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), Project.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(), Curricular_Activities.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        btnPrint = (Button) findViewById(R.id.btnPprint);
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //doWebViewPrint();
                AlertDialog.Builder builder = new AlertDialog.Builder(List.this);
                View file  = getLayoutInflater().inflate(R.layout.dialog,null);
                builder.setView(file);
                final EditText nameBox = (EditText)file.findViewById(R.id.pdfName);
                //String pdfName = nameBox.getText().toString();
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String pdfName = nameBox.getText().toString();
                        if(pdfName.isEmpty())
                            System.out.println("pdfName################### is empty");
                        System.out.println("pdfName###############: "+pdfName );
                        try{
                            pdf.createPdf(getApplicationContext(),pdfName);
                            pdf.viewPdf(getApplicationContext(),pdfName);
                        }catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (DocumentException e) {
                            e.printStackTrace();
                        }

                        dialogInterface.dismiss();
                    }
                });
                AlertDialog abd = builder.create();
                abd.show();

/*                try{
                    pdf.createPdf(getApplicationContext(),pdfName);
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }*/

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(1,1,1,"Display list");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:Intent intent = new Intent(List.this, Display_PDF_List.class);
                startActivity(intent);

                pdf.pdf_List();

                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void getSharedPreference()
    {
       SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE);

        String name_pref = pref.getString("name", "");
        String mobile_pref = pref.getString("mobile", "");
        String email_pref = pref.getString("email_id", "");
        String age_pref = pref.getString("age", "");
        String dob_pref = pref.getString("dob", "");
        String adress_pref = pref.getString("address", "");
        String language_pref = pref.getString("language", "");
        String hobby_pref = pref.getString("hobby", "");

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

        String company_pref_1 = pref.getString("company_1", "");
        String company_pref_2 = pref.getString("company_2", "");
        String company_pref_3 = pref.getString("company_3", "");
        String year_pref_1 = pref.getString("experience_year_1", "");
        String year_pref_2 = pref.getString("experience_year_2", "");
        String year_pref_3 = pref.getString("experience_year_3", "");

        String skill_1_pref= pref.getString("skill_1", "");
        String skill_2_pref = pref.getString("skill_2", "");
        String skill_3_pref = pref.getString("skill_3", "");
        String award_pref_1 = pref.getString("award_1", "");
        String award_pref_2 = pref.getString("award_2", "");
        String award_pref_3 = pref.getString("award_3", "");
    }

    private void doWebViewPrint() {
        // Create a WebView object specifically for printing
        WebView webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.i("TAG", "page finished loading " + url);
                createWebPrintJob(view);
                mWebView = null;
            }
        });

        // Generate an HTML document on the fly:
        String htmlDocument = "<html><body><h1>Test Content</h1><p>Testing, " +
                "testing, testing...</p></body></html>";
        //String htmlDocument = ;
        webView.loadDataWithBaseURL(null, htmlDocument, "text/HTML", "UTF-8", null);

        // Keep a reference to WebView object until you pass the PrintDocumentAdapter
        // to the PrintManager
        mWebView = webView;
    }

    private void createWebPrintJob(WebView webView) {

        // Get a PrintManager instance
        PrintManager printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);

        // Get a print adapter instance
        PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter();

        // Create a print job with name and adapter instance
        String jobName = getString(R.string.app_name) + " Document";
        PrintJob printJob = printManager.print(jobName, printAdapter,
                new PrintAttributes.Builder().build());

        // Save the job object for later status checking
//        mPrintJobs.add(printJob);
    }

}
