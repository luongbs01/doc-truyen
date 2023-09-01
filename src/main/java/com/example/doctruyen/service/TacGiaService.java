package com.example.doctruyen.service;

import com.example.doctruyen.repository.TacGiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TacGiaService {

    private final TacGiaRepository tacGiaRepository;
}
