package com.example.easybot.converter.hdd;

import com.example.easybot.converter.AbstractConverter;
import com.example.easybot.dto.HDDDto;
import com.example.easybot.model.HDD;
import org.springframework.stereotype.Service;

@Service
public class HDDDtoToHDDModelConverter extends AbstractConverter<HDDDto, HDD> {
    @Override
    public HDD convert(HDDDto source) {
        HDD pc = new HDD();

        pc.setId(source.getId());
        pc.setSeriesNumber(source.getSeriesNumber());
        pc.setManufacturer(source.getManufacturer());
        pc.setPrice(source.getPrice());
        pc.setUnitsOnStockCount(source.getUnitsOnStockCount());
        pc.setVolume(source.getVolume());

        return pc;
    }
}
