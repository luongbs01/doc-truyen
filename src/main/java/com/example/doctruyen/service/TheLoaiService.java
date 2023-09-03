package com.example.doctruyen.service;

import com.example.doctruyen.dto.TheLoaiRequest;
import com.example.doctruyen.exeption.GlobalException;
import com.example.doctruyen.model.TheLoai;
import com.example.doctruyen.repository.TheLoaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TheLoaiService {

    private final TheLoaiRepository theLoaiRepository;

    public TheLoai createTheLoai(TheLoaiRequest theLoaiRequest) {
        if (theLoaiRepository.findByTenTheLoai(theLoaiRequest.getTenTheLoai()).isPresent()) {
            throw new GlobalException("Ten the loai da ton tai");
        }
        TheLoai theLoai = new TheLoai();
        theLoai.setTenTheLoai(theLoaiRequest.getTenTheLoai());
        return theLoaiRepository.save(theLoai);
    }

    public Page<TheLoai> listTheLoai(int page, int size, String sort) {
        Optional<String> sortOptional = Optional.ofNullable(sort);
        if (sortOptional.isPresent()) {
            return theLoaiRepository.findAll(PageRequest.of(page, size, Sort.by(sort)));
        }
        return theLoaiRepository.findAll(PageRequest.of(page, size));
    }

    public TheLoai getTheLoai(Long id) {
        TheLoai theLoai = theLoaiRepository.findById(id)
                .orElseThrow(() -> new GlobalException("The loai voi id " + id + " khong ton tai"));
        return theLoai;
    }

    public void xoaTheLoai(Long id) {
        theLoaiRepository.deleteById(id);
    }

    @Transactional
    public TheLoai updateTheLoai(Long id, TheLoaiRequest theLoaiRequest) {
        if (theLoaiRepository.findByTenTheLoai(theLoaiRequest.getTenTheLoai()).isPresent()) {
            throw new GlobalException("Ten the loai da ton tai");
        }
        TheLoai theLoai = theLoaiRepository.findById(id)
                .orElseThrow(() -> new GlobalException("The loai voi id " + id + " khong ton tai"));
        theLoai.setTenTheLoai(theLoaiRequest.getTenTheLoai());
        return theLoaiRepository.save(theLoai);
    }
}
