package com.mobisigma.webviewglsample;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebview = (WebView)findViewById(R.id.webview);
        mWebview.setWebViewClient(new WebViewClient());
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.setBackgroundColor(Color.TRANSPARENT);
        mWebview.loadUrl("http://www.cnn.com");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // The below modelview matrix and projection matrix data are obtained from openGL code
                float[] modelViewMatrixData = {-0.037363f, -0.883836f, 0.466301f, 0.000000f, -0.998281f, 0.011926f, -0.057385f, 0.000000f, 0.045158f, -0.467644f, -0.882763f, 0.000000f, 7.434665f, -4.837492f, 276.385986f, 1.000000f};
                float[] projectionMatrixData = {0.000000f, -1.649297f, 0.000000f, 0.000000f, -2.940194f, 0.000000f, 0.000000f, 0.000000f, 0.026083f, 0.011500f, 1.004008f, 1.000000f, 0.000000f, 0.000000f, -20.040081f, 0.000000f};

                // Help needed: How to calculate below parameters from modelview matrix and projection matrix above
                // so that webview overlays (pins to) the image drawn in openGL?

                // below are some dummy values to illustrated how I position the webview:
                float scaleX = 0.5f;
                float scaleY = 0.2f;
                float x = 10f;
                float y = 100f;
                float rotationZ = 5f;
                float rotationX = 0f;
                float rotationY = 25f;
                mWebview.animate()
                        .scaleX(scaleX)
                        .scaleY(scaleY)
                        .x(x)
                        .y(y)
                        .rotation(rotationZ)
                        .rotationX(rotationX)
                        .rotationY(rotationY);
            }
        }, 5000);
    }
}
