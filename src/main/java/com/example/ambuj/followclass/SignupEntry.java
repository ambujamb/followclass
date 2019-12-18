package com.example.ambuj.followclass;

public class SignupEntry {
    private String principal_name,school_name,school_moto,affilated_by,doe,email_id,mobile_number,password,website,phone_number,state,city,district,address;
    private int pin_code;
    private byte[] school_logo;

    public SignupEntry(){

    }

    public SignupEntry(String principal_name,String school_name,String school_moto,byte[] school_logo,String affilated_by,String doe,String email_id,String mobile_number,String password,String website,String phone_number,String state,String district,String city,String address,int pin_code){
        this.principal_name = principal_name;
        this.school_name = school_name;
        this.school_moto = school_moto;
        this.school_logo = school_logo;
        this.affilated_by = affilated_by;
        this.doe = doe;
        this.email_id =email_id;
        this.mobile_number = mobile_number;
        this.password = password;
        this.website = website;
        this.phone_number = phone_number;
        this.state =state;
        this.district = district;
        this.city = city;
        this.address =address;
        this.pin_code = pin_code;
    }


    //Getter Methods


    public String getPrincipal_name() {
        return principal_name;
    }

    public String getAddress() {
        return address;
    }

    public byte[] getSchool_logo() {
        return school_logo;
    }

    public int getPin_code() {
        return pin_code;
    }

    public String getAffilated_by() {
        return affilated_by;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getDoe() {
        return doe;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getSchool_moto() {
        return school_moto;
    }

    public String getSchool_name() {
        return school_name;
    }

    public String getState() {
        return state;
    }

    public String getWebsite() {
        return website;
    }


    //setter methods
    public void setAddress(String address) {
        this.address = address;
    }

    public void setAffilated_by(String affilated_by) {
        this.affilated_by = affilated_by;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setDoe(String doe) {
        this.doe = doe;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPin_code(int pin_code) {
        this.pin_code = pin_code;
    }

    public void setPrincipal_name(String principal_name) {
        this.principal_name = principal_name;
    }

    public void setSchool_logo(byte[] school_logo) {
        this.school_logo = school_logo;
    }

    public void setSchool_moto(String school_moto) {
        this.school_moto = school_moto;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}


