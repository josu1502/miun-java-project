package com.miun.appguestbook.josu1502.appguestbook.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Joakim on 17-02-16.
 */

public interface GitHubClient {
    @GET("beans.entities.lunchentity")
    Call<List<LunchEntity>> getLunches();
}
