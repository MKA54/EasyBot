package com.example.easybot.controller;

import com.example.easybot.dto.PCDto;
import com.example.easybot.model.Validation;
import com.example.easybot.service.PCService;
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
@Tag(name = "Register PC.", description = "Methods PC.")
public class PCController {
    private final PCService pcService;

    public PCController(PCService pcService) {
        this.pcService = pcService;
    }

    @RequestMapping(value = "addPC", method = RequestMethod.POST)
    @Operation(summary = "Add pc.")
    @ResponseBody
    public Validation addPC(@RequestBody PCDto pcDto) {
        return pcService.add(pcDto);
    }

    @RequestMapping(value = "getAllPC", method = RequestMethod.GET)
    @Operation(summary = "Get all pc.")
    @ResponseBody
    public List<PCDto> getAllPC() {
        return pcService.getAll();
    }

    @RequestMapping(value = "getPCById", method = RequestMethod.GET)
    @Operation(summary = "Get pc by id.")
    @ResponseBody
    public PCDto getPCById(Integer id) {
        return pcService.getById(id);
    }

    @RequestMapping(value = "updatePC", method = RequestMethod.PUT)
    @Operation(summary = "Update pc.")
    @ResponseBody
    public Validation updatePC(@RequestBody PCDto pcDto) {
        return pcService.update(pcDto);
    }
}
