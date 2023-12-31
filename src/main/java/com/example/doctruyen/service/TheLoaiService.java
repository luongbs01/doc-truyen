package com.example.doctruyen.service;

import com.example.doctruyen.dto.TheLoaiRequest;
import com.example.doctruyen.dto.TheLoaiResponse;
import com.example.doctruyen.exeption.GlobalException;
import com.example.doctruyen.mapper.TheLoaiMapper;
import com.example.doctruyen.model.TheLoai;
import com.example.doctruyen.repository.TheLoaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TheLoaiService {

    private final TheLoaiRepository theLoaiRepository;
    private final TheLoaiMapper theLoaiMapper;

    public TheLoai createTheLoai(TheLoaiRequest theLoaiRequest) {
        if (theLoaiRepository.findByTenTheLoai(theLoaiRequest.getTenTheLoai()).isPresent()) {
            throw new GlobalException("Ten the loai da ton tai");
        }
        TheLoai theLoai = new TheLoai();
        theLoai.setTenTheLoai(theLoaiRequest.getTenTheLoai());
        return theLoaiRepository.save(theLoai);
    }

    public Page<TheLoaiResponse> listTheLoai(int page, int size, String sort) {
        Optional<String> sortOptional = Optional.ofNullable(sort);
        if (sortOptional.isPresent()) {
            return theLoaiRepository.findAll(PageRequest.of(page, size, Sort.by(sort)))
                    .map(theLoaiMapper::mapToResponse);
        }
        return theLoaiRepository.findAll(PageRequest.of(page, size))
                .map(theLoaiMapper::mapToResponse);
    }

    public List<TheLoai> listAll() {
        return theLoaiRepository.findAll();
    }

    public TheLoaiResponse getTheLoai(Long id) {
        TheLoaiResponse theLoai = theLoaiRepository.findById(id)
                .map(theLoaiMapper::mapToResponse)
                .orElseThrow(() -> new GlobalException("The loai voi id " + id + " khong ton tai"));
        return theLoai;
    }

    public void xoaTheLoai(Long id) {
        theLoaiRepository.deleteById(id);
    }

    @Transactional
    public TheLoai updateTheLoai(Long id, TheLoaiRequest theLoaiRequest) {
        TheLoai theLoai = theLoaiRepository.findById(id)
                .orElseThrow(() -> new GlobalException("The loai voi id " + id + " khong ton tai"));
        theLoai.setTenTheLoai(theLoaiRequest.getTenTheLoai());
        return theLoaiRepository.save(theLoai);
    }
}
