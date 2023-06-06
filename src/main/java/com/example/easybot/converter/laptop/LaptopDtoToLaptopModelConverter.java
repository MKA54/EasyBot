package com.example.easybot.converter.laptop;

import com.example.easybot.converter.AbstractConverter;
import com.example.easybot.dto.LaptopDto;
import com.example.easybot.model.Laptop;
import org.springframework.stereotype.Service;

@Service
public class LaptopDtoToLaptopModelConverter extends AbstractConverter<LaptopDto, Laptop> {
    @Override
    public Laptop convert(LaptopDto source) {
        Laptop laptop = new Laptop();

        laptop.setId(source.getId());
        laptop.setSeriesNumber(source.getSeriesNumber());
        laptop.setManufacturer(source.getManufacturer());
        laptop.setPrice(source.getPrice());
        laptop.setUnitsOnStockCount(source.getUnitsOnStockCount());
        laptop.setSize(source.getSize());

        return laptop;
    }
}
