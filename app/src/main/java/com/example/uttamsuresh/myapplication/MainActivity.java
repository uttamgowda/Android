package com.example.uttamsuresh.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static String LOG = "ACTIVITY_LIFE_CYCLE";
    EditText editText;
    Button explicitButton, implicitIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG,"onCreate() method Started...");
        editText = findViewById(R.id.editText);
        explicitButton = findViewById(R.id.ExplicitIntent);
        implicitIntent = findViewById(R.id.ImplicitIntent);
        explicitButton.setOnClickListener(this);
        implicitIntent.setOnClickListener(this);
    }

    // Example for How savedInstanceState Works
 /*   @Override
    public  void onSaveInstanceState(Bundle onSaveState){
        //onSaveState.putString("TEXT_VIEW_KEY", editText.getText().toString());
        super.onSaveInstanceState(onSaveState);
    }
    @Override
    public void onRestoreInstanceState(Bundle onSavedState){
      //  editText.setText(onSavedState.getString("TEXT_VIEW_KEY"));
    }*/
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(LOG, "onStart() method Started ...");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(LOG,"onResume() method started....");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(LOG, "onPause() method started....");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(LOG, "onStop() method started....");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(LOG, "onDestroy method started()....");
    }
    @Override
    public void onClick(View v) {
        // Intent Example
        if(v.getId() == explicitButton.getId()) {
            Intent intent = new Intent(this, ActivitySecond.class);
            intent.putExtra("TEXT", "Hello Uttam");
            startActivityForResult(intent,1);
        }else if(v.getId() == implicitIntent.getId()){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ebookfrenzy.com"));
                startActivity(intent);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1 && resultCode == 2){
            Toast.makeText(this, data.getExtras().getString("RETURN_TEXT"), Toast.LENGTH_SHORT).show();
            editText.setText(data.getExtras().getString("RETURN_TEXT"));
        }
    }
}
