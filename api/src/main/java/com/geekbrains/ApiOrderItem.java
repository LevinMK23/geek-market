package com.geekbrains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiOrderItem {

    @JsonProperty
    private String productName;

    @JsonProperty
    private Integer count;

    @JsonProperty
    private Double price;

}
