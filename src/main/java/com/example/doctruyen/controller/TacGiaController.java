package com.example.doctruyen.controller;

import com.example.doctruyen.service.TacGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tac-gia")
@RequiredArgsConstructor
public class TacGiaController {

    private final TacGiaService tacGiaService;
}
