package com.example.doctruyen.repository;

import com.example.doctruyen.model.Chuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuongRepository extends JpaRepository<Chuong, Long> {
}
