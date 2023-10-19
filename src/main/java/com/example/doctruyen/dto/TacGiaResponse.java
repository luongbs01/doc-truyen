package com.example.doctruyen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TacGiaResponse {
    private Long idTacGia;
    private String tenTacGia;
    private Integer soTacPham;
}
