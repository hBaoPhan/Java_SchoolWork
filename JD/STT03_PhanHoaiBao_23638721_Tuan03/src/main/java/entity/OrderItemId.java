package entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemId implements Serializable {

    private int product;
    private int order;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId that = (OrderItemId) o;
        return product == that.product && order == that.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }
}
