package com.example.doctruyen.repository;

import com.example.doctruyen.model.TacGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TacGiaRepository extends JpaRepository<TacGia, Long> {
    Optional<TacGia> findByTenTacGia(String tenTacGia);
//    Optional<List<TacGia>> findAll();
}
