package com.example.ambuj.followclass.classes;

public class DashboardData {

    private String title;
  //  private String secondaryText;
    private int cardImage;

    public DashboardData(String title,int cardImage){
        this.title = title;
       //this.secondaryText = secondaryText;
        this.cardImage = cardImage;

    }

    public String getTitle(){
        return title;
    }

   // public String getSecondaryText(){
   //     return secondaryText;
  //  }

    public int getCardImage(){
        return cardImage;
    }
}
