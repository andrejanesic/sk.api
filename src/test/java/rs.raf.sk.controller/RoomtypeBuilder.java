package rs.raf.sk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class RoomtypeBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static RoomtypeDto getDto() {
        RoomtypeDto dto = new RoomtypeDto();
        dto.setId("1");
        return dto;
    }
}