package com.moringaschool.live_cleanliness.networks;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
public interface PostgresqlAPI {

    @GET("category")
    Call<PostgresqlAPI> getName(

            @Query("name") String name,
            @Query("user") int user
    ) ;
//    @POST("category")
//   Call<PostgresqlAPI> createPost(@Body PostgresqlApiUse apiUse)
//
//
//
    }

