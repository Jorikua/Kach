package ua.kaganovych.kach.api;


import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import ua.kaganovych.kach.model.Result;

public class ApiClient {

    private static KachApiInterface sKachApiInterface;

    public static KachApiInterface getKachApiInterface() {
        if (sKachApiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://madiosgames.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            sKachApiInterface = retrofit.create(KachApiInterface.class);
        }
        return sKachApiInterface;
    }

    public interface KachApiInterface {
        @GET("api/v1/application/gym_exercises/category")
        Call<List<Result>> getCategories();
    }
}
