package com.ivanov.accounting.realm;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class action extends RealmObject {
    @PrimaryKey
    public String id = UUID.randomUUID().toString();
    public actionType actionType;
    public product product;
    public String price;
    public String description;
    public employee employee;
    public reason reason;

    @Override
    public String toString() {
        return description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public com.ivanov.accounting.realm.actionType getActionType() {
        return actionType;
    }

    public void setActionType(com.ivanov.accounting.realm.actionType actionType) {
        this.actionType = actionType;
    }

    public com.ivanov.accounting.realm.product getProduct() {
        return product;
    }

    public void setProduct(com.ivanov.accounting.realm.product product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.ivanov.accounting.realm.employee getEmployee() {
        return employee;
    }

    public void setEmployee(com.ivanov.accounting.realm.employee employee) {
        this.employee = employee;
    }

    public com.ivanov.accounting.realm.reason getReason() {
        return reason;
    }

    public void setReason(com.ivanov.accounting.realm.reason reason) {
        this.reason = reason;
    }

    public com.ivanov.accounting.realm.status getStatus() {
        return status;
    }

    public void setStatus(com.ivanov.accounting.realm.status status) {
        this.status = status;
    }

    public status status;
}
