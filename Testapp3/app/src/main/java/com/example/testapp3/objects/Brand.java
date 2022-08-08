package com.example.testapp3.objects;

public class Brand {

    private String name, brand_slug;
    private int device_count ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand_slug() {
        return brand_slug;
    }

    public void setBrand_slug(String brand_slug) {
        this.brand_slug = brand_slug;
    }

    public int getDevice_count() {
        return device_count;
    }

    public void setDevice_count(int device_count) {
        this.device_count = device_count;
    }
}
