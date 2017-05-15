package com.example.administrator.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017-5-15.
 */

public class MyService extends Service {
    private DownloadBinder binder=new DownloadBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    //服务创建的时候调用
    @Override
    public void onCreate() {
        super.onCreate();
    }
    //服务启动的时候调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
    //服务销毁的时候调用
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("Myservice","startDownload executed");
        }
        public int getProgress(){
            Log.d("Myservice","getProgress executed");
            return 0;
        }
    }
}
