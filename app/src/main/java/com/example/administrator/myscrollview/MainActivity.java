package com.example.administrator.myscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   private MyScrollView myScrollView;
    private int ids[] = { R.drawable.a2, R.drawable.a3,
            R.drawable.a4, R.drawable.a5, R.drawable.a6 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myScrollView= (MyScrollView) findViewById(R.id.scrollView);
        for(int i=0;i <ids.length; i++ ){
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setBackgroundResource(ids[i]);
            myScrollView.addView(imageView);

        }
    }
}
