package com.example.easybot.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "HDD")
public class HDDDto extends BaseDto {
    @Schema(description = "Volume HDD")
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
