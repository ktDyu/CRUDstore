package com.example.webstore.controller;

import com.example.webstore.entity.Store;
import com.example.webstore.response.StorePageResponse;
import com.example.webstore.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("")
    public ResponseEntity<String> createStore(@RequestBody Store store) {

        if (storeService.isEmptyNameStore(store.getStoreName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("StoreName đã tồn tại");
        }
        if (storeService.isEmptyEmail(store.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email đã tồn tại");
        }
        storeService.addStore(store);
        return ResponseEntity.status(HttpStatus.CREATED).body("Thêm mới thành công");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStore(@PathVariable String id,@RequestBody Store store1){
        if (storeService.isEmptyNameStore(store1.getStoreName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("StoreName đã tồn tại");
        }
        if (storeService.isEmptyEmail(store1.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email đã tồn tại");
        }
        storeService.updateStore(id,store1);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sửa thành công");
    }

    @GetMapping("")
    public ResponseEntity<List<Store>> getStore() {
        List<Store> store1 = storeService.getAllStore();
        return ResponseEntity.ok(store1);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Store> getStoreName(@PathVariable String name) {
        var t = storeService.getStoreByName(name).orElse(null);
        if(t==null){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(t);
    }
//    @GetMapping("/phan-trang")
//    public ResponseEntity<Page<Store>> getTrang(@RequestParam(defaultValue = "0") int page,
//                                                @RequestParam(defaultValue = "5") int size){
//        Pageable pageable = PageRequest.of(page, size);
//
//        Page<Store> c = storeService.getAllStores(pageable);
//        return ResponseEntity.ok(c);
//    }
    @GetMapping("/phan-trang")
    public ResponseEntity<StorePageResponse> getTrang(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5") int size) {
       StorePageResponse list = storeService.getAllStorePage(page,size);
        return ResponseEntity.ok(list);
    }
}
