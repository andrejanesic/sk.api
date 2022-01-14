package rs.raf.sk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ListingBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ListingDto getDto() {
        ListingDto dto = new ListingDto();
        dto.setId("1");
        return dto;
    }
}