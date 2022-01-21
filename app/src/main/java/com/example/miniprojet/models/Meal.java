package com.example.miniprojet.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Meal implements Parcelable {

    String nom;
    String descr;
    String img;
    String calorie;
    String fat;
    String carb;
    String protine;

    public Meal() {
    }

    public Meal(String nom, String descr, String img, String calorie, String fat, String carb, String protine) {
        this.nom = nom;
        this.descr = descr;
        this.img = img;
        this.calorie = calorie;
        this.fat = fat;
        this.carb = carb;
        this.protine = protine;
    }





    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    protected Meal(Parcel in) {
        nom = in.readString();
        descr = in.readString();
        img = in.readString();
        calorie = in.readString();
        carb = in.readString();
        fat = in.readString();
        protine = in.readString();


    }

    public String getNom() {
        return nom;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCarb() {
        return carb;
    }

    public void setCarb(String carb) {
        this.carb = carb;
    }

    public String getProtine() {
        return protine;
    }

    public void setProtine(String protine) {
        this.protine = protine;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public static final Creator<Meal> CREATOR = new Creator<Meal>() {
        @Override
        public Meal createFromParcel(Parcel in) {
            return new Meal(in);
        }

        @Override
        public Meal[] newArray(int size) {
            return new Meal[size];
        }
    };

    public static Creator<Meal> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(descr);
        dest.writeString(img);
        dest.writeString(calorie);
        dest.writeString(fat);
        dest.writeString(protine);
        dest.writeString(carb);

    }

    @Override
    public String toString() {
        return "Meal{" +
                "nom='" + nom + '\'' +
                ", descr='" + descr + '\'' +
                ", img='" + img + '\'' +
                ", calorie='" + calorie + '\'' +
                ", fat='" + fat + '\'' +
                ", carb='" + carb + '\'' +
                ", protine='" + protine + '\'' +
                '}';
    }
}
