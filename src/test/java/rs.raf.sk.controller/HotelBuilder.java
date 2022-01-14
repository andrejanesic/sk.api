package rs.raf.sk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class HotelBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static HotelDto getDto() {
        HotelDto dto = new HotelDto();
        dto.setId("1");
        return dto;
    }
}