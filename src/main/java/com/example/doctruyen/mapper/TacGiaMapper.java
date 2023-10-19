package com.example.doctruyen.mapper;

import com.example.doctruyen.dto.TacGiaResponse;
import com.example.doctruyen.model.TacGia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class TacGiaMapper {

    @Mapping(target = "soTacPham", expression = "java(tacGia.getDanhSachTruyen().size())")
    public abstract TacGiaResponse mapToResponse(TacGia tacGia);
}
