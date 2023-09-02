package com.example.doctruyen.controller;

import com.example.doctruyen.dto.TacGiaRequest;
import com.example.doctruyen.model.TacGia;
import com.example.doctruyen.service.TacGiaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tac-gia")
@RequiredArgsConstructor
public class TacGiaController {

    private final TacGiaService tacGiaService;

    @PostMapping
    public ResponseEntity<TacGia> createTacGia(@RequestBody @Valid TacGiaRequest tacGiaRequest) {
        TacGia tacGia = tacGiaService.createTacGia(tacGiaRequest);
        return new ResponseEntity<>(tacGia, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<TacGia>> listTacGia(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sort
    ) {
        Page<TacGia> danhSachTacGia = tacGiaService.listTacGia(page, size, sort);
        return new ResponseEntity<>(danhSachTacGia, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TacGia> getTacGia(@PathVariable Long id) {
        TacGia tacGia = tacGiaService.getTacGia(id);
        return new ResponseEntity<>(tacGia, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTacGia(@PathVariable Long id) {
        tacGiaService.xoaTacGia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TacGia> updateTacGia(@PathVariable Long id, @RequestBody TacGiaRequest tacGiaRequest) {
        TacGia tacGia = tacGiaService.updateTacGia(id, tacGiaRequest);
        return new ResponseEntity<>(tacGia, HttpStatus.OK);
    }
}
