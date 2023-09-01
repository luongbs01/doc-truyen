package com.example.doctruyen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChuong;
    private String tieuDeChuong;
    private String noiDungChuong;
    private Integer thuTuChuong;

    @ManyToOne
    @JoinColumn(name = "idTruyen", referencedColumnName = "idTruyen")
    private Truyen truyen;
}
