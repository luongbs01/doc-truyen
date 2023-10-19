package com.example.doctruyen.service;

import com.example.doctruyen.dto.TacGiaRequest;
import com.example.doctruyen.dto.TacGiaResponse;
import com.example.doctruyen.exeption.GlobalException;
import com.example.doctruyen.mapper.TacGiaMapper;
import com.example.doctruyen.model.TacGia;
import com.example.doctruyen.repository.TacGiaRepository;
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
public class TacGiaService {

    private final TacGiaRepository tacGiaRepository;
    private final TacGiaMapper tacGiaMapper;

    public TacGia createTacGia(TacGiaRequest tacGiaRequest) {
        if (tacGiaRepository.findByTenTacGia(tacGiaRequest.getTenTacGia()).isPresent()) {
            throw new GlobalException("Ten tac gia da ton tai");
        }
        TacGia tacGia = new TacGia();
        tacGia.setTenTacGia(tacGiaRequest.getTenTacGia());
        return tacGiaRepository.save(tacGia);
    }

    public Page<TacGiaResponse> listTacGia(int page, int size, String sort) {
        Optional<String> sortOptional = Optional.ofNullable(sort);
        if (sortOptional.isPresent()) {
            return tacGiaRepository.findAll(PageRequest.of(page, size, Sort.by(sort)))
                    .map(tacGiaMapper::mapToResponse);
        }
        return tacGiaRepository.findAll(PageRequest.of(page, size))
                .map(tacGiaMapper::mapToResponse);
    }

    public List<TacGia> listAll() {
        return tacGiaRepository.findAll();
    }

    public TacGia getTacGia(Long id) {
        TacGia tacGia = tacGiaRepository.findById(id)
                .orElseThrow(() -> new GlobalException("Tac gia voi id " + id + " khong ton tai"));
        return tacGia;
    }

    public void xoaTacGia(Long id) {
        tacGiaRepository.deleteById(id);
    }

    @Transactional
    public TacGia updateTacGia(Long id, TacGiaRequest tacGiaRequest) {
        if (tacGiaRepository.findByTenTacGia(tacGiaRequest.getTenTacGia()).isPresent()) {
            throw new GlobalException("Ten tac gia da ton tai");
        }
        TacGia tacGia = tacGiaRepository.findById(id)
                .orElseThrow(() -> new GlobalException("Tac gia voi id " + id + " khong ton tai"));
        tacGia.setTenTacGia(tacGiaRequest.getTenTacGia());
        return tacGiaRepository.save(tacGia);
    }
}
