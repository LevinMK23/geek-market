package com.geekbrains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ApiOrder {

    @JsonProperty
    private Long orderId;

    @JsonProperty
    private List<ApiOrderItem> details;

    @JsonProperty
    private Double summaryPrice;

}
