package com.example.graphicevent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.button_red:
                MyView.setPaintColor(Color.RED);
                break;
            case R.id.button_green:
                MyView.setPaintColor(Color.GREEN);
                break;
            case R.id.button_blue:
                MyView.setPaintColor(Color.BLUE);
                break;
        }
    }

}
