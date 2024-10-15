package com.example.webstore.repository;

import com.example.webstore.entity.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {
    Optional<Store> findByStoreName(String storeName);

    Optional<Store> findByEmail(String email);
}
