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
import com.ivanov.accounting.realm.action;
import com.ivanov.accounting.realm.actionType;

import java.util.ArrayList;
import java.util.HashMap;

import io.realm.Realm;
import io.realm.RealmResults;

public class ActionsActivity extends AppCompatActivity {

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

        RealmResults<action> entityes = realm.where(action.class).findAll();

        arrayList = new ArrayList<>();
        HashMap<String, String> map;

        for (action Entity: entityes) {
            map = new HashMap<>();
            map.put("Name", Entity.getDescription());
            map.put("id", Entity.getId());
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
        Intent intent = new Intent(this, CreateActionActivity.class);
        this.startActivity(intent);
    }

    public void editEntityActivity(String id) {
        Intent intent = new Intent(this, CreateActionActivity.class);
        intent.putExtra("id",id);
        this.startActivity(intent);
    }

}