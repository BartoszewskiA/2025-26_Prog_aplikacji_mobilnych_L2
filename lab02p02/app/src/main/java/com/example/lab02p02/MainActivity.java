package com.example.lab02p02;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int a,b,wynik;
    TextView dzialanie, odpowiedz;
    Random random = new Random();

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
        dzialanie = findViewById(R.id.tv_dzialanie);
        odpowiedz = findViewById(R.id.tv_odpowiedz);
        wylosuj();
    }

    private void wylosuj() {
        a = random.nextInt(100);
        b = random.nextInt(100);
        if(random.nextBoolean())
            wynik = a * b;
        else
            wynik = random.nextInt(10000);
        dzialanie.setText(a + " * " + b + " = " + wynik);
    }

    public void czy_prawda(View view) {
        if(wynik == a*b)
            odpowiedz.setText("Masz rację");
        else
            odpowiedz.setText("Nie masz racji");
        }

    public void czy_falsz(View view) {
        if(wynik != a*b)
            odpowiedz.setText("Masz rację");
        else
            odpowiedz.setText("Nie masz racji");
    }

    public void reset(View view) {
        wylosuj();
        odpowiedz.setText("");
    }
}