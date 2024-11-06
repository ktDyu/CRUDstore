package com.example.webstore.controller;

import com.example.webstore.entity.Store;
import com.example.webstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/test")
public class NewController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/info")
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // Đây luôn trả về 400
    public ResponseEntity<Store> getStore(@RequestParam("name") String name) {
        // Tìm User trong database bằng username
        var store = storeService.getStoreByName(name);

        // Nếu không tìm thấy, trả về message lỗi 404 Not found
        if (!store.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        // Nếu tìm thấy return 200 OK
        return ResponseEntity.ok(store.get());
    }



}
