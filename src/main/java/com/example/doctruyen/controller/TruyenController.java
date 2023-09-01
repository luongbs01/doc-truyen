package com.example.doctruyen.controller;

import com.example.doctruyen.service.TruyenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/truyen")
@RequiredArgsConstructor
public class TruyenController {

    private final TruyenService truyenService;
}
