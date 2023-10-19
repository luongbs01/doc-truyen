package com.example.doctruyen.mapper;

import com.example.doctruyen.dto.TheLoaiResponse;
import com.example.doctruyen.model.TheLoai;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class TheLoaiMapper {

    @Mapping(target = "soTacPham", expression = "java(theLoai.getDanhSachTruyen().size())")
    public abstract TheLoaiResponse mapToResponse(TheLoai theLoai);
}
