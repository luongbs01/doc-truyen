package com.example.doctruyen.controller;

import com.example.doctruyen.service.TheLoaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/the-loai")
@RequiredArgsConstructor
public class TheLoaiController {

    private final TheLoaiService theLoaiService;
}
