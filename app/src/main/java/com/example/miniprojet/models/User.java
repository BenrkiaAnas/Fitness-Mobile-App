package com.example.miniprojet.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    int id;
    String nom;
    String prenom;
    String email;
    String password;
    int age;
    float weight;
    float height;
    int gender;

    public User(int id, String nom, String prenom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public User(int id, String nom, String prenom, String email, String password, int age, float weight, float height, int gender) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

    protected User(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        prenom = in.readString();
        email = in.readString();
        password = in.readString();
        age = in.readInt();
        weight = in.readFloat();
        height = in.readFloat();
        gender = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeInt(age);
        dest.writeInt(gender);
        dest.writeFloat(weight);
        dest.writeFloat(height);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", gender=" + gender +
                '}';
    }
}
