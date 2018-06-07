package com.ivanov.accounting.realm;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class user extends RealmObject {
    @PrimaryKey
    public String id = UUID.randomUUID().toString();
    public String login;
    public String password;
    public role role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public com.ivanov.accounting.realm.role getRole() {
        return role;
    }

    public void setRole(com.ivanov.accounting.realm.role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return getLogin();
    }
}