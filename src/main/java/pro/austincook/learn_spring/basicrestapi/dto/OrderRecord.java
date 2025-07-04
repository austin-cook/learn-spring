package pro.austincook.learn_spring.basicrestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRecord(
        String customerName,
        String productName,
        @JsonProperty("amount") int quantity) // @JsonProperty specifies a different name used in JSON request body
{}
