package com.example.doctruyen.controller;

import com.example.doctruyen.dto.TruyenRequest;
import com.example.doctruyen.model.Truyen;
import com.example.doctruyen.service.TruyenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/truyen")
@RequiredArgsConstructor
public class TruyenController {

    private final TruyenService truyenService;

    @PostMapping
    public ResponseEntity<Truyen> createTruyen(@ModelAttribute @Valid TruyenRequest truyenRequest) {
        Truyen truyen = truyenService.createTruyen(truyenRequest);
        return new ResponseEntity<>(truyen, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Truyen>> listTruyen(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sort
    ) {
        Page<Truyen> danhSachTruyen = truyenService.listTruyen(page, size, sort);
        return new ResponseEntity<>(danhSachTruyen, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Truyen>> searchTruyen(
            @RequestParam(required = false) String tenTruyen,
            @RequestParam(required = false) Long idTacGia,
            @RequestParam(required = false) Long idTheLoai
    ) {
        List<Truyen> danhSachTruyen = truyenService.searchTruyen(tenTruyen, idTacGia, idTheLoai);
        return new ResponseEntity<>(danhSachTruyen, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Truyen> getTruyen(@PathVariable Long id) {
        Truyen truyen = truyenService.getTruyen(id);
        return new ResponseEntity<>(truyen, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTruyen(@PathVariable Long id) {
        truyenService.xoaTruyen(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
