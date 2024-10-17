package com.example.webstore.request;

import lombok.Getter;

@Getter
public class StoreRequest {
    private String id;
    private String storeName;
    private String address;
    private String email;
    private String sdt;
    private Double price;
    private String dateCreate;
    private String dateUpdate;
}
