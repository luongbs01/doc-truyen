package com.example.doctruyen.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheLoaiRequest {
    @NotBlank(message = "Vui long nhap ten the loai")
    private String tenTheLoai;
}
