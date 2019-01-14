package com.example.uttamsuresh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView =  findViewById(R.id.textView);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String value = data.getString("TEXT");
        textView.setText(value);
    }

    @Override
    public void finish(){
        Intent intent = new Intent();
        intent.putExtra("RETURN_TEXT", "All Ok...!");
        setResult(2,intent);
        super.finish();
    }

}
