package com.kinhub.iapmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kinhub.iap.IapInitException;
import com.kinhub.iap.IapManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private IapManager iapManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iapManager = new IapManager("GCQDQLUN4IFF35A5Z2VJ4Y7BIXR55RATNUDXRFP3WGRJVXID2WXG47U2");
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    private void startIapService(){
        try {
            iapManager.start(this);
        } catch (IapInitException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v){
        if (v == button){
            startIapService();
        }
    }

}
