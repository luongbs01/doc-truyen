package com.example.doctruyen.service;

import com.example.doctruyen.dto.ChuongRequest;
import com.example.doctruyen.exeption.GlobalException;
import com.example.doctruyen.model.Chuong;
import com.example.doctruyen.model.Truyen;
import com.example.doctruyen.repository.ChuongRepository;
import com.example.doctruyen.repository.TruyenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChuongService {

    private final ChuongRepository chuongRepository;
    private final TruyenRepository truyenRepository;
    private final FileService fileService;

    public Chuong createChuong(ChuongRequest chuongRequest) {
        Truyen truyen = truyenRepository.findById(chuongRequest.getIdTruyen())
                .orElseThrow(() -> new GlobalException("Truyen voi id " + chuongRequest.getIdTruyen() + " khong ton tai"));
        if (chuongRepository.findByTruyenAndThuTuChuong(truyen, chuongRequest.getThuTuChuong()).isPresent()) {
            throw new GlobalException("Chuong " + chuongRequest.getThuTuChuong() + " da ton tai");
        }
        String urlNoiDungChuong = fileService.uploadFile(chuongRequest.getNoiDungChuong());
        Chuong chuong = Chuong.builder()
                .tieuDeChuong(chuongRequest.getTieuDeChuong())
                .urlNoiDungChuong(urlNoiDungChuong)
                .thuTuChuong(chuongRequest.getThuTuChuong())
                .truyen(truyen)
                .build();
        return chuongRepository.save(chuong);
    }

    public Chuong getChuong(Long id) {
        Chuong chuong = chuongRepository.findById(id)
                .orElseThrow(() -> new GlobalException("Chuong voi id " + id + " khong ton tai"));
        return chuong;
    }

    public List<Chuong> getChuongByIdTruyen(Long idTruyen) {
        Truyen truyen = truyenRepository.findById(idTruyen)
                .orElseThrow(() -> new GlobalException("Truyen voi id " + idTruyen + " khong ton tai"));
        List<Chuong> danhSachChuong = chuongRepository.findAllByTruyen(truyen)
                .orElseThrow(() -> new GlobalException("Truyen chua co chuong"));
        return danhSachChuong;
    }

    public void xoaChuong(Long id) {
        chuongRepository.deleteById(id);
    }
}
