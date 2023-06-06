package com.example.easybot.service;

import com.example.easybot.converter.pc.PCDtoToPCModelConverter;
import com.example.easybot.converter.pc.PCModelToPcDtoConverter;
import com.example.easybot.dao.rep.PCDaoImpl;
import com.example.easybot.dto.PCDto;
import com.example.easybot.model.PC;
import com.example.easybot.model.Validation;
import com.example.easybot.model.enums.PCEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PCService {
    private final PCDtoToPCModelConverter pcDtoToPCModelConverter;
    private final PCModelToPcDtoConverter pcModelToPcDtoConverter;
    private final PCDaoImpl pcDao;

    public PCService(PCDtoToPCModelConverter pcDtoToPCModelConverter,
                     PCModelToPcDtoConverter pcModelToPcDtoConverter,
                     PCDaoImpl pcDao) {
        this.pcDtoToPCModelConverter = pcDtoToPCModelConverter;
        this.pcModelToPcDtoConverter = pcModelToPcDtoConverter;
        this.pcDao = pcDao;
    }

    public Validation add(PCDto pcDto) {
        Validation validation = validate(pcDto);

        if (validation.isValid()) {
            PC pc = pcDtoToPCModelConverter.convert(pcDto);
            pc.setId(null);
            pcDao.create(pc);
        }

        return validation;
    }

    public List<PCDto> getAll() {
        List<PC> pcList = pcDao.findAll();

        List<PCDto> pcDtoList = new ArrayList<>();
        for (PC p : pcList) {
            PCDto pcDto = pcModelToPcDtoConverter.convert(p);
            pcDtoList.add(pcDto);
        }

        return pcDtoList;
    }

    public PCDto getById(Integer id) {
        return pcModelToPcDtoConverter.convert(pcDao.getProductById(id));
    }

    public Validation update(PCDto pcDto) {
        Validation validation = validate(pcDto);

        if (validation.isValid()) {
            pcDao.update(pcDtoToPCModelConverter.convert(pcDto));
        }

        return validation;
    }

    private Validation validate(PCDto pcDto) {
        Validation validation = new Validation();
        validation.setValid(true);

        if (pcDto.getSeriesNumber().isEmpty()) {
            validation.setValid(false);
            validation.setError("Computer serial number missing.");
            return validation;
        }

        if (pcDto.getManufacturer().isEmpty()) {
            validation.setValid(false);
            validation.setError("Missing computer manufacturer.");
            return validation;
        }

        // Самая базовая проверка цены
        if (pcDto.getPrice() < 1) {
            validation.setValid(false);
            validation.setError("Incorrect computer price: " + pcDto.getPrice() + ".");
            return validation;
        }

        if (pcDto.getUnitsOnStockCount() < 0) {
            validation.setValid(false);
            validation.setError("Incorrect value of the number of computers in stock: " + pcDto.getUnitsOnStockCount() + ".");
            return validation;
        }

        String formFactor = pcDto.getFormFactor();
        if (formFactor.isEmpty()) {
            validation.setValid(false);
            validation.setError("Incorrect computer form factor.");
            return validation;
        }

        boolean isFormFactor = false;
        PCEnum[] pcEnums = PCEnum.values();

        for (PCEnum pcEnum : pcEnums) {
            if (pcEnum.getType().equals(formFactor)) {
                isFormFactor = true;
                break;
            }
        }

        if (!isFormFactor) {
            validation.setValid(false);
            validation.setError("The computer does not have the correct form factor: " + formFactor + ".");
            return validation;
        }

        return validation;
    }
}
