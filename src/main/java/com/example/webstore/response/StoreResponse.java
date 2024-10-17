package com.example.webstore.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StoreResponse {
    private String id;
    private String storeName;
    private String address;
    private String email;
    private String sdt;
    private Double price;
    private String dateCreate;
    private String dateUpdate;

    public StoreResponse() {
    }

    public StoreResponse(String id, String storeName, String address, String email, String sdt, Double price, String dateCreate, String dateUpdate) {
        this.id = id;
        this.storeName = storeName;
        this.address = address;
        this.email = email;
        this.sdt = sdt;
        this.price = price;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }
}
