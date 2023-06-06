package com.example.easybot.service;

import com.example.easybot.converter.hdd.HDDDtoToHDDModelConverter;
import com.example.easybot.converter.hdd.HDDModelToHDDDtoConverter;
import com.example.easybot.dao.rep.HDDDaoImpl;
import com.example.easybot.dto.HDDDto;
import com.example.easybot.model.HDD;
import com.example.easybot.model.Validation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HDDService {
    private final HDDDtoToHDDModelConverter hddDtoToHDDModelConverter;
    private final HDDModelToHDDDtoConverter hddModelToHDDDtoConverter;
    private final HDDDaoImpl hddDao;

    public HDDService(HDDDtoToHDDModelConverter hddDtoToHDDModelConverter,
                      HDDModelToHDDDtoConverter hddModelToHDDDtoConverter,
                      HDDDaoImpl hddDao) {
        this.hddDtoToHDDModelConverter = hddDtoToHDDModelConverter;
        this.hddModelToHDDDtoConverter = hddModelToHDDDtoConverter;
        this.hddDao = hddDao;
    }

    public Validation add(HDDDto hddDto) {
        Validation validation = validate(hddDto);

        if (validation.isValid()) {
            HDD hdd = hddDtoToHDDModelConverter.convert(hddDto);
            hdd.setId(null);
            hddDao.create(hdd);
        }

        return validation;
    }

    public List<HDDDto> getAll() {
        List<HDD> hddList = hddDao.findAll();

        List<HDDDto> hddDtoList = new ArrayList<>();
        for (HDD h : hddList) {
            HDDDto hddDto = hddModelToHDDDtoConverter.convert(h);
            hddDtoList.add(hddDto);
        }

        return hddDtoList;
    }

    public HDDDto getById(Integer id) {
        return hddModelToHDDDtoConverter.convert(hddDao.getProductById(id));
    }

    public Validation update(HDDDto hddDto) {
        Validation validation = validate(hddDto);

        if (validation.isValid()) {
            hddDao.update(hddDtoToHDDModelConverter.convert(hddDto));
        }

        return validation;
    }

    private Validation validate(HDDDto hddDto) {
        Validation validation = new Validation();
        validation.setValid(true);

        if (hddDto.getSeriesNumber().isEmpty()) {
            validation.setValid(false);
            validation.setError("HDD serial number missing.");
            return validation;
        }

        if (hddDto.getManufacturer().isEmpty()) {
            validation.setValid(false);
            validation.setError("Missing HDD manufacturer.");
            return validation;
        }

        // Самая базовая проверка цены
        if (hddDto.getPrice() < 1) {
            validation.setValid(false);
            validation.setError("Incorrect HDD price: " + hddDto.getPrice() + ".");
            return validation;
        }

        if (hddDto.getUnitsOnStockCount() < 0) {
            validation.setValid(false);
            validation.setError("Incorrect value of the number of HHD in stock: " + hddDto.getUnitsOnStockCount() + ".");
            return validation;
        }

        if (hddDto.getVolume() < 1) {
            validation.setValid(false);
            validation.setError("Incorrect volume: " + hddDto.getVolume() + ".");
            return validation;
        }

        return validation;
    }
}
