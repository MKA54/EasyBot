package com.example.easybot.model;

import javax.persistence.*;

@Entity
@Table(name = "pc")
public class PC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "series_number")
    private String seriesNumber;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "price")
    private int price;
    @Column(name = "units_on_stock_count")
    private int unitsOnStockCount;
    @Column(name = "form_factor")
    private String formFactor;

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

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
}
