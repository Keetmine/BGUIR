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
import com.ivanov.accounting.realm.actionType;
import com.ivanov.accounting.realm.company;

import java.util.UUID;

import io.realm.Realm;

public class CreateCompanyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_company);
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
    EditText descriptionEdit;
    EditText adress;
    EditText phone;

    Realm realm;

    company EditEntity;

    Boolean isEdit = false;

    String editId;


    private void setup(){
        nameEdit = (EditText) findViewById(R.id.name);
        descriptionEdit = (EditText) findViewById(R.id.description);
        adress = (EditText) findViewById(R.id.adres);
        phone = (EditText) findViewById(R.id.phone);

        realm = Realm.getDefaultInstance();

        Intent myIntent = getIntent();

        editId = myIntent.getStringExtra("id");

        if(!TextUtils.isEmpty(editId)){
            company Entity = realm.where(company.class).equalTo("id", editId).findFirst();
            if(Entity != null)
            {
                isEdit = true;
                EditEntity = Entity;
            }
        }

        if(EditEntity != null){
            nameEdit.setText(EditEntity.getName());
            descriptionEdit.setText(EditEntity.getDescription());
            adress.setText(EditEntity.getAddress());
            phone.setText(EditEntity.getPhone());
        }

    }

    private void createEntity(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                company newUser;

                if(editId != null){
                    newUser = bgRealm.where(company.class).equalTo("id", editId).findFirst();
                } else {
                    newUser = bgRealm.createObject(company.class, UUID.randomUUID().toString());
                }

                newUser.setName(nameEdit.getText().toString());
                newUser.setDescription(descriptionEdit.getText().toString());
                newUser.setAddress(adress.getText().toString());
                newUser.setPhone(phone.getText().toString());


            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                ifSuccessSave();
            }
        });
    }

    private void ifSuccessSave(){
        Intent intent = new Intent(this, CompanyActivity.class);
        this.startActivity(intent);

        Toast.makeText(this.getApplication(), "success add entity",
                Toast.LENGTH_LONG).show();
    }

}