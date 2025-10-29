package com.example.lab03p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText pole_a, pole_b, pole_c;
    TextView pole_wynik;
    Button btn_oblicz, btn_reset;

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
        znajdz_uchwyty();
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pole_a.setText("");
                pole_b.setText("");
                pole_c.setText("");
                pole_wynik.setText("");
            }
        });
        btn_oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                double a = Double.parseDouble(pole_a.getText().toString());
//                double b = Double.parseDouble(pole_b.getText().toString());
//                double c = Double.parseDouble(pole_c.getText().toString());
                double a=0, b=0, c=0;
                String temp;
                temp = pole_a.getText().toString();
                if (temp.isEmpty()) {
                    pole_a.setError("Pole nie może być puste");
                    Toast.makeText(MainActivity.this, "Pole \"a\" nie może być puste", Toast.LENGTH_SHORT).show();
                    return;
                }
                a = Double.parseDouble(temp);
                temp = pole_b.getText().toString();
                if (temp.isEmpty()) {
                    pole_b.setError("Pole nie może być puste");
                    Toast.makeText(MainActivity.this, "Pole \"b\" nie może być puste", Toast.LENGTH_SHORT).show();
                    return;
                }
                b = Double.parseDouble(temp);
                temp = pole_c.getText().toString();
                if (temp.isEmpty()) {
                    pole_c.setError("Pole nie może być puste");
                    Toast.makeText(MainActivity.this, "Pole \"c\" nie może być puste", Toast.LENGTH_SHORT).show();
                    return;
                }
                c = Double.parseDouble(temp);



                pole_wynik.setText(oblicz_wynik(a,b,c));

            }
        });
    }

//    private String oblicz_wynik(double a, double b, double c) {
//        double delta = b * b - 4 * a * c;
//        if(delta >0)
//            return "x1=" + (-b + Math.sqrt(delta)) / (2 * a) + "\nx2=" + (-b - Math.sqrt(delta)) / (2 * a);
//        else if(delta == 0)
//            return "x0" + (-b + Math.sqrt(delta)) / (2 * a);
//        else
//            return "Brak rozwiązań";
//    }

    private String oblicz_wynik(double a, double b, double c) {
        if(a==0) return "Nie jest to równanie kwadratowe";
        double delta = b * b - 4 * a * c;
        if(delta < 0)
            return "Brak rozwiązań";
        if(delta == 0){
            double wynik = (-b) / (2 * a);
            wynik = Math.round(wynik*10000) / 10000.0;
            return "x0=" + wynik;
        }
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        x1 = Math.round(x1*10000) / 10000.0;
        x2 = Math.round(x2*10000) / 10000.0;

        return "x1=" + x1 +"\nx2=" + x2;

    }

    private void znajdz_uchwyty() {
        pole_a = findViewById(R.id.et_a);
        pole_b = findViewById(R.id.et_b);
        pole_c = findViewById(R.id.et_c);
        pole_wynik = findViewById(R.id.tv_wynik);
        btn_oblicz = findViewById(R.id.btn_licz);
        btn_reset = findViewById(R.id.btn_reset);
    }
}