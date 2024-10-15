package com.example.webstore.controller;

import com.example.webstore.entity.Store;
import com.example.webstore.repository.StoreRepository;
import com.example.webstore.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/add")
    public ResponseEntity<String> createStore(@RequestBody Store store) {
        if(storeService.isEmptyNameStore(store.getStoreName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("StoreName đã tồn tại");
        }
        if(storeService.isEmptyEmail(store.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email đã tồn tại");
        }
        storeService.addStore(store);
        return ResponseEntity.status(HttpStatus.CREATED).body("Thêm mới thành công");
    }

    @GetMapping("/get-store")
    public ResponseEntity<List<Store>> getStore(){
        List<Store> store1 = storeService.getAllStore();
        return ResponseEntity.ok(store1);
    }
    @GetMapping("/get-store-by-name/{name}")
    public ResponseEntity<Store> getStoreName(@PathVariable String name) {
        var t =  storeService.getStoreByName(name);
            return ResponseEntity.ok(t.get());
    }
}
