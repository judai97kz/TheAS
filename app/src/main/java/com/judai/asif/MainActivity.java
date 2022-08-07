package com.judai.asif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button aus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aus = findViewById(R.id.Au);
        aus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,aurorians.class);
                startActivity(intent);
            }
        });
        Toast.makeText(this,"Đã thay đổi",Toast.LENGTH_LONG).show();
        Toast.makeText(this,"Đã thay đổi 2",Toast.LENGTH_LONG).show();
    }
}