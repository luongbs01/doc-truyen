package com.example.doctruyen.controller;

import com.example.doctruyen.dto.ChuongRequest;
import com.example.doctruyen.model.Chuong;
import com.example.doctruyen.service.ChuongService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chuong")
@RequiredArgsConstructor
public class ChuongController {

    private final ChuongService chuongService;

    @PostMapping
    public ResponseEntity<Chuong> createChuong(@ModelAttribute @Valid ChuongRequest chuongRequest) {
        Chuong chuong = chuongService.createChuong(chuongRequest);
        return new ResponseEntity<>(chuong, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chuong> getChuong(@PathVariable Long id) {
        Chuong chuong = chuongService.getChuong(id);
        return new ResponseEntity<>(chuong, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Chuong>> getChuongByIdTruyen(@RequestParam Long idTruyen) {
        List<Chuong> danhSachChuong = chuongService.getChuongByIdTruyen(idTruyen);
        return new ResponseEntity<>(danhSachChuong, HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<Chuong>> getChuongByIdTruyenPagination(
            @RequestParam Long idTruyen,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sort
    ) {
        List<Chuong> danhSachChuong = chuongService.getChuongByIdTruyenPagination(idTruyen, size * (page - 1), size, sort);
        return new ResponseEntity<>(danhSachChuong, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteChuong(@PathVariable Long id) {
        chuongService.xoaChuong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chuong> updateChuong(@PathVariable Long id, @ModelAttribute @Valid ChuongRequest chuongRequest) {
        Chuong chuong = chuongService.updateChuong(id, chuongRequest);
        return new ResponseEntity<>(chuong, HttpStatus.OK);
    }
}
