package dev.gladkowski.mdb.utils.network;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.IOException;

import dev.gladkowski.mdb.R;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Interceptor that adds language query parameter
 */
public class LanguageInterceptor implements Interceptor {

    private Context context;

    public LanguageInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        HttpUrl url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("language", context.getString(R.string.language_en_us))
                .build();

        Request request = chain.request().newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
