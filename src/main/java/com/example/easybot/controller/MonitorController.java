package com.example.easybot.controller;

import com.example.easybot.dto.MonitorDto;
import com.example.easybot.model.Validation;
import com.example.easybot.service.MonitorService;
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
@Tag(name = "Register Monitor.", description = "Methods Monitor.")
public class MonitorController {
    MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @RequestMapping(value = "addMonitor", method = RequestMethod.POST)
    @Operation(summary = "Add monitor.")
    @ResponseBody
    public Validation addMonitor(@RequestBody MonitorDto monitorDto) {
        return monitorService.add(monitorDto);
    }

    @RequestMapping(value = "getAllMonitor", method = RequestMethod.GET)
    @Operation(summary = "Get all monitor.")
    @ResponseBody
    public List<MonitorDto> getAllMonitor() {
        return monitorService.getAll();
    }

    @RequestMapping(value = "getMonitorById", method = RequestMethod.GET)
    @Operation(summary = "Get monitor by id.")
    @ResponseBody
    public MonitorDto getMonitorById(Integer id) {
        return monitorService.getById(id);
    }

    @RequestMapping(value = "updateMonitor", method = RequestMethod.PUT)
    @Operation(summary = "Update monitor.")
    @ResponseBody
    public Validation updateMonitor(@RequestBody MonitorDto monitorDto) {
        return monitorService.update(monitorDto);
    }
}
