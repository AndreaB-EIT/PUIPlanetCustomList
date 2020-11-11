package com.example.puiplanetcustomlist.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class Planet {
    @SerializedName("name") // name in the JSON
    private String name;

    @SerializedName("distance")
    private String distance;

    @SerializedName("gravity")
    private String gravity;

    @SerializedName("diameter")
    private String diameter;

    @SerializedName("image")
    private String imageName;

    private Bitmap bitmap;

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getGravity() {
        return gravity;
    }

    public String getImageName() {
        return imageName;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", distance='" + distance + '\'' + /*
                ", gravity='" + gravity + '\'' +
                ", diameter='" + diameter + '\'' +
                ", imageName='" + imageName + '\'' +
                ", bitmap=" + bitmap +*/
                '}';
    }
}
