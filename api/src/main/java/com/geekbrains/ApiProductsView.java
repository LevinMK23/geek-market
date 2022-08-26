package com.geekbrains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ApiProductsView {

    @JsonProperty
    private List<ApiProductView> products;

}
