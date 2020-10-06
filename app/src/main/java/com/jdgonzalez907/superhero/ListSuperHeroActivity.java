package com.jdgonzalez907.superhero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.jdgonzalez907.superhero.models.SuperHero;
import com.jdgonzalez907.superhero.models.SuperHeroResult;
import com.jdgonzalez907.superhero.services.SuperHeroService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListSuperHeroActivity extends AppCompatActivity {
    private SuperHeroReciclerViewAdapter superHeroReciclerViewAdapter;
    private EditText txtNameSuperHero;
    private RecyclerView recyclerView;
    private Retrofit retrofit;
    private SuperHeroService superHeroService;
    private Call<SuperHeroResult> superHeroResultCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_super_heros);

        superHeroReciclerViewAdapter = new SuperHeroReciclerViewAdapter();

        txtNameSuperHero = (EditText) findViewById(R.id.txt_input_name_super_hero);
        prepareTxtNameSuperHero();

        recyclerView = (RecyclerView) findViewById(R.id.recicler_view_super_hero);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(superHeroReciclerViewAdapter);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.superheroapi.com/api.php/2773998626209369/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        superHeroService = retrofit.create(SuperHeroService.class);
    }

    private void prepareTxtNameSuperHero() {
        txtNameSuperHero.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                superHeroReciclerViewAdapter.setSuperHeroList(new ArrayList<SuperHero>());
                String name = s.toString();
                if(!name.isEmpty()) {
                    afterToFetchSuperHeros(name);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void afterToFetchSuperHeros(String name) {
        if(superHeroResultCall != null && superHeroResultCall.isExecuted()) {
            superHeroResultCall.cancel();
            if (superHeroResultCall.isCanceled()) {
                fetchSuperHeros(name);
            }
        }
        fetchSuperHeros(name);
    }

    private void fetchSuperHeros(String name) {
        superHeroResultCall = superHeroService.getSuperHeros(name);
        superHeroResultCall.enqueue(new Callback<SuperHeroResult>() {
            @Override
            public void onResponse(Call<SuperHeroResult> call, Response<SuperHeroResult> response) {
                if(response.body().getResults() != null){
                    superHeroReciclerViewAdapter.setSuperHeroList(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<SuperHeroResult> call, Throwable t) {
                Log.e("ERROR", "Error consultando a los super heroes", t);
            }
        });
    }
}