package com.pseudoi.app.ui.main;

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
import com.pseudoi.app.dao.AppDatabase;
import com.pseudoi.app.model.BeerCraft;
import com.pseudoi.app.webservice.APIClient;
import com.pseudoi.app.webservice.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private APIInterface apiInterface;
    private BeerChartRecyclerView recyclerViewAdapter;
    private RecyclerView recyclerView;
    private List<BeerCraft> beerList = new ArrayList<BeerCraft>();
    private ArrayAdapter<String> beerNameAutoSearchAdapter = null;
    private AutoCompleteTextView nameAutoCompleteTextView = null;
    private AppDatabase db;
    private List<BeerCraft> contacts = null;


    public static MainFragment newInstance() {
        return new MainFragment();
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
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.beerChartRecyclerView);
        recyclerViewAdapter = new BeerChartRecyclerView(beerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        db = Room.databaseBuilder(getActivity(), AppDatabase.class, "database").build();
        beerNameAutoSearchAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.select_dialog_item, new ArrayList<String>());
        //Getting the instance of AutoCompleteTextView
        nameAutoCompleteTextView = (AutoCompleteTextView) getActivity().findViewById(R.id.nameAutoCompleteTextView);
        nameAutoCompleteTextView.setThreshold(1);//will start working from first character
        nameAutoCompleteTextView.setAdapter(beerNameAutoSearchAdapter);//setting the adapter data into the AutoCompleteTextView

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    private void GetBeerCraftData(){

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<BeerCraft>> call1 = apiInterface.doGetBeerCraft();
        call1.enqueue(new Callback<List<BeerCraft>>() {
            @Override
            public void onResponse(Call<List<BeerCraft>> call, Response<List<BeerCraft>> response) {
                beerList  = response.body();
                Log.d("Response::","Count:::"+beerList.size());
               // Collections.sort(beerList, (p1, p2) -> p1.getAbv().compareTo(p2.getAbv()));
                recyclerViewAdapter.UpdateData(beerList);
            }

            @Override
            public void onFailure(Call<List<BeerCraft>> call, Throwable t) {

            }
        });
    }
}
