package com.raut.swapnil.resume_builder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.widget.EditText;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sumit on 28-10-2017.
 */
/*
public class Pdf_format_1 {
    ArrayList<String> skill_array, personal_array;

    Pdf_format_1(ArrayList<String> r_skil_array, ArrayList<String> r_personal_array) {
        this.skill_array = r_skil_array;
        this.personal_array = r_personal_array;
    }


    public void create_pdf() {
        System.out.println("Printing array" + skill_array);
        System.out.println("Printing array" + personal_array);
    }
}
*/

/**
 * Created by sumit on 27-10-2017.
 */

public class Pdf_format_1 {

    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 45, Font.BOLD);
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.NORMAL);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font nameFont = new Font(Font.FontFamily.TIMES_ROMAN, 60, Font.BOLD, BaseColor.BLUE);
    //Context context;
    ArrayList<Pdf_List> file_ArrayList ;

    ArrayList<String> personalArray;
    ArrayList<ArrayList<String>> education_Array;
    String nameValue;
    EditText name, surname, mobileno, email_id, dob, age, address;
/*

    Pdf_format_1(ArrayList<String> r_personalArray, ArrayList<ArrayList<String>> r_education)
    {
        personalArray = new ArrayList<String>(r_personalArray);
        education_Array = new ArrayList<ArrayList<String>>(r_education);
    }
*/


    public void getSharedPreference(Context context) {
        SharedPreferences pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);

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

        String skill_1_pref = pref.getString("skill_1", "");
        String skill_2_pref = pref.getString("skill_2", "");
        String skill_3_pref = pref.getString("skill_3", "");
        String award_pref_1 = pref.getString("award_1", "");
        String award_pref_2 = pref.getString("award_2", "");
        String award_pref_3 = pref.getString("award_3", "");
    }

    public void createPdf(Context context, String pdfName) throws FileNotFoundException, DocumentException {
        System.out.println("Doing createpdf");

        SharedPreferences pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);

        //personal_info(pref);
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

        String skill_1_pref = pref.getString("skill_1", "");
        String skill_2_pref = pref.getString("skill_2", "");
        String skill_3_pref = pref.getString("skill_3", "");
        String award_pref_1 = pref.getString("award_1", "");
        String award_pref_2 = pref.getString("award_2", "");
        String award_pref_3 = pref.getString("award_3", "");

        try {


            Document document = new Document(PageSize.A2);
            String filename;
            String path;
            String newPath;
            //filename = Environment.getExternalStorageDirectory() + "/result_" + new SimpleDateFormat("hh_mm_ss").format(new java.util.Date()).toString() + ".pdf";
            //PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));

            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Resume Builder";
            File dir = new File(path);
            if (!dir.exists())
                dir.mkdir();

            //File file = new File(dir, "/result_" + new SimpleDateFormat("hh_mm_ss").format(new java.util.Date()).toString() + ".pdf");
            //File file = new File(dir, "/" +pdfName+ ".pdf");
            File file = new File(dir, pdfName + ".pdf");
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            newPath = dir+"/"+pdfName+".pdf";
            document.open();
            educational_info(writer, pref);
            skills_info(writer, pref);
            experience_info(writer, pref);
            project_info(writer, pref);
            curricular_info(writer, pref);
            PdfContentByte canvas = writer.getDirectContent();
            //cb.rectangle(document.PageSize.Width -90f, 830f, 50f,50f);
            Rectangle rect = new Rectangle(20, 20, 400, 1650);//x,y,width,height // 1191, 1684
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(1);
            rect.setBorderColor(BaseColor.GREEN);
            canvas.rectangle(rect);


            ColumnText ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect);
            Paragraph p = new Paragraph(name_pref, nameFont);
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingAfter(100);
            ct.addElement(p);

            p = new Paragraph("DOB: " + dob_pref, catFont);
            p.setAlignment(Element.ALIGN_CENTER);
            ct.addElement(p);
            p = new Paragraph("Age: " + age_pref, catFont);
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingAfter(100);
            ct.addElement(p);

            p = new Paragraph("Contacts", titleFont);
            p.setAlignment(Element.ALIGN_CENTER);
            ct.addElement(p);

            p = new Paragraph("Mobile: " + mobile_pref, catFont);
            p.setAlignment(Element.ALIGN_CENTER);
            ct.addElement(p);
            p = new Paragraph("Email-id: " + email_pref, catFont);
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingAfter(100);
            ct.addElement(p);

            p = new Paragraph("Language", titleFont);
            p.setAlignment(Element.ALIGN_CENTER);
            ct.addElement(p);

            p = new Paragraph(language_pref, catFont);
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingAfter(100);
            ct.addElement(p);

            p = new Paragraph("Hobbies", titleFont);
            p.setAlignment(Element.ALIGN_CENTER);
            ct.addElement(p);
            p = new Paragraph(hobby_pref, catFont);
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingAfter(100);
            ct.addElement(p);

            p = new Paragraph("Achievements", titleFont);
            p.setAlignment(Element.ALIGN_CENTER);
            ct.addElement(p);
            p = new Paragraph(award_pref_1, catFont);
            p.setAlignment(Element.ALIGN_CENTER);
            ct.addElement(p);
            p = new Paragraph(award_pref_2, catFont);
            p.setAlignment(Element.ALIGN_CENTER);
            ct.addElement(p);
            p = new Paragraph(award_pref_3, catFont);
            p.setAlignment(Element.ALIGN_LEFT);
            p.setSpacingAfter(100);
            ct.addElement(p);

            ct.go();
            canvas.stroke();
            System.out.println("Page Size:" + document.getPageSize());
            document.close();

            //viewPdf(context,file);
            viewPdf(context,newPath);
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }

    }

    public void viewPdf(Context context,String pdfName) {


        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Resume Builder";
        File dir = new File(path);
        File file = new File(dir,pdfName+".pdf");

        if(file.exists()){
            Uri uri_path = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri_path,"application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            context.startActivity(intent);
        }
        else
            System.out.println("File does not exists");
    }
    public ArrayList<Pdf_List> pdf_List() {

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Resume Builder";
        if(path!=null)
        {
            File dir = new File(path);
            File[] fileList = dir.listFiles();
            System.out.println("Length::::::::::::::::::::::::::::::::"+fileList.length);
            file_ArrayList = new ArrayList<Pdf_List>();
            file_ArrayList.clear();

            if(fileList!=null && fileList.length>0)
            {
                for (File file:fileList)
                {
                    //System.out.println(file.getAbsoluteFile());
                    //addtoList(file);

                    String pdfPath = file.getPath().toString();
                    String pdfName = file.getName();

                    Pdf_List obj = new Pdf_List(pdfName,pdfPath);
                    file_ArrayList.add(obj);
                }
                printList(file_ArrayList);
            }
        }
        return file_ArrayList;
    }

    public void printList(ArrayList<Pdf_List> file_arrayList) {
        /*for(Pdf_List element:file_arrayList)
            System.out.println("************************************************"+element);*/

        for (int i=0; i<file_arrayList.size();i++)
        {
            System.out.println("NAME= "+file_arrayList.get(i).getPdfName()+" PATH = "+file_arrayList.get(i).getPdfPath());
        }
        //return file_arrayList;
    }

    //private void addtoList(File file)
    private void addtoList() {
        file_ArrayList = new ArrayList<>();
        //file_ArrayList.add("");
        //file_ArrayList.add

    }


    private void curricular_info(PdfWriter writer, SharedPreferences pref) {
        String activity_pref_1 = pref.getString("activity_1", "");
        String activity_pref_2 = pref.getString("activity_2", "");
        System.out.println("Activity 1:" + activity_pref_1);
        System.out.println("Activity 2:" + activity_pref_2);
        try {
            PdfContentByte canvas = writer.getDirectContent();
            Rectangle rect = new Rectangle(420, 175, 1175, 250);//x,y,width,height // 1191, 1684
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(1);
            rect.setBorderColor(BaseColor.GREEN);
            canvas.rectangle(rect);

            ColumnText ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect);
            Paragraph p = new Paragraph("Extra Curricular Activities", titleFont);
            p.setAlignment(Element.ALIGN_CENTER);
            //p.setSpacingAfter(100);
            ct.addElement(p);
            ct.go();
            canvas.stroke();

            rect = new Rectangle(420, 20, 1175, 175);//x,y,width,height // 1191, 1684
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(1);
            rect.setBorderColor(BaseColor.WHITE);
            canvas.rectangle(rect);

            ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect);

            p = new Paragraph(activity_pref_1, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph(activity_pref_2, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            ct.go();
            canvas.stroke();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }


    private void project_info(PdfWriter writer, SharedPreferences pref) {
        String project_pref_1 = pref.getString("project_1", "");
        String project_pref_2 = pref.getString("project_2", "");
        String project_pref_3 = pref.getString("project_3", "");
        String description_pref_1 = pref.getString("description_1", "");
        String description_pref_2 = pref.getString("description_2", "");
        String description_pref_3 = pref.getString("description_3", "");

        try {
            PdfContentByte canvas = writer.getDirectContent();
            Rectangle rect = new Rectangle(420, 550, 1175, 625);//x,y,width,height // 1191, 1684
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(1);
            rect.setBorderColor(BaseColor.GREEN);
            canvas.rectangle(rect);

            ColumnText ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect);
            Paragraph p = new Paragraph("Projects", titleFont);
            p.setAlignment(Element.ALIGN_CENTER);
            //p.setSpacingAfter(100);
            ct.addElement(p);
            ct.go();
            canvas.stroke();

            rect = new Rectangle(420, 250, 1175, 550);//x,y,width,height // 1191, 1684
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(1);
            rect.setBorderColor(BaseColor.WHITE);
            canvas.rectangle(rect);

            ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect);

            p = new Paragraph(project_pref_1, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph(description_pref_1, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph(project_pref_2, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph(description_pref_2, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph(project_pref_3, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph(description_pref_3, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            ct.go();
            canvas.stroke();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    private void experience_info(PdfWriter writer, SharedPreferences pref) {
        String company_pref_1 = pref.getString("company_1", "");
        String company_pref_2 = pref.getString("company_2", "");
        String company_pref_3 = pref.getString("company_3", "");
        String year_pref_1 = pref.getString("experience_year_1", "");
        String year_pref_2 = pref.getString("experience_year_2", "");
        String year_pref_3 = pref.getString("experience_year_3", "");

        if (!company_pref_1.isEmpty() || !company_pref_2.isEmpty() || !company_pref_3.isEmpty()) {
            try {
                PdfContentByte canvas = writer.getDirectContent();
                Rectangle rect = new Rectangle(420, 925, 1175, 1000);//x,y,width,height // 1191, 1684
                rect.setBorder(Rectangle.BOX);
                rect.setBorderWidth(1);
                rect.setBorderColor(BaseColor.GREEN);
                canvas.rectangle(rect);

                ColumnText ct = new ColumnText(canvas);
                ct.setSimpleColumn(rect);
                Paragraph p = new Paragraph("Professional Experience", titleFont);
                p.setAlignment(Element.ALIGN_CENTER);
                //p.setSpacingAfter(100);
                ct.addElement(p);
                ct.go();
                canvas.stroke();

                rect = new Rectangle(420, 625, 1175, 925);//x,y,width,height // 1191, 1684
                rect.setBorder(Rectangle.BOX);
                rect.setBorderWidth(1);
                rect.setBorderColor(BaseColor.WHITE);
                canvas.rectangle(rect);

                ct = new ColumnText(canvas);
                ct.setSimpleColumn(rect);

                p = new Paragraph(company_pref_1, catFont);
                p.setAlignment(Element.ALIGN_JUSTIFIED);
                ct.addElement(p);
                p = new Paragraph(year_pref_1 + " years", catFont);
                p.setAlignment(Element.ALIGN_JUSTIFIED);
                ct.addElement(p);
                p = new Paragraph(company_pref_2, catFont);
                p.setAlignment(Element.ALIGN_JUSTIFIED);
                ct.addElement(p);
                p = new Paragraph(year_pref_2 + " years", catFont);
                p.setAlignment(Element.ALIGN_JUSTIFIED);
                ct.addElement(p);
                p = new Paragraph(company_pref_3, catFont);
                p.setAlignment(Element.ALIGN_JUSTIFIED);
                ct.addElement(p);
                p = new Paragraph(year_pref_3 + " years", catFont);

                p.setAlignment(Element.ALIGN_JUSTIFIED);
                ct.addElement(p);
                ct.go();
                canvas.stroke();
            } catch (Exception e) {
                System.out.println("Error!" + e.getMessage());
            }

        }
    }

    private void skills_info(PdfWriter writer, SharedPreferences pref) {
        String skill_1_pref = pref.getString("skill_1", "");
        String skill_2_pref = pref.getString("skill_2", "");
        String skill_3_pref = pref.getString("skill_3", "");

        try {
            PdfContentByte canvas = writer.getDirectContent();
            Rectangle rect = new Rectangle(420, 1200, 1175, 1275);//x1,y1,x2,y2 // 1191, 1684
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(1);
            rect.setBorderColor(BaseColor.GREEN);
            canvas.rectangle(rect);

            ColumnText ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect);
            Paragraph p = new Paragraph("Professional Skills", titleFont);
            p.setAlignment(Element.ALIGN_CENTER);
            //p.setSpacingAfter(100);
            ct.addElement(p);
            ct.go();
            canvas.stroke();

            rect = new Rectangle(420, 1000, 1175, 1200);//x,y,width,height // 1191, 1684
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(1);
            rect.setBorderColor(BaseColor.WHITE);
            canvas.rectangle(rect);

            ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect);

            p = new Paragraph(skill_1_pref, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph(skill_2_pref, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph(skill_3_pref, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);

            ct.go();
            canvas.stroke();
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }

    }

    private void educational_info(PdfWriter writer, SharedPreferences pref) {
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

        try {
            PdfContentByte canvas = writer.getDirectContent();
            //cb.rectangle(document.PageSize.Width -90f, 830f, 50f,50f);
            Rectangle rect = new Rectangle(420, 1575, 1175, 1650);//x,y,width,height // 1191, 1684
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(1);
            rect.setBorderColor(BaseColor.GREEN);
            canvas.rectangle(rect);

            ColumnText ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect);
            Paragraph p = new Paragraph("Education", titleFont);
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingAfter(100);
            ct.addElement(p);
            ct.go();
            canvas.stroke();


            rect = new Rectangle(420, 1275, 1175, 1575);//x,y,width,height // 1191, 1684
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(1);
            rect.setBorderColor(BaseColor.WHITE);
            canvas.rectangle(rect);

            ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect);

            p = new Paragraph("\t" + college_3_pref, catFont);
            //p.setAlignment(Element.ALIGN_JUSTIFIED);

            ct.addElement(p);
            p = new Paragraph("\t\t\t" + degree_3_pref + " " + branch_3_pref + " (" + year_3_pref + ") " + marks_3_pref, catFont);
            //p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);


            p = new Paragraph("\t" + college_2_pref, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph("\t\t\t" + degree_2_pref + " (" + year_2_pref + ") " + marks_2_pref, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);

            p = new Paragraph("\t" + college_1_pref, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);
            p = new Paragraph("\t\t\t" + degree_1_pref + " (" + year_1_pref + ") " + marks_1_pref, catFont);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.addElement(p);

            ct.go();
            canvas.stroke();


        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }


    }

    private void personal_info(SharedPreferences pref) {


    }
}

