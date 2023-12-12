package com.example.doctruyen.controller;

import com.example.doctruyen.dto.TruyenRequest;
import com.example.doctruyen.model.Truyen;
import com.example.doctruyen.service.TruyenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<List<Truyen>> searchTruyen(
            @RequestParam(required = false) String tenTruyen,
            @RequestParam(required = false) Long idTacGia,
            @RequestParam(required = false) Long idTheLoai,
            @RequestParam(required = false) boolean isFull,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        List<Truyen> danhSachTruyen = truyenService.searchTruyen(tenTruyen, idTacGia, idTheLoai, isFull, size * (page - 1), size);
        return new ResponseEntity<>(danhSachTruyen, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> countTruyen(
            @RequestParam(required = false) String tenTruyen,
            @RequestParam(required = false) Long idTacGia,
            @RequestParam(required = false) Long idTheLoai,
            @RequestParam(required = false) boolean isFull
    ) {
        Integer countTruyen = truyenService.countTruyen(tenTruyen, idTacGia, idTheLoai, isFull);
        return new ResponseEntity<>(countTruyen, HttpStatus.OK);
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

    @PutMapping("/{id}")
    public ResponseEntity<Truyen> updateTruyen(@PathVariable Long id, @ModelAttribute @Valid TruyenRequest truyenRequest) {
        Truyen truyen = truyenService.updateTruyen(id, truyenRequest);
        return new ResponseEntity<>(truyen, HttpStatus.OK);
    }
}
