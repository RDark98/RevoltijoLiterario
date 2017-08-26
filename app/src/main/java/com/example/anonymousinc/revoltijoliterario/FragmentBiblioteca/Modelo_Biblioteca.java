package com.example.anonymousinc.revoltijoliterario.FragmentBiblioteca;

/**
 * Created by Anonymous.Inc on 02/07/2017.
 */

public class Modelo_Biblioteca {
    private String mText;
    private int mImage;

    public Modelo_Biblioteca(String mText, int mImage) {
        this.mText = mText;
        this.mImage = mImage;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
}
