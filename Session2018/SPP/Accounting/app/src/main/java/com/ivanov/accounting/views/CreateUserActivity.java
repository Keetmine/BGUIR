package com.ivanov.accounting.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ivanov.accounting.R;
import com.ivanov.accounting.realm.role;
import com.ivanov.accounting.realm.user;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class CreateUserActivity extends AppCompatActivity {

    EditText userLogin;
    EditText userPassword;
    Spinner spinner;

    Realm realm;

    user EditEntity;

    Boolean isEdit = false;

    String editId;
    String roleId;

    ArrayList<role> rolesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.saveUser);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEntity();
            }
        });

        this.setup();


//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//        R.array.planets_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
    }

    private void setup(){
        userLogin = (EditText) findViewById(R.id.userLogin);
        userPassword = (EditText) findViewById(R.id.userPassword);
        spinner = (Spinner) findViewById(R.id.userRole);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub

                roleId = rolesList.get(position).id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        realm = Realm.getDefaultInstance();

        rolesList = new ArrayList(realm.where(role.class).findAll());

        // Creating adapter for spinner
        ArrayAdapter<role> dataAdapter = new ArrayAdapter<role>(this, android.R.layout.simple_spinner_item, rolesList);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        Intent myIntent = getIntent();

        editId = myIntent.getStringExtra("id");

        if(!TextUtils.isEmpty(editId)){
            user User = realm.where(user.class).equalTo("id", editId).findFirst();
                if(User != null)
                {
                    isEdit = true;
                    EditEntity = User;
                }
        }

        if(EditEntity != null){
            userLogin.setText(EditEntity.getLogin());
            userPassword.setText(EditEntity.getPassword());
        }

    }

    private void createEntity(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                user newUser;

                if(editId != null){
                    newUser = bgRealm.where(user.class).equalTo("id", editId).findFirst();
                } else {
                    newUser = bgRealm.createObject(user.class, UUID.randomUUID().toString());
                }

                newUser.setLogin(userLogin.getText().toString());
                newUser.setPassword(userPassword.getText().toString());

                role selectedRole = bgRealm.where(role.class).equalTo("id", roleId).findFirst();

                newUser.setRole(selectedRole);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                ifSuccessSave();
            }
        });
    }

    private void ifSuccessSave(){
        Intent intent = new Intent(this, UsersActivity.class);
        this.startActivity(intent);

        Toast.makeText(this.getApplication(), "success add entity",
        Toast.LENGTH_LONG).show();
    }

}
