package com.example.ambuj.followclass;

public class LoginEntry {

    private int studentID;
    private String studentName;

    public LoginEntry(){

    }

    public LoginEntry(int studentID,String studentName){
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public void setStudentID(int id){
        this.studentID = id;
    }

    public int getStudentID(){
        return this.studentID;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public String getStudentName(){
        return this.studentName;
    }
}
