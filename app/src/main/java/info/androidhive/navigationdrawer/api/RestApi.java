package info.androidhive.navigationdrawer.api;

import java.util.concurrent.TimeUnit;

import info.androidhive.navigationdrawer.BuildConfig;
import info.androidhive.navigationdrawer.klasi.Photos;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anti on 1/16/2018.
 */

public class RestApi {

    public static final int request_max_time_in_seconds = 20;

    public Retrofit getRetrofitInstance()

    {

        OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(request_max_time_in_seconds, TimeUnit.SECONDS)
            .connectTimeout(request_max_time_in_seconds, TimeUnit.SECONDS)
            .build();

        return  new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }
    public ApiService request ()
    {
        return getRetrofitInstance().create(ApiService.class);

    }

    public Call<Photos> getPhotos (String a)
    {

        return request().getPhotos(a);
    }


}
