package pro.austincook.learn_spring.basicrestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDto {
    private String customerName;
    private String productName;
    @JsonProperty("amount") // <- specifies that Json name is "q" rather than "quantity"
    private int quantity;

    @Override
    public String toString() {
        return "OrderDto{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
