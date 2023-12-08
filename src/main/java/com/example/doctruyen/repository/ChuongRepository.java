package com.example.doctruyen.repository;

import com.example.doctruyen.model.Chuong;
import com.example.doctruyen.model.Truyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChuongRepository extends JpaRepository<Chuong, Long> {
    Optional<Chuong> findByTruyenAndThuTuChuong(Truyen truyen, Integer thuTuChuong);

    Optional<List<Chuong>> findAllByTruyen(Truyen truyen);

    @Query(nativeQuery = true, value = "SELECT * FROM chuong c " +
            "WHERE c.id_truyen = ?1 " +
            "ORDER BY c.thu_tu_chuong " +
            "LIMIT ?3 OFFSET ?2")
    List<Chuong> findAllByTruyenId(Long truyenId, Integer page, Integer size);
}
