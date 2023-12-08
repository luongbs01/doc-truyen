package com.example.doctruyen.repository;

import com.example.doctruyen.model.Truyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TruyenRepository extends JpaRepository<Truyen, Long> {
    Optional<Truyen> findByTenTruyen(String tenTruyen);

    @Query(nativeQuery = true,
            value = "SELECT DISTINCT " +
                    "t.* " +
                    "FROM truyen t, truyen_the_loai ttl " +
                    "WHERE (?1 IS NULL OR t.ten_truyen LIKE CONCAT('%', ?1, '%')) " +
                    "AND (?2 IS NULL OR t.id_tac_gia = ?2) " +
                    "AND (?3 IS NULL OR ttl.id_the_loai = ?3) " +
                    "ORDER BY t.id_truyen " +
                    "LIMIT ?5 OFFSET ?4")
    List<Truyen> searchTruyen(String tenTruyen, Long idTacGia, Long idTheLoai, Integer page, Integer size);
}
