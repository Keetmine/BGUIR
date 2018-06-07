package com.ivanov.accounting.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ivanov.accounting.R;
import com.ivanov.accounting.realm.user;

import java.util.ArrayList;
import java.util.HashMap;

import io.realm.Realm;
import io.realm.RealmResults;

public class UsersActivity extends AppCompatActivity {

    Realm realm;

    ArrayList<HashMap<String, String>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        realm = Realm.getDefaultInstance();
        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_users);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateActivity();
            }
        });


        ListView listView = (ListView)findViewById(R.id.UserList);

        ArrayList<String> usersNames = new ArrayList<String>();

        RealmResults<user> users = realm.where(user.class).findAll();

        arrayList = new ArrayList<>();
        HashMap<String, String> map;

        for (user User: users) {
            map = new HashMap<>();
            map.put("Name", User.login);
            map.put("id", User.id);
            arrayList.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.row,
                new String[]{"Name", "id"},
                new int[]{R.id.text123, R.id.id});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String idItem = arrayList.get(position).get("id");

                editEntityActivity(idItem);
            }
        });

    }

    public void openCreateActivity() {
        Intent intent = new Intent(this, CreateUserActivity.class);
        this.startActivity(intent);
    }

    public void editEntityActivity(String id) {
        Intent intent = new Intent(this, CreateUserActivity.class);
        intent.putExtra("id",id);
        this.startActivity(intent);
    }


}
