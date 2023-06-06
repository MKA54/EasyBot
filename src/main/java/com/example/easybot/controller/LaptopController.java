package com.example.easybot.controller;

import com.example.easybot.dto.LaptopDto;
import com.example.easybot.model.Validation;
import com.example.easybot.service.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
@Tag(name = "Register Laptop.", description = "Methods Laptop.")
public class LaptopController {
    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @RequestMapping(value = "addLaptop", method = RequestMethod.POST)
    @Operation(summary = "Add laptop.")
    @ResponseBody
    public Validation addLaptop(@RequestBody LaptopDto laptopDto) {
        return laptopService.add(laptopDto);
    }

    @RequestMapping(value = "getAllLaptop", method = RequestMethod.GET)
    @Operation(summary = "Get all laptop.")
    @ResponseBody
    public List<LaptopDto> getAllLaptop() {
        return laptopService.getAll();
    }

    @RequestMapping(value = "getLaptopById", method = RequestMethod.GET)
    @Operation(summary = "Get laptop by id.")
    @ResponseBody
    public LaptopDto getLaptopById(Integer id) {
        return laptopService.getById(id);
    }

    @RequestMapping(value = "updateLaptop", method = RequestMethod.PUT)
    @Operation(summary = "Update laptop.")
    @ResponseBody
    public Validation updateLaptop(@RequestBody LaptopDto laptopDto) {
        return laptopService.update(laptopDto);
    }
}
