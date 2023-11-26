package ua.skripnal.model;


import java.util.HashMap;
import java.util.Objects;

public class Storehouse {

    private int productId;
    private int count;

    public Storehouse(int productId, int count) {
        this.productId = productId;
        this.count = count;
    }

    public int getProductId() {
        return productId;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Storehouse{" +
                "productId=" + productId +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storehouse that = (Storehouse) o;
        return productId == that.productId && count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, count);
    }
}
