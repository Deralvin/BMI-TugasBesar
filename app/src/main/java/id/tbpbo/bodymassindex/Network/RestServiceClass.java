package id.tbpbo.bodymassindex.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestServiceClass {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(2,TimeUnit.MINUTES)
                .readTimeout(180, TimeUnit.SECONDS)
                .connectTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://bmi-unikom.000webhostapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

        }
        return retrofit;
    }
    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}
