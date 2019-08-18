package flickagram.com.flickagram.network.manager;

import android.arch.lifecycle.extensions.BuildConfig;

import java.util.concurrent.TimeUnit;

import flickagram.com.flickagram.constants.AppConstants;
import flickagram.com.flickagram.network.service.FlickGarmService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlickGramRetrofitManager {

    private static final int TIME_OUT = 1;
    public static final FlickGarmService FLICK_SERVICE;

    static {

        OkHttpClient.Builder flickrCLientBuilder = new OkHttpClient.Builder()
                .readTimeout(TIME_OUT, TimeUnit.MINUTES)
                .writeTimeout(TIME_OUT, TimeUnit.MINUTES)
                .connectTimeout(TIME_OUT, TimeUnit.MINUTES);

        if (BuildConfig.DEBUG) {
            flickrCLientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(flickrCLientBuilder.build()).build();

        FLICK_SERVICE = retrofit.create(FlickGarmService.class);

    }

}
