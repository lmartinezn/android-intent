package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText message;
    private final int MY_REQUEST_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        message = findViewById(R.id.message);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameLocal = name.getText().toString();
                String messageLocal = message.getText().toString();

                Log.d("VCA", "Message sent! " + nameLocal +  ", " + messageLocal);

                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                intent.putExtra("name", nameLocal);
                intent.putExtra("message", messageLocal);

                // startActivity(intent);
                startActivityForResult(intent, MY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == MY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Log.d("VCA", "Result OK");
            } else {
                Log.d("VCA", "Result CANCELED");
            }
        }
    }
}
