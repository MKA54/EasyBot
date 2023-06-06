package com.example.easybot.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Laptop")
public class LaptopDto extends BaseDto {
    @Schema(description = "Size")
    private double size;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
