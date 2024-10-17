package com.example.webstore.service;

import com.example.webstore.entity.Store;
import com.example.webstore.repository.StoreRepository;
import com.example.webstore.request.StoreRequest;
import com.example.webstore.response.StorePageResponse;
import com.example.webstore.response.StoreResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final MongoTemplate mongoTemplate;
    private final StoreRepository storeRepository;


    public StoreService(MongoTemplate mongoTemplate, StoreRepository storeRepository) {
        this.mongoTemplate = mongoTemplate;
        this.storeRepository = storeRepository;
    }

    public Store addStore(Store store) {
        store.setDateCreate(ZonedDateTime.now().toString());
        return storeRepository.save(store);
    }

    public List<Store> getAllStore() {
        return storeRepository.findAll();
    }

    public boolean isEmptyNameStore(String name) {
        return storeRepository.findByStoreNameIn(name).isPresent();
    }

    public boolean isEmptyEmail(String email) {
        return storeRepository.findByEmailIn(email).isPresent();
    }

    public Optional<Store> getStoreByName(String name) {
        return storeRepository.findByStoreNameIn(name);
    }

    public Optional<Store> updateStore(String id, Store store) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if (storeOptional.isPresent()) {
            Store store1 = storeOptional.get();

            store1.setStoreName(store.getStoreName());
            store1.setAddress(store.getAddress());
            store1.setEmail(store.getEmail());
            store1.setSdt(store.getSdt());
            store1.setPrice(store.getPrice());
            store1.setDateUpdate(ZonedDateTime.now().toString());

            storeRepository.save(store1);
            return Optional.of(store1);
        } else {
            return Optional.empty();
        }
    }

    public StorePageResponse getAllStorePage(int page, int size) {
        Page<Store> storePage = storeRepository.findAll(PageRequest.of(page, size));

//        int totalNumbers = listStore.size();
//        int totalPages = totalNumbers/size+1;
//
//        List<Store> listPage = new ArrayList<>();
//
//        int min = page * size;
//        int max = Math.min(min+size,totalNumbers);
//        for (int i = min; i < max; i++) {
//           listPage.add(listStore.get(i));
//        }
        return new StorePageResponse(storePage.getContent(), storePage.getTotalPages(), (int) storePage.getTotalElements());
    }


    public List<StoreResponse> searchStore(StoreRequest storeRequest) {
        Query query = new Query();

        if (storeRequest.getId() != null && !storeRequest.getId().isEmpty()) {
            query.addCriteria(Criteria.where("id").is(storeRequest.getId()));
        }
        if (storeRequest.getStoreName() != null && !storeRequest.getStoreName().isEmpty()) {
            query.addCriteria(Criteria.where("store_name").is(storeRequest.getStoreName()));
        }
        if (storeRequest.getAddress() != null && !storeRequest.getAddress().isEmpty()) {
            query.addCriteria(Criteria.where("address").is(storeRequest.getAddress()));
        }
        if (storeRequest.getEmail() != null && !storeRequest.getEmail().isEmpty()) {
            query.addCriteria(Criteria.where("email").is(storeRequest.getEmail()));
        }
        if (storeRequest.getSdt() != null && !storeRequest.getSdt().isEmpty()) {
            query.addCriteria(Criteria.where("sdt").is(storeRequest.getSdt()));
        }
        if (storeRequest.getPrice() != null) {
            query.addCriteria(Criteria.where("price").is(storeRequest.getPrice()));
        }
        if (storeRequest.getDateCreate() != null && !storeRequest.getDateCreate().isEmpty()) {
            query.addCriteria(Criteria.where("date_create").is(storeRequest.getDateCreate()));
        }
        if (storeRequest.getDateUpdate() != null && !storeRequest.getDateUpdate().isEmpty()) {
            query.addCriteria(Criteria.where("date_update").is(storeRequest.getDateUpdate()));
        }

        List<Store> stores = mongoTemplate.find(query, Store.class);
        return stores.stream().map(store -> {
            StoreResponse storeResponse = new StoreResponse();
            storeResponse.setId(store.getId());
            storeResponse.setStoreName(store.getStoreName());
            storeResponse.setAddress(store.getAddress());
            storeResponse.setEmail(store.getEmail());
            storeResponse.setSdt(store.getSdt());
            storeResponse.setPrice(store.getPrice());
            storeResponse.setDateCreate(store.getDateCreate());
            storeResponse.setDateUpdate(store.getDateUpdate());

            return storeResponse;
        }).collect(Collectors.toList());
    }

}
