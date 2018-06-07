package com.ivanov.accounting.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ivanov.accounting.R;
import com.ivanov.accounting.realm.*;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;

public class CreateActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_action);
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

    Spinner employee;
    Spinner reason;
    EditText description;
    EditText price;
    Spinner actionType;
    Spinner product;
    Spinner status;
    Realm realm;

    action EditEntity;

    Boolean isEdit = false;

    String editId;


    ArrayList<employee> employeList;
    ArrayList<reason> reasonList;
    ArrayList<actionType> actionTypeList;
    ArrayList<product> productList;
    ArrayList<status> statusList;

    private void setup(){

        description = (EditText) findViewById(R.id.description);
        price = (EditText) findViewById(R.id.price);

        employee = (Spinner) findViewById(R.id.employee);
        reason = (Spinner) findViewById(R.id.reason);
        actionType = (Spinner) findViewById(R.id.actionType);
        product = (Spinner) findViewById(R.id.product);
        status = (Spinner) findViewById(R.id.status);


        realm = Realm.getDefaultInstance();

        employeList = new ArrayList(realm.where(employee.class).findAll());

        ArrayAdapter<employee> dataAdapter = new ArrayAdapter<employee>(this, android.R.layout.simple_spinner_item, employeList);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        employee.setAdapter(dataAdapter);


        actionTypeList = new ArrayList(realm.where(actionType.class).findAll());

        ArrayAdapter<actionType> dataAdapter3 = new ArrayAdapter<actionType>(this, android.R.layout.simple_spinner_item, actionTypeList);

        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        actionType.setAdapter(dataAdapter3);

        reasonList = new ArrayList(realm.where(reason.class).findAll());

        ArrayAdapter<reason> dataAdapter2 = new ArrayAdapter<reason>(this, android.R.layout.simple_spinner_item, reasonList);

        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        reason.setAdapter(dataAdapter2);

        productList = new ArrayList(realm.where(product.class).findAll());

        ArrayAdapter<product> dataAdapter4 = new ArrayAdapter<product>(this, android.R.layout.simple_spinner_item, productList);

        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        product.setAdapter(dataAdapter4);

        statusList = new ArrayList(realm.where(status.class).findAll());

        ArrayAdapter<status> dataAdapter5 = new ArrayAdapter<status>(this, android.R.layout.simple_spinner_item, statusList);

        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        status.setAdapter(dataAdapter5);

        Intent myIntent = getIntent();

        editId = myIntent.getStringExtra("id");

        if(!TextUtils.isEmpty(editId)){
            action Entity = realm.where(action.class).equalTo("id", editId).findFirst();
            if(Entity != null)
            {
                isEdit = true;
                EditEntity = Entity;
            }
        }

        if(EditEntity != null){
            description.setText(EditEntity.getDescription());
            price.setText(EditEntity.getPrice());
        }

    }

    private void createEntity(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                action newUser;

                if(editId != null){
                    newUser = bgRealm.where(action.class).equalTo("id", editId).findFirst();
                } else {
                    newUser = bgRealm.createObject(action.class, UUID.randomUUID().toString());
                }

                newUser.setDescription(description.getText().toString());
                newUser.setPrice(price.getText().toString());

//                newUser.setAddress(adress.getText().toString());
//                newUser.setPhone(phone.getText().toString());


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