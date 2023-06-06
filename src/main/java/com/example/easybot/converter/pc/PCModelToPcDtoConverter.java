package com.example.easybot.converter.pc;

import com.example.easybot.converter.AbstractConverter;
import com.example.easybot.dto.PCDto;
import com.example.easybot.model.PC;
import org.springframework.stereotype.Service;

@Service
public class PCModelToPcDtoConverter extends AbstractConverter<PC, PCDto> {
    @Override
    public PCDto convert(PC source) {
        PCDto pc = new PCDto();

        pc.setId(source.getId());
        pc.setSeriesNumber(source.getSeriesNumber());
        pc.setManufacturer(source.getManufacturer());
        pc.setPrice(source.getPrice());
        pc.setUnitsOnStockCount(source.getUnitsOnStockCount());
        pc.setFormFactor(source.getFormFactor());

        return pc;
    }
}
