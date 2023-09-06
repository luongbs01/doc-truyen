package com.example.doctruyen.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Truyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTruyen;
    private String tenTruyen;
    private String urlAnh;
    private String moTa;
    private Instant ngayDang;
    private String nguon;
    private boolean full;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "truyen_the_loai",
            joinColumns = @JoinColumn(name = "idTruyen"),
            inverseJoinColumns = @JoinColumn(name = "idTheLoai")
    )
    private Set<TheLoai> danhSachTheLoai;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "idTacGia", referencedColumnName = "idTacGia")
    private TacGia tacGia;
}
