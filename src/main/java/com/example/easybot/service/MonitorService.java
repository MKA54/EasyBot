package com.example.easybot.service;

import com.example.easybot.converter.monitor.MonitorDtoToMonitorModelConverter;
import com.example.easybot.converter.monitor.MonitorModelToMonitorDtoConverter;
import com.example.easybot.dao.rep.MonitorDaoImpl;
import com.example.easybot.dto.MonitorDto;
import com.example.easybot.model.Monitor;
import com.example.easybot.model.Validation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorService {
    MonitorDtoToMonitorModelConverter monitorDtoToMonitorModelConverter;
    MonitorModelToMonitorDtoConverter monitorModelToMonitorDtoConverter;
    MonitorDaoImpl monitorDao;

    public MonitorService(MonitorDtoToMonitorModelConverter monitorDtoToMonitorModelConverter,
                          MonitorModelToMonitorDtoConverter monitorModelToMonitorDtoConverter,
                          MonitorDaoImpl monitorDao) {
        this.monitorDtoToMonitorModelConverter = monitorDtoToMonitorModelConverter;
        this.monitorModelToMonitorDtoConverter = monitorModelToMonitorDtoConverter;
        this.monitorDao = monitorDao;
    }

    public Validation add(MonitorDto monitorDto) {
        Validation validation = validate(monitorDto);

        if (validation.isValid()) {
            Monitor monitor = monitorDtoToMonitorModelConverter.convert(monitorDto);
            monitor.setId(null);
            monitorDao.create(monitor);
        }

        return validation;
    }

    public List<MonitorDto> getAll() {
        List<Monitor> pcList = monitorDao.findAll();

        List<MonitorDto> monitorDtoList = new ArrayList<>();
        for (Monitor m : pcList) {
            MonitorDto monitorDto = monitorModelToMonitorDtoConverter.convert(m);
            monitorDtoList.add(monitorDto);
        }

        return monitorDtoList;
    }

    public MonitorDto getById(Integer id) {
        return monitorModelToMonitorDtoConverter.convert(monitorDao.getProductById(id));
    }

    public Validation update(MonitorDto monitorDto) {
        Validation validation = validate(monitorDto);

        if (validation.isValid()) {
            monitorDao.update(monitorDtoToMonitorModelConverter.convert(monitorDto));
        }

        return validation;
    }

    private Validation validate(MonitorDto monitorDto) {
        Validation validation = new Validation();
        validation.setValid(true);

        if (monitorDto.getSeriesNumber().isEmpty()) {
            validation.setValid(false);
            validation.setError("Monitor serial number missing.");
            return validation;
        }

        if (monitorDto.getManufacturer().isEmpty()) {
            validation.setValid(false);
            validation.setError("Missing monitor manufacturer.");
            return validation;
        }

        // Самая базовая проверка цены
        if (monitorDto.getPrice() < 1) {
            validation.setValid(false);
            validation.setError("Incorrect monitor price: " + monitorDto.getPrice() + ".");
            return validation;
        }

        if (monitorDto.getUnitsOnStockCount() < 0) {
            validation.setValid(false);
            validation.setError("Incorrect value of the number of monitors in stock: " + monitorDto.getUnitsOnStockCount() + ".");
            return validation;
        }

        if (monitorDto.getDiagonal() < 9) {
            validation.setValid(false);
            validation.setError("Incorrect diagonal monitor: " + monitorDto.getDiagonal() + ".");
            return validation;
        }

        return validation;
    }
}
