package com.example.webstore.exception;

import com.example.webstore.entity.Store;
import com.example.webstore.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ApService {
    @Autowired
    private StoreRepository storeRepository;
    public Optional<Store> getStoreByName(String name) {
        Optional<Store> storeOptional = storeRepository.findByStoreNameIn(name);
        if (storeOptional.isPresent()) {
            throw new ApException(404, "User not found");
        }
        return Optional.empty();
    }
}
