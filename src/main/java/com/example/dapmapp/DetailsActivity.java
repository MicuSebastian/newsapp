package com.example.dapmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView title, description;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Folosim id-ul pentru gasirea elementelor din activity_details
        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        //getData este folosit pentru a prelua datele din intent
        getData();
        //setData seteaza datele pentru elemetele (TextView si ImageView)
        setData();
    }

    private void getData() {
        //Verificam daca exista date in intent
        if (getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        }
        //Daca nu exista afisam un mesaj simplu de tip popUp
        else {
            //Toasta contine activitate, mesaj si durata afisarii
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        //setData seteaza datele pentru elemetele (TextView si ImageView)
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }
}