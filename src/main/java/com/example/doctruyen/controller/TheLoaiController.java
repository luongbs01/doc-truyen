package com.example.doctruyen.controller;

import com.example.doctruyen.dto.TheLoaiRequest;
import com.example.doctruyen.dto.TheLoaiResponse;
import com.example.doctruyen.model.TheLoai;
import com.example.doctruyen.service.TheLoaiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/the-loai")
@RequiredArgsConstructor
public class TheLoaiController {

    private final TheLoaiService theLoaiService;

    @PostMapping
    public ResponseEntity<TheLoai> createTheLoai(@RequestBody @Valid TheLoaiRequest theLoaiRequest) {
        TheLoai theLoai = theLoaiService.createTheLoai(theLoaiRequest);
        return new ResponseEntity<>(theLoai, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<TheLoaiResponse>> listTheLoai(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sort
    ) {
        Page<TheLoaiResponse> danhSachTheLoai = theLoaiService.listTheLoai(page, size, sort);
        return new ResponseEntity<>(danhSachTheLoai, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TheLoai>> listAll() {
        List<TheLoai> danhSachTheLoai = theLoaiService.listAll();
        return new ResponseEntity<>(danhSachTheLoai, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheLoaiResponse> getTheLoai(@PathVariable Long id) {
        TheLoaiResponse theLoai = theLoaiService.getTheLoai(id);
        return new ResponseEntity<>(theLoai, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTheLoai(@PathVariable Long id) {
        theLoaiService.xoaTheLoai(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheLoai> updateTheLoai(@PathVariable Long id, @RequestBody @Valid TheLoaiRequest theLoaiRequest) {
        TheLoai theLoai = theLoaiService.updateTheLoai(id, theLoaiRequest);
        return new ResponseEntity<>(theLoai, HttpStatus.OK);
    }
}
