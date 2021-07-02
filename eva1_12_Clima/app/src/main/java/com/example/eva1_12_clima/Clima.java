package com.example.eva1_12_clima;

public class Clima {
    private int imagen;
    private String city;
    private double temp;
    private String desc;


    public Clima() {
        this.imagen = R.drawable.sunny;
        this.city = "Shiganshina";
        this.temp = 27.3;
        this.desc = "On Fire";
    }

    public Clima(int imagen, String city, double temp, String desc) {
 this.imagen = imagen;
 this.city = city;
 this.temp = temp;
 this.desc = desc;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
