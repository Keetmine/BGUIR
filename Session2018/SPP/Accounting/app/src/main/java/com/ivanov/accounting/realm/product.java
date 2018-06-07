package com.ivanov.accounting.realm;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class product extends RealmObject {
    @PrimaryKey
    public String id = UUID.randomUUID().toString();
    public String name;
    public String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.ivanov.accounting.realm.company getCompany() {
        return company;
    }

    public void setCompany(com.ivanov.accounting.realm.company company) {
        this.company = company;
    }

    public com.ivanov.accounting.realm.group getGroup() {
        return group;
    }

    public void setGroup(com.ivanov.accounting.realm.group group) {
        this.group = group;
    }

    public company company;
    public group group;

    @Override
    public String toString() {
        return name;
    }
}