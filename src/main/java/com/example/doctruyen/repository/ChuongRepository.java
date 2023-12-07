package com.example.doctruyen.repository;

import com.example.doctruyen.model.Chuong;
import com.example.doctruyen.model.Truyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChuongRepository extends JpaRepository<Chuong, Long> {
    Optional<Chuong> findByTruyenAndThuTuChuong(Truyen truyen, Integer thuTuChuong);

    Optional<List<Chuong>> findAllByTruyen(Truyen truyen);
}
