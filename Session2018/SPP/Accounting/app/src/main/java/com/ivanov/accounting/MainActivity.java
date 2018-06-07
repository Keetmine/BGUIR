package com.ivanov.accounting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ivanov.accounting.realm.role;
import com.ivanov.accounting.realm.user;
import com.ivanov.accounting.views.ActionTypesActivity;
import com.ivanov.accounting.views.ActionsActivity;
import com.ivanov.accounting.views.CompanyActivity;
import com.ivanov.accounting.views.EmployeeActivity;
import com.ivanov.accounting.views.GroupActivity;
import com.ivanov.accounting.views.LoginActivity;
import com.ivanov.accounting.views.ProductsActivity;
import com.ivanov.accounting.views.ReasonsActivity;
import com.ivanov.accounting.views.RolesActivity;
import com.ivanov.accounting.views.StatusesActivity;
import com.ivanov.accounting.views.UsersActivity;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Realm.init(this.getBaseContext());
        Realm.getInstance(new RealmConfiguration.Builder().build());


        realm = Realm.getDefaultInstance();

        if(realm.isEmpty()) {
            setDefaultDB();
        }

        SharedPreferences mPrefs = getSharedPreferences("login", 0);

        Boolean isLogin = mPrefs.getBoolean("login", false);
        String userId = mPrefs.getString("userId", null);

        if(!isLogin){
            Intent intent = new Intent(this, LoginActivity.class);
            this.startActivity(intent);
        } else {
            user User = realm.where(user.class).equalTo("id", userId).findFirst();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            View headerView = navigationView.getHeaderView(0);
            TextView navUsername = (TextView) headerView.findViewById(R.id.textView);
            navUsername.setText(User.getLogin());
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setDefaultDB(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                role newRole = bgRealm.createObject(role.class, UUID.randomUUID().toString());
                newRole.setName("Administrator");

                user newUser = bgRealm.createObject(user.class, UUID.randomUUID().toString());
                newUser.setLogin("Admin");
                newUser.setPassword("123");
                newUser.setRole(newRole);

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;

         if (id == R.id.nav_employees) {
            intent = new Intent(this, EmployeeActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_company) {
            intent = new Intent(this, CompanyActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_group) {
            intent = new Intent(this, GroupActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_products) {
            intent = new Intent(this, ProductsActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_users) {

            intent = new Intent(this, UsersActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_actionType) {

            intent = new Intent(this, ActionTypesActivity.class);
            this.startActivity(intent);

        } else if (id == R.id.nav_reason) {
            intent = new Intent(this, ReasonsActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_roles) {
             intent = new Intent(this, RolesActivity.class);
             this.startActivity(intent);
         } else if (id == R.id.nav_action) {
            intent = new Intent(this, ActionsActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_status) {
            intent = new Intent(this, StatusesActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_logout) {
             SharedPreferences mPrefs = getSharedPreferences("login", 0);

             SharedPreferences.Editor mEditor = mPrefs.edit();
             mEditor.putBoolean("login", false).commit();

             intent = new Intent(this, LoginActivity.class);
             this.startActivity(intent);
         }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
