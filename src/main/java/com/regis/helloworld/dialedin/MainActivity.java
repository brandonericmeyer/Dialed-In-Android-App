package com.regis.helloworld.dialedin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity  {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.drawer_open, R.string.drawer_close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.add_workout:
                        Intent addworkoutIntent = new Intent(MainActivity.this, AddActivity.class);
                        startActivity(addworkoutIntent);
                        break;
                    case R.id.remove_workout:
                        Intent removeworkoutIntent = new Intent(MainActivity.this, RemoveActivity.class);
                        startActivity(removeworkoutIntent);
                        break;
                    case R.id.modify_workout:
                        Intent viewmodifyworkoutIntent = new Intent(MainActivity.this, ModifyActivity.class);
                        startActivity(viewmodifyworkoutIntent);
                        break;
                    case R.id.generate_workout:
                        Intent generateworkoutIntent = new Intent(MainActivity.this, GenerateActivity.class);
                        startActivity(generateworkoutIntent);
                        break;
                    case R.id.share_workout:
                        Intent shareworkoutIntent = new Intent(MainActivity.this, ShareActivity.class);
                        startActivity(shareworkoutIntent);
                        break;
                    default:
                        return true;
                }


                return true;

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        } else if (id == R.id.action_hide) {
            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
            return true;
        } else if(t.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
