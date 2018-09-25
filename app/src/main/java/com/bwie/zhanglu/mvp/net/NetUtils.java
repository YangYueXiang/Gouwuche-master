package com.bwie.zhanglu.mvp.net;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.mvp.net
 * @time 2018/9/22 9:48
 */
public class NetUtils {
    private static final NetUtils ourInstance = new NetUtils();
    private OkHttpClient okHttpClient;

    public static NetUtils getInstance() {
        return ourInstance;
    }
    private Handler mhandler;

       /* okHttpClient = new OkHttpClient
                .Builder()
                .build();*/


    class longinterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = chain.request().newBuilder().addHeader("source", "android");
            Log.d("xxx", "request:" + request);
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }

    private NetUtils() {
        okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new longinterceptor())
                .build();

        mhandler = new Handler(Looper.getMainLooper());
    }

    public void get(String url, final Callback callback){

        final Request request = new Request
                .Builder()
                .url(url)
                .build();

        mhandler.post(new Runnable() {
            @Override
            public void run() {
                if (okHttpClient != null){
                    okHttpClient.newCall(request).enqueue(callback);
                }
            }
        });
    }


    public void post(String url, FormBody formBody, final Callback callback){

        final Request request = new Request
                .Builder()
                .post(formBody)
                .url(url)
                .build();

        mhandler.post(new Runnable() {
            @Override
            public void run() {
                if (okHttpClient != null){
                    okHttpClient.newCall(request).enqueue(callback);
                }
            }
        });
    }
}
