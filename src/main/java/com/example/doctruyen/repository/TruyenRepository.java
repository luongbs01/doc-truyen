package com.example.doctruyen.repository;

import com.example.doctruyen.model.Truyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TruyenRepository extends JpaRepository<Truyen, Long> {
    Optional<Truyen> findByTenTruyen(String tenTruyen);
}
