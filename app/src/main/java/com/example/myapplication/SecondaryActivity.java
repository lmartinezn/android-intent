package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    private TextView name;
    private TextView message;
    private Button buttonOk;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        name = findViewById(R.id.secName);
        message = findViewById(R.id.secMessage);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        message.setText(intent.getStringExtra("message"));

        buttonOk = findViewById(R.id.buttonOk);
        buttonCancel = findViewById(R.id.buttonCancel);


        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("result", "hola");
                setResult(RESULT_OK, result);
                finish();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("result", "adeu");
                setResult(RESULT_CANCELED, result);
                finish();
            }
        });

    }
}
