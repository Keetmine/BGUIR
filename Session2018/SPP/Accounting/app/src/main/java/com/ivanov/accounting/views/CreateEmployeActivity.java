package com.ivanov.accounting.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ivanov.accounting.R;
import com.ivanov.accounting.realm.employee;
import com.ivanov.accounting.realm.group;

import java.util.UUID;

import io.realm.Realm;

public class CreateEmployeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEntity();
            }
        });

        setup();
    }

    EditText nameEdit;

    Realm realm;

    employee EditEntity;

    Boolean isEdit = false;

    String editId;


    private void setup(){
        nameEdit = (EditText) findViewById(R.id.name);

        realm = Realm.getDefaultInstance();

        Intent myIntent = getIntent();

        editId = myIntent.getStringExtra("id");

        if(!TextUtils.isEmpty(editId)){
            employee Entity = realm.where(employee.class).equalTo("id", editId).findFirst();
            if(Entity != null)
            {
                isEdit = true;
                EditEntity = Entity;
            }
        }

        if(EditEntity != null){
            nameEdit.setText(EditEntity.getFio());
        }

    }

    private void createEntity(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                employee newUser;

                if(editId != null){
                    newUser = bgRealm.where(employee.class).equalTo("id", editId).findFirst();
                } else {
                    newUser = bgRealm.createObject(employee.class, UUID.randomUUID().toString());
                }

                newUser.setFio(nameEdit.getText().toString());


            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                ifSuccessSave();
            }
        });
    }

    private void ifSuccessSave(){
        Intent intent = new Intent(this, EmployeeActivity.class);
        this.startActivity(intent);

        Toast.makeText(this.getApplication(), "success add entity",
                Toast.LENGTH_LONG).show();
    }

}