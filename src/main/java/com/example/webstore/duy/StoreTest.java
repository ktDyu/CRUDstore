package com.example.webstore.duy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class StoreTest {
    @PostConstruct
    public void postConstruct() {
        System.out.println("\t>> Đối tượng Girl sau khi khởi tạo xong sẽ chạy hàm này");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("\t>> Đối tượng Girl trước khi bị destroy thì chạy hàm này");
    }

}
