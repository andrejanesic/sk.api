package rs.raf.sk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class RankBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static RankDto getDto() {
        RankDto dto = new RankDto();
        dto.setId("1");
        return dto;
    }
}