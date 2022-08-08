package com.example.testapp3.objects;

public class PhoneFav {

    private String slug,name;


    public PhoneFav(){

    }
    public PhoneFav(String slug, String name) {
        this.slug = slug;
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

