package com.beerpad;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapters.SplitAdapter;
import adapters.SplitHolder;
import models.Person;
import utils.AppHelper;

/**
 * Created by luisalfonsobejaranosanchez on 5/28/17.
 */
public class SplitBeerActivity extends Activity implements SplitHolder.SplitListener {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private SplitAdapter splitAdapter;

    private List<Person> persons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.split_activity);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        persons.add(new Person("Luis","3136078321"));

        splitAdapter = new SplitAdapter(persons, this);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(splitAdapter);

    }

    @Override
    public void isSplitClicked() {
        AppHelper.screenManager.showSearchBeerScreen(this);
    }

}
