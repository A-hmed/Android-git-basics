package com.route.basicsc39;

public class ContactDM {
    private int imageId;
    private String name;
    private String phoneNumber;

    public ContactDM(int imageId, String name, String phoneNumber) {
        this.imageId = imageId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public ContactDM() {
        this.imageId = 0;
        this.name = "";
        this.phoneNumber = "";
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
