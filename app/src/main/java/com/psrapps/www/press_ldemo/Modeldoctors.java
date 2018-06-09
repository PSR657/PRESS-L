package com.psrapps.www.press_ldemo;

/**
 * Created by poornashekarreddy.p on 14-09-2017.
 */

public class Modeldoctors {
    private String docname;
    private String docemail;
    private String doccity;
    private String docaddress;

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocemail() {
        return docemail;
    }

    public void setDocemail(String docemail) {
        this.docemail = docemail;
    }

    public String getDoccity() {
        return doccity;
    }

    public void setDoccity(String doccity) {
        this.doccity = doccity;
    }

    public String getDocaddress() {
        return docaddress;
    }

    public void setDocaddress(String docaddress) {
        this.docaddress = docaddress;
    }

    public Modeldoctors(String docname, String docemail, String doccity, String docaddress) {
        this.docname = docname;
        this.docemail = docemail;
        this.doccity = doccity;
        this.docaddress = docaddress;
    }
}
