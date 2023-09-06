package com.example.doctruyen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTacGia;
    private String tenTacGia;

    @JsonBackReference
    @OneToMany(mappedBy = "tacGia")
    private Set<Truyen> danhSachTruyen;
}
