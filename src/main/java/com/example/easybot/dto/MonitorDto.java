package com.example.easybot.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Monitor")
public class MonitorDto extends BaseDto {
    @Schema(description = "Diagonal")
    private double diagonal;

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }
}
