package com.example.doctruyen.service;

import com.example.doctruyen.repository.ChuongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChuongService {

    private final ChuongRepository chuongRepository;
}
