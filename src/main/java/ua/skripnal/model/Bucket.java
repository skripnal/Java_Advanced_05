package ua.skripnal.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Bucket {

    private int id;
    private int userId;
    private int productId;
    private LocalDateTime addedDate;

    public Bucket(int id, int userId, int productId, LocalDateTime addedDate) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.addedDate = addedDate;
    }

    public Bucket(int userId, int productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "userId=" + userId +
                ", productId=" + productId +
                ", addedDate=" + addedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return userId == bucket.userId && productId == bucket.productId && Objects.equals(addedDate, bucket.addedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, productId, addedDate);
    }
}
