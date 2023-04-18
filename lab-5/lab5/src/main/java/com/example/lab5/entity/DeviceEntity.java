package com.example.lab5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "devices")
public class DeviceEntity {

    @Id
    public int id;
    public String name;
    public String image;
    public int amount;
    public String type;
    public String description;
    public int price;

    public DeviceEntity() {

    }

    public DeviceEntity(int id, String name, String type, String image, int amount, String description, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.image = image;
        this.amount = amount;
        this.description = description;
        this.price = price;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{\"id\": "+id+"," +
                "\"name\": \""+name+"\"," +
                "\"type\":\""+type+"\", " +
                "\"image\":\""+image+"\", " +
                "\"amount\":"+ amount+", " +
                "\"description\":\""+description+"\","+
                "\"price\":"+price+"}";
    }
}



//    CREATE TABLE "devices" (
//        "id" serial PRIMARY KEY,
//        "name" varchar,
//        "type" varchar,
//        "image" varchar,
//        "amount" int,
//        "description" varchar,
//        "price" int
//        );
