package com.example.doctruyen.dto;

import com.example.doctruyen.validation.AllowedFileTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChuongRequest {
    @NotBlank(message = "Vui long nhap tieu de")
    private String tieuDeChuong;
    @NotNull(message = "Vui long nhap noi dung")
    @AllowedFileTypes(allowedTypes = {"application/json"})
    private MultipartFile noiDungChuong;
    @Positive(message = "Thu tu chuong la so tu nhien")
    private Integer thuTuChuong;
    @NotNull(message = "Vui long nhap id truyen")
    private Long idTruyen;
}
