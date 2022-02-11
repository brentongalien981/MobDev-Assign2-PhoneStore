package com.example.brenbaga_comp304_001_assign2;

public class BillingInfoModel {

    public String preferredTitle;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String street;
    public String city;
    public String province;
    public String postalCode;
    public boolean isSameWithShipping;

    public BillingInfoModel() {
    }

    public BillingInfoModel(String preferredTitle, String firstName, String lastName, String email, String phoneNumber, String street, String city, String province, String postalCode, boolean isSameWithShipping) {
        this.preferredTitle = preferredTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.isSameWithShipping = isSameWithShipping;
    }
}
