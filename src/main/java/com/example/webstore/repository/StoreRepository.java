package com.example.webstore.repository;

import com.example.webstore.entity.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {


    Optional<Store> findByStoreNameIn(String storeName);

    Optional<Store> findByEmailIn(String email);

    Optional<Store> findByAddressIn(String address);

    Optional<Store> findBySdtIn(String sdt);

    Optional<Store> findByPriceIn(Double price);

    Optional<Store> findByDateCreateIn(String dateCreate);

    Optional<Store> findByDateUpdateIn(String dateUpdate);

}
