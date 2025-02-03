package com.project.kp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyDataDto {
    @JsonProperty("temperature")
    private String temperature;

    @JsonProperty("humidity")
    private String humidity;

    @JsonProperty("windSpeed")
    private String windSpeed;
}
