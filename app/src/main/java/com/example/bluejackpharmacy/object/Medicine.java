package com.example.bluejackpharmacy.object;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Medicine implements Parcelable {
    private int id;
    private String name;
    private String manufacturer;
    private double price;
    private String description;

    private String imagePath;

    public Medicine(int id, String name, String manufacturer, double price, String description, String imagePath) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }

    protected Medicine(Parcel in) {
        id = in.readInt();
        name = in.readString();
        manufacturer = in.readString();
        price = in.readDouble();
        description = in.readString();
        imagePath = in.readString();
    }

    public static final Creator<Medicine> CREATOR = new Creator<Medicine>() {
        @Override
        public Medicine createFromParcel(Parcel in) {
            return new Medicine(in);
        }

        @Override
        public Medicine[] newArray(int size) {
            return new Medicine[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        if(!imagePath.equals("none")) {
            return imagePath;
        }
        return null;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(manufacturer);
        dest.writeDouble(price);
        dest.writeString(description);
        dest.writeString(imagePath);
    }
}
