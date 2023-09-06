package com.example.doctruyen.dto;

import com.example.doctruyen.validation.AllowedFileTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TruyenRequest {
    @NotBlank(message = "Vui long nhap truyen")
    private String tenTruyen;
    @NotNull(message = "Vui long gan anh")
    @AllowedFileTypes(allowedTypes = {"image/jpeg", "image/png"})
    private MultipartFile anh;
    private String moTa;
    private String nguon;
    @NotNull(message = "Vui long nhap id tac gia")
    private Long idTacGia;
    private Long[] idTheLoai;
}
