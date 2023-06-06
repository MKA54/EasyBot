package com.example.easybot.controller;

import com.example.easybot.dto.HDDDto;
import com.example.easybot.model.Validation;
import com.example.easybot.service.HDDService;
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
@Tag(name = "Register HDD.", description = "Methods HDD.")
public class HDDController {
    private final HDDService hddService;

    public HDDController(HDDService hddService) {
        this.hddService = hddService;
    }

    @RequestMapping(value = "addHDD", method = RequestMethod.POST)
    @Operation(summary = "Add HDD.")
    @ResponseBody
    public Validation addHDD(@RequestBody HDDDto hddDto) {
        return hddService.add(hddDto);
    }

    @RequestMapping(value = "getAllHDD", method = RequestMethod.GET)
    @Operation(summary = "Get all HDD.")
    @ResponseBody
    public List<HDDDto> getAllHDD() {
        return hddService.getAll();
    }

    @RequestMapping(value = "getHDDById", method = RequestMethod.GET)
    @Operation(summary = "Get HDD by id.")
    @ResponseBody
    public HDDDto getHDDById(Integer id) {
        return hddService.getById(id);
    }

    @RequestMapping(value = "updateHDD", method = RequestMethod.PUT)
    @Operation(summary = "Update HDD.")
    @ResponseBody
    public Validation update(@RequestBody HDDDto hddDto) {
        return hddService.update(hddDto);
    }
}
