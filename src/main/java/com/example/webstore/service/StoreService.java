package com.example.webstore.service;

import com.example.webstore.entity.Store;
import com.example.webstore.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public Store addStore(@RequestBody Store store){
        return storeRepository.save(store);
    }
    public List<Store> getAllStore(){
        return storeRepository.findAll();
    }
    public boolean isEmptyNameStore(String name){
        return storeRepository.findByStoreName(name).isPresent();
    }
    public boolean isEmptyEmail(String email){
        return storeRepository.findByEmail(email).isPresent();
    }
    public Optional<Store> getStoreByName(String name){
        return storeRepository.findByStoreName(name);
    }
}
