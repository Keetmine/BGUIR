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
import com.ivanov.accounting.realm.reason;

import java.util.UUID;

import io.realm.Realm;

public class CreateActionTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_action_type);
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

    Realm realm;

    actionType EditEntity;

    Boolean isEdit = false;

    String editId;


    private void setup(){
        nameEdit = (EditText) findViewById(R.id.name);
        descriptionEdit = (EditText) findViewById(R.id.description);

        realm = Realm.getDefaultInstance();

        Intent myIntent = getIntent();

        editId = myIntent.getStringExtra("id");

        if(!TextUtils.isEmpty(editId)){
            actionType Entity = realm.where(actionType.class).equalTo("id", editId).findFirst();
            if(Entity != null)
            {
                isEdit = true;
                EditEntity = Entity;
            }
        }

        if(EditEntity != null){
            nameEdit.setText(EditEntity.getName());
            descriptionEdit.setText(EditEntity.getDescriptioin());
        }

    }

    private void createEntity(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                actionType newUser;

                if(editId != null){
                    newUser = bgRealm.where(actionType.class).equalTo("id", editId).findFirst();
                } else {
                    newUser = bgRealm.createObject(actionType.class, UUID.randomUUID().toString());
                }

                newUser.setName(nameEdit.getText().toString());
                newUser.setDescriptioin(descriptionEdit.getText().toString());


            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                ifSuccessSave();
            }
        });
    }

    private void ifSuccessSave(){
        Intent intent = new Intent(this, ActionTypesActivity.class);
        this.startActivity(intent);

        Toast.makeText(this.getApplication(), "success add entity",
                Toast.LENGTH_LONG).show();
    }

}