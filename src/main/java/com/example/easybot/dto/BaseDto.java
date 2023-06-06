package com.example.easybot.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class BaseDto {
    private Integer id;
    @Schema(description = "Series number")
    private String seriesNumber;
    @Schema(description = "Manufacturer")
    private String manufacturer;
    @Schema(description = "Price")
    private int price;
    @Schema(description = "Units on stock count")
    private int unitsOnStockCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnitsOnStockCount() {
        return unitsOnStockCount;
    }

    public void setUnitsOnStockCount(int unitsOnStockCount) {
        this.unitsOnStockCount = unitsOnStockCount;
    }
}
