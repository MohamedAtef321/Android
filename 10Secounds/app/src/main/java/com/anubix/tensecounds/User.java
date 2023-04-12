package com.anubix.tensecounds;

import android.graphics.Bitmap;

public class User {
    private int id;
    private String name,message;
    private Bitmap photo;

    public User (int id, String name, String message, Bitmap photo) {
        this.id = id ;
        this.name = name ;
        this.photo = photo ;
        this.message = message ;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public String getMessage() {
        return message;
    }
}
