package ua.skripnal.model;

import java.time.LocalDateTime;

public class CustomProductBucket {

    private int id;
    private int bucketId;
    private String name;
    private String description;
    private double price;
    private String category;
    private String subCategory;
    private LocalDateTime createDate;
    private String imagePath;

    public CustomProductBucket(int id, int bucketId, String name, String description, double price, String category, String subCategory, LocalDateTime createDate, String imagePath) {
        this.id = id;
        this.bucketId = bucketId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
        this.createDate = createDate;
        this.imagePath = imagePath;
    }
}
