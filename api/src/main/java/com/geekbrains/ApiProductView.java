package com.geekbrains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiProductView {

    @JsonProperty
    private String title;

    @JsonProperty
    private Double price;

}
