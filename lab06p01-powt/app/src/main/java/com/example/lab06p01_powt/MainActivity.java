package com.example.lab06p01_powt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText et_a, et_b;
    TextView tv_wynik;
    Button btn_oblicz;
    RadioButton rb_prostokat, rb_kwadrat;
    RadioGroup rg_01;

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

        et_a = findViewById(R.id.et_a);
        et_b = findViewById(R.id.et_b);
        tv_wynik = findViewById(R.id.tv_wynik);
        btn_oblicz = findViewById(R.id.button);
        rb_prostokat = findViewById(R.id.rb_prostokat);
        rb_kwadrat = findViewById(R.id.rb_kwadrat);
        rg_01 = findViewById(R.id.rg_01);

        rg_01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_prostokat)
                {
                    et_b.setVisibility(View.VISIBLE);
                }
                else if(checkedId == R.id.rb_kwadrat)
                {
                    et_b.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(rb_prostokat.isChecked())
               {
                   if(et_a.getText().toString().isEmpty() || et_b.getText().toString().isEmpty())
                   {
                       tv_wynik.setText("Wprowadź dane");
                       return;
                   }
                   double a = Double.parseDouble(et_a.getText().toString());
                   double b = Double.parseDouble(et_b.getText().toString());
                   double wynik = a * b;
                   tv_wynik.setText("Pole prostokąta = "+ String.valueOf(wynik));
               }
               else if (rb_kwadrat.isChecked())
               {
                   if(et_a.getText().toString().isEmpty())
                   {
                       tv_wynik.setText("Wprowadź dane");
                       return;
                   }
                   double a = Double.parseDouble(et_a.getText().toString());
                   double wynik = a * a;
                   tv_wynik.setText("Pole kwadratu = "+ String.valueOf(wynik));
               }
            }
        });


    }
}