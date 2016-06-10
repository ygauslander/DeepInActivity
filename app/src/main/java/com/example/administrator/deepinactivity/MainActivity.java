package com.example.administrator.deepinactivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //onCreate(),onSavedInstance(),onRestoreInstance(),配合使用，
    // 保存Activity被系统销毁前的数据，并重新使用
    private EditText edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("TAG", "onCreate()");
        super.onCreate(savedInstanceState);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean isOpen=imm.isActive();//isOpen若返回true，则表示输入法打开
        Toast.makeText(MainActivity.this, "isOpen="+isOpen, Toast.LENGTH_SHORT).show();
        LayoutInflater.from(this);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.main_edittext);
        if (savedInstanceState != null) {
            String msg = savedInstanceState.getString("msg");
          //  edit.setText(msg);
        }
    }

    @Override
    protected void onStart() {
        Log.e("TAG", "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e("TAG", "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("TAG", "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("TAG", "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("TAG", "onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.e("TAG", "onRestart()");
        super.onRestart();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("TAG", "onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.e("TAG", "onSaveInstanceState()");
        super.onSaveInstanceState(outState, outPersistentState);
        String msg = edit.getText().toString();
        outState.putString("msg", msg);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e("TAG", "onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String msg = savedInstanceState.getString("msg");
            if (msg != null) {
               edit.setText(msg);
            }
        }
    }
}
