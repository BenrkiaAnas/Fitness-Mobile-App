package com.example.miniprojet.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Plan implements Parcelable {

    String name;
    String desc;
    String img;
    String duration;
    String difficulte;
    String timeweekly;

    public Plan() {
    }

    public Plan(String name, String desc, String img) {
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public Plan(String name, String desc, String img, String duration, String difficulte, String timeweekly) {
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.duration = duration;
        this.difficulte = difficulte;
        this.timeweekly = timeweekly;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public String getTimeweekly() {
        return timeweekly;
    }

    public void setTimeweekly(String timeweekly) {
        this.timeweekly = timeweekly;
    }

    protected Plan(Parcel in) {
        name = in.readString();
        desc = in.readString();
        img = in.readString();
        difficulte = in.readString();
        duration = in.readString();
        timeweekly = in.readString();


    }



    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public static Creator<Plan> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(img);
        dest.writeString(duration);
        dest.writeString(timeweekly);
        dest.writeString(difficulte);

    }

    @Override
    public String toString() {
        return "Plan{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", img='" + img + '\'' +
                ", duration='" + duration + '\'' +
                ", difficulte='" + difficulte + '\'' +
                ", timeweekly='" + timeweekly + '\'' +
                '}';
    }
}
