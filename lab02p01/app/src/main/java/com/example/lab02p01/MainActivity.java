package com.example.lab02p01;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int  ile =0;
    TextView licznik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        licznik = findViewById(R.id.tv_licznik);
        licznik.setText(String.valueOf(ile));

    }

    public void plus(View view) {
        ile++;
        licznik.setText(String.valueOf(ile));

    }

    public void minus(View view) {
        ile--;
        licznik.setText(String.valueOf(ile));
    }

    public void reset(View view) {
        ile=0;
        licznik.setText(String.valueOf(ile));
    }
}