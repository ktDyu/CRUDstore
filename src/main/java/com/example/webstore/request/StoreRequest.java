package com.example.webstore.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class StoreRequest {
    private String id;

    @NotEmpty(message = "Không bỏ trống tên store")
    private String storeName;

    private String address;
    @NotEmpty(message = "Không bỏ trống email")
    private String email;
    private String sdt;

    private Double price;
}
