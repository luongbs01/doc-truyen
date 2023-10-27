package com.example.doctruyen.controller;

import com.example.doctruyen.dto.ChuongRequest;
import com.example.doctruyen.model.Chuong;
import com.example.doctruyen.service.ChuongService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteChuong(@PathVariable Long id) {
        chuongService.xoaChuong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
