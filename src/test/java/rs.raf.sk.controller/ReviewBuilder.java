package rs.raf.sk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ReviewBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReviewDto getDto() {
        ReviewDto dto = new ReviewDto();
        dto.setId("1");
        return dto;
    }
}