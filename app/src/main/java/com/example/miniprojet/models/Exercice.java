package com.example.miniprojet.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Exercice implements Parcelable {

    String name;
    String desc;
    String img;
    String time;
    Plan plan;

    public Exercice() {
    }

    public Exercice(String name, String desc, String img, String time) {
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    protected Exercice(Parcel in) {
        name = in.readString();
        desc = in.readString();
        img = in.readString();
        time = in.readString();
    }

    public static final Creator<Exercice> CREATOR = new Creator<Exercice>() {
        @Override
        public Exercice createFromParcel(Parcel in) {
            return new Exercice(in);
        }

        @Override
        public Exercice[] newArray(int size) {
            return new Exercice[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(img);
        dest.writeString(time);
    }

    @Override
    public String toString() {
        return "Exercice{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", img='" + img + '\'' +
                ", time='" + time + '\'' +
                ", plan=" + plan +
                '}';
    }
}
