package entity;

import java.io.Serializable;
import java.util.Objects;

public class StockId implements Serializable {

    private int product;
    private int store;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return product == stockId.product && store == stockId.store;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, store);
    }
}
