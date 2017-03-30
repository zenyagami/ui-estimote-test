package com.zenkun.beaconcode;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zenkun.beaconcode.adapter.AdapterCoffee;
import com.zenkun.beaconcode.util.Utils;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.content_coffe_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //mRecyclerView.getLayoutManager().setAutoMeasureEnabled(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        AdapterCoffee adapterCoffee = new AdapterCoffee(Utils.getRandomCoffeData());
        mRecyclerView.setAdapter(adapterCoffee);
        findViewById(R.id.main_close_help).setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),R.string.action_settings,Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.main_close_help:
                closeHelperView();
                break;
        }
    }

    private void closeHelperView() {
        //TODO maybe store in preferences to not show this view every time....
        findViewById(R.id.view_help_holder).setVisibility(View.GONE);
    }
}
