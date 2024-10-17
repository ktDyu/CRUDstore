package com.example.webstore.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.ZonedDateTime;

@Getter
@Setter
@Document(collection = "stores")
public class Store {
    @Id
    private String id;

    @Field(name = "store_name")
    private String storeName;

    @Field(name = "address")
    private String address;

    @Field(name = "email")
    private String email;

    @Field(name = "sdt")
    private String sdt;

    @Field(name = "price")
    private Double price;

    @Field(name = "date_create")
    private String dateCreate;

    @Field(name = "date_update")
    private String dateUpdate;
}
