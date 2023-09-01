package com.example.doctruyen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Truyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTruyen;
    private String tenTruyen;
    private String moTa;
    private Instant ngayDang;

    @ManyToMany
    @JoinTable(
            name = "truyen_the_loai",
            joinColumns = @JoinColumn(name = "idTruyen"),
            inverseJoinColumns = @JoinColumn(name = "idTheLoai")
    )
    private List<TheLoai> danhSachTheLoai;

    @ManyToOne
    @JoinColumn(name = "idTacGia", referencedColumnName = "idTacGia")
    private TacGia tacGia;
}
