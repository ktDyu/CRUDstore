package com.example.webstore.response;

import com.example.webstore.entity.Store;

import java.util.List;

public class StorePageResponse {
    private List<Store> stores;
    private int pageTotal;
    private int numberTotal;

    public StorePageResponse(List<Store> stores, int pageTotal, int numberTotal) {
        this.stores = stores;
        this.pageTotal = pageTotal;
        this.numberTotal = numberTotal;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getNumberTotal() {
        return numberTotal;
    }

    public void setNumberTotal(int numberTotal) {
        this.numberTotal = numberTotal;
    }
}
