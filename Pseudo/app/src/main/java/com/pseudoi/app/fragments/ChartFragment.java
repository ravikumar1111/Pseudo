package com.pseudoi.app.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.pseudoi.app.R;
import com.pseudoi.app.adapter.BeerChartRecyclerView;
import com.pseudoi.app.com.pseudoi.app.utils.Utilities;
import com.pseudoi.app.dao.AppDatabase;
import com.pseudoi.app.model.BeerCraft;
import com.pseudoi.app.ui.main.MainFragment;
import com.pseudoi.app.ui.main.MainViewModel;
import com.pseudoi.app.webservice.APIClient;
import com.pseudoi.app.webservice.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartFragment extends Fragment {

    private MainViewModel mViewModel;
    private APIInterface apiInterface;
    private BeerChartRecyclerView recyclerViewAdapter;
    private RecyclerView recyclerView;
    private List<BeerCraft> beerList = new ArrayList<BeerCraft>();
    private ArrayAdapter<String> beerNameAutoSearchAdapter = null;
    private AutoCompleteTextView nameAutoCompleteTextView = null;
    private AppDatabase db;
    private List<BeerCraft> contacts = null;

    private AppDatabase movieDatabase;
    public static ChartFragment newInstance() {
        return new ChartFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        GetBeerCraftData();
    }

    private void initView(){
        getActivity().findViewById(R.id.nameAutoCompleteTextView).setVisibility(View.GONE);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.beerChartRecyclerView);
        recyclerViewAdapter = new BeerChartRecyclerView(beerList, true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        db = Room.databaseBuilder(getActivity(), AppDatabase.class, "database").build();
        beerNameAutoSearchAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.select_dialog_item, new ArrayList<String>());

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    private void GetBeerCraftData(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                movieDatabase = Room.databaseBuilder(getContext(),
                        AppDatabase.class, Utilities.DATABASE_NAME).fallbackToDestructiveMigration().build();

                beerList =  movieDatabase.beerDao().getBeerCrafByStatus("Order");
                Log.d("","beerListData:: "+ beerList.size());
                recyclerViewAdapter.UpdateData(beerList, getActivity());
            }
        }) .start();

    }
}