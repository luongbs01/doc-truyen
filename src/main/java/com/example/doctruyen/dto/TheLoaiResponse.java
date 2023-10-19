package com.example.doctruyen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheLoaiResponse {
    private Long idTheLoai;
    private String tenTheLoai;
    private Integer soTacPham;
}
