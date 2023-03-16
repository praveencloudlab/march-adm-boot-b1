package com.cts.ecart.controller;

import java.util.List;

public class BrandBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static BrandDto getDto() {
        BrandDto dto = new BrandDto();
        dto.setId("1");
        return dto;
    }
}