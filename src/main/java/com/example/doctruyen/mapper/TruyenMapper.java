package com.example.doctruyen.mapper;

import com.example.doctruyen.dto.TruyenRequest;
import com.example.doctruyen.exeption.GlobalException;
import com.example.doctruyen.model.TacGia;
import com.example.doctruyen.model.TheLoai;
import com.example.doctruyen.model.Truyen;
import com.example.doctruyen.repository.TacGiaRepository;
import com.example.doctruyen.repository.TheLoaiRepository;
import com.example.doctruyen.service.FileService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class TruyenMapper {

    @Autowired
    private TacGiaRepository tacGiaRepository;
    @Autowired
    private TheLoaiRepository theLoaiRepository;
    @Autowired
    private FileService fileService;

    @Mapping(target = "urlAnh", expression = "java(getUrlAnh(truyenRequest.getAnh()))")
    @Mapping(target = "ngayDang", expression = "java(java.time.Instant.now())")
    @Mapping(target = "tacGia", expression = "java(getTacGia(truyenRequest.getIdTacGia()))")
    @Mapping(target = "danhSachTheLoai", expression = "java(getTheLoai(truyenRequest.getIdTheLoai()))")
    public abstract Truyen map(TruyenRequest truyenRequest);

    @Mapping(target = "urlAnh", expression = "java(getUrlAnh(truyenRequest.getAnh()))")
    @Mapping(target = "tacGia", expression = "java(getTacGia(truyenRequest.getIdTacGia()))")
    @Mapping(target = "danhSachTheLoai", expression = "java(getTheLoai(truyenRequest.getIdTheLoai()))")
    public abstract Truyen mapUpdate(TruyenRequest truyenRequest);

    String getUrlAnh(MultipartFile anh) {
        if (null == anh)
            return null;
        return fileService.uploadFile(anh);
    }

    TacGia getTacGia(Long idTacGia) {
        return tacGiaRepository.findById(idTacGia)
                .orElseThrow(() -> new GlobalException("Tac gia voi id " + idTacGia + " khong ton tai"));
    }

    Set<TheLoai> getTheLoai(Long[] idTheLoai) {
        return new HashSet<>(theLoaiRepository.findAllById(Arrays.asList(idTheLoai)));
    }
}
