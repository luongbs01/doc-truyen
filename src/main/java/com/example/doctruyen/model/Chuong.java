package com.example.doctruyen.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Chuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChuong;
    private String tieuDeChuong;
    private String urlNoiDungChuong;
    private Integer thuTuChuong;

    @ManyToOne
    @JoinColumn(name = "idTruyen", referencedColumnName = "idTruyen")
    private Truyen truyen;
}
