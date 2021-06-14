package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mAddressEdit;
    private Button mMoveButton;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAddressEdit = findViewById(R.id.address_edit);
        mMoveButton = findViewById(R.id.move_button);
        mWebView = findViewById(R.id.web_view);


        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                Toast.makeText(MainActivity.this, "Loading Finished", Toast.LENGTH_SHORT).show();
            }
        });


        mMoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = mAddressEdit.getText().toString();

                if (!address.startsWith("https://")){
                    address = "https://" + address;
                }

                mWebView.loadUrl(address);

            }
        });
    }


}