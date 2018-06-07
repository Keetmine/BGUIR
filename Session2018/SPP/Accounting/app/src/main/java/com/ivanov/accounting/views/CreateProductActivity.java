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
import com.ivanov.accounting.realm.company;
import com.ivanov.accounting.realm.group;
import com.ivanov.accounting.realm.product;
import com.ivanov.accounting.realm.role;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;

public class CreateProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
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
    Spinner companySelect;
    Spinner groupSelect;

    Realm realm;

    product EditEntity;

    Boolean isEdit = false;

    String editId;

    ArrayList<company> companyList;
    ArrayList<group> groupList;

    private void setup(){
        nameEdit = (EditText) findViewById(R.id.name);
        descriptionEdit = (EditText) findViewById(R.id.description);
        companySelect = (Spinner) findViewById(R.id.company);
        groupSelect = (Spinner) findViewById(R.id.group);

        realm = Realm.getDefaultInstance();


        companyList = new ArrayList(realm.where(company.class).findAll());
        groupList = new ArrayList(realm.where(group.class).findAll());

        // Creating adapter for spinner
        ArrayAdapter<company> dataAdapter = new ArrayAdapter<company>(this, android.R.layout.simple_spinner_item, companyList);
        ArrayAdapter<group> dataAdapter2 = new ArrayAdapter<group>(this, android.R.layout.simple_spinner_item, groupList);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        companySelect.setAdapter(dataAdapter);
        groupSelect.setAdapter(dataAdapter2);

        Intent myIntent = getIntent();

        editId = myIntent.getStringExtra("id");

        if(!TextUtils.isEmpty(editId)){
            product Entity = realm.where(product.class).equalTo("id", editId).findFirst();
            if(Entity != null)
            {
                isEdit = true;
                EditEntity = Entity;
            }
        }

        if(EditEntity != null){
            nameEdit.setText(EditEntity.getName());
            descriptionEdit.setText(EditEntity.getDescription());
        }

    }

    private void createEntity(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                product newUser;

                if(editId != null){
                    newUser = bgRealm.where(product.class).equalTo("id", editId).findFirst();
                } else {
                    newUser = bgRealm.createObject(product.class, UUID.randomUUID().toString());
                }

                newUser.setName(nameEdit.getText().toString());
                newUser.setDescription(descriptionEdit.getText().toString());


            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                ifSuccessSave();
            }
        });
    }

    private void ifSuccessSave(){
        Intent intent = new Intent(this, ProductsActivity.class);
        this.startActivity(intent);

        Toast.makeText(this.getApplication(), "success add entity",
                Toast.LENGTH_LONG).show();
    }

}
