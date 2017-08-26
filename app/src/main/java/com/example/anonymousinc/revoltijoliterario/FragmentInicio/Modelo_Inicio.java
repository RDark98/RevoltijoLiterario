package com.example.anonymousinc.revoltijoliterario.FragmentInicio;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class Modelo_Inicio {
    private String string;
    private String info;
    private int image;

    public Modelo_Inicio(String string, int image, String info) {
        this.string = string;
        this.image = image;
        this.info = info;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
