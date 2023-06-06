package com.example.easybot.converter.monitor;

import com.example.easybot.converter.AbstractConverter;
import com.example.easybot.dto.MonitorDto;
import com.example.easybot.model.Monitor;
import org.springframework.stereotype.Service;

@Service
public class MonitorModelToMonitorDtoConverter extends AbstractConverter<Monitor, MonitorDto> {
    @Override
    public MonitorDto convert(Monitor source) {
        MonitorDto m = new MonitorDto();

        m.setId(source.getId());
        m.setSeriesNumber(source.getSeriesNumber());
        m.setManufacturer(source.getManufacturer());
        m.setPrice(source.getPrice());
        m.setUnitsOnStockCount(source.getUnitsOnStockCount());
        m.setDiagonal(source.getDiagonal());

        return m;
    }
}
