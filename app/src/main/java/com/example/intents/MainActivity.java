package com.example.intents;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int ACTIVITY3 =3;
    TextView tvmsgActivity3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName =findViewById(R.id.etName);
        Button btnActivity2 = findViewById(R.id.btnActivity2);
        Button btnActivity3 = findViewById(R.id.btnActivity3);
        btnActivity2.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view){

                String name = etName.getText().toString().trim();
                if (name.length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter name",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,
                            com.example.intents.Activity2.class);

                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            }
        });

        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.intents.Activity3.class);
                startActivityForResult(intent,ACTIVITY3);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ACTIVITY3){
            if(resultCode ==RESULT_OK){
                String surname = data.getStringExtra("surname");
                tvmsgActivity3 =findViewById(R.id.tvmsgActivity3);
                Toast.makeText(getApplicationContext(), surname+" surname", Toast.LENGTH_SHORT).show();
                tvmsgActivity3.setText(surname+" Got this from activity 3");


            }
            if(resultCode==RESULT_CANCELED){
                Toast.makeText(getApplicationContext(), " cancelled", Toast.LENGTH_SHORT).show();

            }
        }

    }
}