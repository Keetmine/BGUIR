package com.ivanov.accounting.realm;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class employee extends RealmObject {
    @PrimaryKey
    public String id = UUID.randomUUID().toString();
    public String fio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return fio;
    }
}