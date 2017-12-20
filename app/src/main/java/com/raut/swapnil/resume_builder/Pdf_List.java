package com.raut.swapnil.resume_builder;

/**
 * Created by sumit on 01-12-2017.
 */

public class Pdf_List {
    String pdfName;
    String pdfPath;

    Pdf_List(String pdfName, String pdfPath){
        this.pdfName = pdfName;
        this.pdfPath = pdfPath;
    }

    public String getPdfName() {
        return this.pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getPdfPath() {
        return this.pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }
}
