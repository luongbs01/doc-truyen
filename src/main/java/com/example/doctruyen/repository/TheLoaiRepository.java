package com.example.doctruyen.repository;

import com.example.doctruyen.model.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai, Long> {
    Optional<TheLoai> findByTenTheLoai(String tenTheLoai);
}
