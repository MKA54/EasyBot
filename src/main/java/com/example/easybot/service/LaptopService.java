package com.example.easybot.service;

import com.example.easybot.converter.laptop.LaptopDtoToLaptopModelConverter;
import com.example.easybot.converter.laptop.LaptopModelToLaptopDtoConverter;
import com.example.easybot.dao.rep.LaptopDaoImpl;
import com.example.easybot.dto.LaptopDto;
import com.example.easybot.model.Laptop;
import com.example.easybot.model.Validation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopService {
    private final LaptopDtoToLaptopModelConverter laptopDtoToLaptopModelConverter;
    private final LaptopModelToLaptopDtoConverter laptopModelToLaptopDtoConverter;
    private final LaptopDaoImpl laptopDao;


    public LaptopService(LaptopDtoToLaptopModelConverter laptopDtoToLaptopModelConverter,
                         LaptopModelToLaptopDtoConverter laptopModelToLaptopDtoConverter,
                         LaptopDaoImpl laptopDao) {
        this.laptopDtoToLaptopModelConverter = laptopDtoToLaptopModelConverter;
        this.laptopModelToLaptopDtoConverter = laptopModelToLaptopDtoConverter;
        this.laptopDao = laptopDao;
    }

    public Validation add(LaptopDto laptopDto) {
        Validation validation = validate(laptopDto);

        if (validation.isValid()) {
            Laptop laptop = laptopDtoToLaptopModelConverter.convert(laptopDto);
            laptop.setId(null);
            laptopDao.create(laptop);
        }

        return validation;
    }

    public List<LaptopDto> getAll() {
        List<Laptop> laptopList = laptopDao.findAll();

        List<LaptopDto> laptopDtoList = new ArrayList<>();
        for (Laptop l : laptopList) {
            LaptopDto laptopDto = laptopModelToLaptopDtoConverter.convert(l);
            laptopDtoList.add(laptopDto);
        }

        return laptopDtoList;
    }

    public LaptopDto getById(Integer id) {
        return laptopModelToLaptopDtoConverter.convert(laptopDao.getProductById(id));
    }

    public Validation update(LaptopDto laptopDto) {
        Validation validation = validate(laptopDto);

        if (validation.isValid()) {
            laptopDao.update(laptopDtoToLaptopModelConverter.convert(laptopDto));
        }

        return validation;
    }

    private Validation validate(LaptopDto laptopDto) {
        Validation validation = new Validation();
        validation.setValid(true);

        if (laptopDto.getSeriesNumber().isEmpty()) {
            validation.setValid(false);
            validation.setError("Laptop serial number missing.");
            return validation;
        }

        if (laptopDto.getManufacturer().isEmpty()) {
            validation.setValid(false);
            validation.setError("Missing laptop manufacturer.");
            return validation;
        }

        // Самая базовая проверка цены
        if (laptopDto.getPrice() < 1) {
            validation.setValid(false);
            validation.setError("Incorrect laptop price: " + laptopDto.getPrice() + ".");
            return validation;
        }

        if (laptopDto.getUnitsOnStockCount() < 0) {
            validation.setValid(false);
            validation.setError("Incorrect value of the number of laptops in stock: " + laptopDto.getUnitsOnStockCount() + ".");
            return validation;
        }

        if (laptopDto.getSize() < 13 || laptopDto.getSize() == 16 || laptopDto.getSize() > 17) {
            validation.setValid(false);
            validation.setError("Incorrect size laptop: " + laptopDto.getSize() + ".");
            return validation;
        }

        return validation;
    }
}
