package com.jdgonzalez907.superhero.services;

import com.jdgonzalez907.superhero.models.SuperHeroResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperHeroService {
    String API_ROUTE = "search/{name}";

    @GET(API_ROUTE)
    Call<SuperHeroResult> getSuperHeros(@Path("name") String name);
}
