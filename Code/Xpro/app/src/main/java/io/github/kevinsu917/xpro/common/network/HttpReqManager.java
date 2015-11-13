package io.github.kevinsu917.xpro.common.network;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.StringEntity;
import io.github.kevinsu917.xpro.common.config.NetConfig;

/**
 * Creator: KevinSu kevinsu917@126.com
 * Date 2015-11-08-18:28
 * Description:
 */
public class HttpReqManager {

    private static HttpReqManager mInstance;
    private static AsyncHttpClient mClient;
    private static Context appContext;

    private HttpReqManager() {

    }

    public static HttpReqManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new HttpReqManager();
            appContext = context.getApplicationContext();
            mClient = new AsyncHttpClient();
        }
        return mInstance;
    }


    public void requet(){

//        mClient.post(NetConfig.Host, null, new AsyncHttpResponseHandler(){
//
//            @Override
//            public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {
//
//            }
//
//            @Override
//            public void onSuccess(int i, org.apache.http.Header[] headers, byte[] bytes) {
//
//            }
//        });
        RequestParams params = new RequestParams();
        params.put("username", "kevin");
        params.put("password", "123456");

        String json = "{\"a\":1}";
        String contentType = ContentType.APPLICATION_JSON.getMimeType();

        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(json);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        mClient.get(appContext, NetConfig.Host, stringEntity, contentType, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {
                    String respStr = new String(responseBody, "utf-8");
                    Log.e("HttpReqManager", respStr);

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                try {
                    String respStr = new String(responseBody, "utf-8");
                    Log.e("HttpReqManager", respStr);

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}
