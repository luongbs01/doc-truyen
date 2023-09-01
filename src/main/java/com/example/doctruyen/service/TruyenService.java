package com.example.doctruyen.service;

import com.example.doctruyen.repository.TruyenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TruyenService {

    private final TruyenRepository truyenRepository;
}
