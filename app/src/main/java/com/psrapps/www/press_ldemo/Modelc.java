package com.psrapps.www.press_ldemo;

/**
 * Created by poornashekarreddy.p on 10-09-2017.
 */

public class Modelc {
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Modelc(String category, String quote) {
        this.category = category;
        this.quote = quote;
    }

    private String category;
    private String quote;
}
