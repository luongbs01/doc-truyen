package com.example.doctruyen.service;

import com.example.doctruyen.dto.TruyenRequest;
import com.example.doctruyen.exeption.GlobalException;
import com.example.doctruyen.mapper.TruyenMapper;
import com.example.doctruyen.model.Truyen;
import com.example.doctruyen.repository.TruyenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Truyen> searchTruyen(String tenTruyen, Long idTacGia, Long idTheLoai, Boolean isFull, Integer page, Integer size) {
        List<Truyen> danhSachTruyen = truyenRepository.searchTruyen(tenTruyen, idTacGia, idTheLoai, isFull, page, size);
        return danhSachTruyen;
    }

    public Integer countTruyen(String tenTruyen, Long idTacGia, Long idTheLoai, Boolean isFull) {
        Integer countTruyen = truyenRepository.countTruyen(tenTruyen, idTacGia, idTheLoai, isFull);
        return countTruyen;
    }

    public Truyen getTruyen(Long id) {
        Truyen truyen = truyenRepository.findById(id)
                .orElseThrow(() -> new GlobalException("Truyen voi id " + id + " khong ton tai"));
        return truyen;
    }

    public void xoaTruyen(Long id) {
        truyenRepository.deleteById(id);
    }

    @Transactional
    public Truyen updateTruyen(Long id, TruyenRequest truyenRequest) {
        Truyen before = truyenRepository.findById(id)
                .orElseThrow(() -> new GlobalException("Truyen voi id " + id + " khong ton tai"));
        Truyen truyen = truyenMapper.mapUpdate(truyenRequest);
        truyen.setIdTruyen(id);
        if (truyenRequest.getAnh() == null) {
            truyen.setUrlAnh(before.getUrlAnh());
        }
        return truyenRepository.save(truyen);
    }
}
