package com.example.webstore.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreRequest {
    private String id;

    @NotEmpty(message = "Không bỏ trống tên store")
    private String storeName;

    private String address;
    @NotEmpty(message = "Không bỏ trống email")
    @Email(message = "Email chưa đúng định dạng")
    private String email;

    private String sdt;

    private Double price;
}
