package com.sports.tech;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("/PartLine/GetAllFeedGames1xstavka")
    Call<List<Answer>> getAns(@Query("sportid") int id);

}
