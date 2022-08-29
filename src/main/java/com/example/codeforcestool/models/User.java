package com.example.codeforcestool.models;

public class User {

    public enum Rank {
        newbie,pupil;

//        public String getColor(){
//            switch (this){
//                case newbie:return "grey";
//                case pupil:return "green";
//                case specialist:return "#03A89E";
//                case expert:return "blue ";
//                case candidate master	:return "#a0a  ";
//                case newbie:return "FF8C00  ";
//                case newbie:return "FF8C00  ";
//                case newbie:return "red   ";
//
//            }
//        }
    }

    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String organization;
    private String titlePhoto;
    private int rating;
    private String rank;

    private String handle;

    public String getRankColor(){
        switch (rank.toLowerCase()){
                case "newbie":return "grey";
                case "pupil":return "green";
                case "specialist":return "#03A89E";
                case "expert":return "blue ";
                case "candidate master"	:return "#a0a";

                case "international master":
                case "master":
                    return "FF8C00";

                case "grandmaster":
                case "international grandmaster":
                case "legendary grandmaster":
                    return "red";

                default:return "black";
            }
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getTitlePhoto() {
        return titlePhoto;
    }

    public void setTitlePhoto(String titlePhoto) {
        this.titlePhoto = titlePhoto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}
