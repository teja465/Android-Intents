package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    Button btnActivity1;
    EditText etSurname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        etSurname =findViewById(R.id.etSurname);
        btnActivity1= findViewById(R.id.btnActivity1);
        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String surname = etSurname.getText().toString().trim();
                if(surname.length()==0){
                    Toast.makeText(getApplicationContext(),"Please type surname ",Toast.LENGTH_SHORT).show();
                    return;
                }
                // Intent intent = new Intent(Activity3.this,com.example.intents.MainActivity.class);
                Intent intent = new Intent();
                intent.putExtra("surname",surname);
                Log.d("putting surname",surname);
                setResult(RESULT_OK,intent);
                Activity3.this.finish();
            }
        });
    }
}