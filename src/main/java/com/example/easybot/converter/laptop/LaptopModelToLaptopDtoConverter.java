package com.example.easybot.converter.laptop;

import com.example.easybot.converter.AbstractConverter;
import com.example.easybot.dto.LaptopDto;
import com.example.easybot.model.Laptop;
import org.springframework.stereotype.Service;

@Service
public class LaptopModelToLaptopDtoConverter extends AbstractConverter<Laptop, LaptopDto> {
    @Override
    public LaptopDto convert(Laptop source) {
        LaptopDto pc = new LaptopDto();

        pc.setId(source.getId());
        pc.setSeriesNumber(source.getSeriesNumber());
        pc.setManufacturer(source.getManufacturer());
        pc.setPrice(source.getPrice());
        pc.setUnitsOnStockCount(source.getUnitsOnStockCount());
        pc.setSize(source.getSize());

        return pc;
    }
}
