package com.example.administrator.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button start;
    private Button stop;
    private Button binderService;
    private Button unbinderService;
    MyService.DownloadBinder downloadBinder;
    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder= (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start_service);
        stop = (Button) findViewById(R.id.stop_service);
        binderService = (Button) findViewById(R.id.binder_service);
        unbinderService = (Button) findViewById(R.id.unbinder_service);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        binderService.setOnClickListener(this);
        unbinderService.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service:
                Intent startIntent=new Intent(this,MyService.class);
                startService(startIntent);
                break;//启动服务
            case R.id.stop_service:
                Intent stopIntent=new Intent(this,MyService.class);
                stopService(stopIntent);
                break;
            case R.id.binder_service:
                Intent binderIntent=new Intent(this,MyService.class);
                bindService(binderIntent,conn,BIND_AUTO_CREATE);//绑定服务
                break;
            case R.id.unbinder_service:
                Intent unbinderIntent=new Intent(this,MyService.class);
                unbindService(conn);
                break;
            default:
                break;
        }

    }
}
