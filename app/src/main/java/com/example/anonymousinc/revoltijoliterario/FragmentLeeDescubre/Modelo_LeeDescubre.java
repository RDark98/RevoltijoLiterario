package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre;

/**
 * Created by Anonymous.Inc on 01/07/2017.
 */

public class Modelo_LeeDescubre {
    private String string;
    private int image;

    public Modelo_LeeDescubre(String string, int image) {
        this.string = string;
        this.image = image;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
