package com.epam.androidlab.module2;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondModuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_module);
    }

    public void onBtnOpenFirstModuleClick(View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.epam.androidlab.custompermission", "com.epam.androidlab.custompermission.MainActivity"));
        startActivity(intent);
    }
}
