package com.example.doctruyen.service;

import com.example.doctruyen.dto.TruyenRequest;
import com.example.doctruyen.exeption.GlobalException;
import com.example.doctruyen.mapper.TruyenMapper;
import com.example.doctruyen.model.TacGia;
import com.example.doctruyen.model.TheLoai;
import com.example.doctruyen.model.Truyen;
import com.example.doctruyen.repository.TacGiaRepository;
import com.example.doctruyen.repository.TheLoaiRepository;
import com.example.doctruyen.repository.TruyenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TruyenService {

    private final TruyenRepository truyenRepository;
    private final TruyenMapper truyenMapper;

    @Transactional
    public Truyen createTruyen(TruyenRequest truyenRequest) {
        if (truyenRepository.findByTenTruyen(truyenRequest.getTenTruyen()).isPresent()) {
            throw new GlobalException("Ten truyen da ton tai");
        }
        Truyen truyen = truyenMapper.map(truyenRequest);
        return truyenRepository.save(truyen);
    }

    public Page<Truyen> listTruyen(int page, int size, String sort) {
        Optional<String> sortOptional = Optional.ofNullable(sort);
        if (sortOptional.isPresent()) {
            return truyenRepository.findAll(PageRequest.of(page, size, Sort.by(sort)));
        }
        return truyenRepository.findAll(PageRequest.of(page, size));
    }

    public Truyen getTruyen(Long id) {
        Truyen truyen = truyenRepository.findById(id)
                .orElseThrow(() -> new GlobalException("Truyen voi id " + id + " khong ton tai"));
        return truyen;
    }

    public void xoaTruyen(Long id) {
        truyenRepository.deleteById(id);
    }
}
