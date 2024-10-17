package com.example.webstore.service;

import com.example.webstore.entity.Store;
import com.example.webstore.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public Store addStore(Store store){
        store.setDateCreate(ZonedDateTime.now().toString());
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

    public Optional<Store> updateStore(String id,Store store){
        Optional<Store> storeOptional = storeRepository.findById(id);
        if(storeOptional.isPresent()){
            Store store1 = storeOptional.get();

            store1.setStoreName(store.getStoreName());
            store1.setAddress(store.getAddress());
            store1.setEmail(store.getEmail());
            store1.setSdt(store.getSdt());
            store1.setPrice(store.getPrice());
            store1.setDateUpdate(ZonedDateTime.now().toString());

             storeRepository.save(store1);
             return Optional.of(store1);
        }else{
           return Optional.empty();
        }
    }
}
