package com.example.doctruyen.controller;

import com.example.doctruyen.service.ChuongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chuong")
@RequiredArgsConstructor
public class ChuongController {

    private final ChuongService chuongService;
}
