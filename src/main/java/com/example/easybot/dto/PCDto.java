package com.example.easybot.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "PC")
public class PCDto extends BaseDto {
    @Schema(description = "Form factor")
    private String formFactor;

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
}
