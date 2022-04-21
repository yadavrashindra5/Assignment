package com.example.physicswalla.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class ModelClass {

    private int id;
    private String name,profileImage;
    private ArrayList<String>subjects;
    private ArrayList<String>qualification;

    public ModelClass() {
    }

    public ModelClass(String name, String profileImage, ArrayList<String> subjects, ArrayList<String> qualification) {
        this.name = name;
        this.profileImage = profileImage;
        this.subjects = subjects;
        this.qualification = qualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<String> getQualification() {
        return qualification;
    }

    public void setQualification(ArrayList<String> qualification) {
        this.qualification = qualification;
    }

    //this methods converts the arraylist data into single string
    public static String onlySubject(ArrayList<String>arrayList)
    {
        String subject="";
        for(String str1:arrayList)
        {
            subject+=str1+"\n";
        }
        return  subject;
    }
    //this methods converts the arraylist data into single string
    public static String onlyQualification(ArrayList<String>arrayList)
    {
        String qualifications="";
        for(String str1:arrayList)
        {
            qualifications+=str1+"\n";
        }
        return  qualifications;
    }

}
