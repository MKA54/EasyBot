package com.example.easybot.converter.pc;

import com.example.easybot.converter.AbstractConverter;
import com.example.easybot.dto.PCDto;
import com.example.easybot.model.PC;
import org.springframework.stereotype.Service;

@Service
public class PCDtoToPCModelConverter extends AbstractConverter<PCDto, PC> {
    @Override
    public PC convert(PCDto source) {
        PC pc = new PC();

        pc.setId(source.getId());
        pc.setSeriesNumber(source.getSeriesNumber());
        pc.setManufacturer(source.getManufacturer());
        pc.setPrice(source.getPrice());
        pc.setUnitsOnStockCount(source.getUnitsOnStockCount());
        pc.setFormFactor(source.getFormFactor());

        return pc;
    }
}
